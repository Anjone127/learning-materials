package a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gjy
 * @since 2019/07/11
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		Map<Integer,Integer> map = new ConcurrentHashMap<Integer,Integer>();
		ThreadPut threadPut = new ThreadPut(map);
		threadPut.setName("xixixi");
		ThreadPut threadPut2 = new ThreadPut(map);
		threadPut.setName("xixixi2");

		ThreadPut threadPut3 = new ThreadPut(map);
		threadPut.setName("xixixi3");
		ThreadPut threadPut4 = new ThreadPut(map);
		threadPut.setName("xixixi4");
		threadPut.join();
		threadPut.start();
		threadPut2.start();
		threadPut3.start();
		threadPut4.start();
		ThreadGet threadGet = new ThreadGet(map);
		threadGet.start();
	}
}
