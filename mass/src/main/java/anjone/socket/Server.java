package anjone.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author anjone
 */
public class Server {

	private static boolean Flag = true;

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(20006);
		Socket client = null;
		ThreadFactory namedThreadFactory = new ServerThreadFactory();
		ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
		while(Flag){
			client = server.accept();
			System.out.println("与客户端连接成功！");
			singleThreadPool.execute(new ServerThread(client));
		}
		singleThreadPool.shutdown();
		server.close();
	}
}
