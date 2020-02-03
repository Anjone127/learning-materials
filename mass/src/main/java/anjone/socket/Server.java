package anjone.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author anjone
 */
public class Server {

    private static boolean Flag = true;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(20006);
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        while (Flag) {
            Socket client = server.accept();
            System.out.println("与客户端连接成功！");
            threadPool.execute(new ServerThread(client));
        }
        threadPool.shutdown();
        server.close();
    }
}
