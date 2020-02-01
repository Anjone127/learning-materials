package thread;


public class Heh{

	public static void main(String[] args) throws InterruptedException {
		String str = "1";
		new TW(str).start();
//		new TW("2").start();
//		new TN(str).start();
		new TN(str).start();
		Thread.sleep(10000);
	}
}


class TW extends Thread {

	private final Object lock;

	public TW(Object lock){
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock){
			try {
				System.out.println(lock.toString() + ": TWait 1");
				lock.wait();
				System.out.println(lock.toString() + ": TWait 2");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TN extends Thread{
	private Object lock;

	public TN(Object lock){
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println(lock.toString() + ": TNotify 1");
			lock.notify();
			System.out.println(lock.toString() + ": TNotify 2");
		}
	}
}