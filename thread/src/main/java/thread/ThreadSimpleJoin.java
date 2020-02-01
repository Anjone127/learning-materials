package thread;

/**
 * @author gjy
 * @since 2019/03/27
 */
public class ThreadSimpleJoin extends Thread{
	Thread thread;

	ThreadSimpleJoin(Thread t){
		this.thread = t;
	}

	@Override
	public void run(){
		try {
			thread.join();
			this.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
