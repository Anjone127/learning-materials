package a;

import java.util.Map;

/**
 * @author gjy
 * @since 2019/07/11
 */
public class ThreadPut extends Thread {
	Map<Integer,Integer> map;
	ThreadPut(Map m){
		this.map = m;
	}

	@Override
	public void run() {
		int i = 1;
		while(true) {
			map.put(i, i);
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
