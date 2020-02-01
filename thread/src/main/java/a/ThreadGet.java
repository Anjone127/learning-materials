package a;

import java.util.Map;

/**
 * @author gjy
 * @since 2019/07/11
 */
public class ThreadGet extends Thread {
	Map<Integer,Integer> map;
	ThreadGet(Map m){
		this.map = m;
	}

	@Override
	public void run() {
		int i = 1;
		while(true) {
			System.out.println(map.size());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
