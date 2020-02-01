package thread;

public class JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		MyThread a = new MyThread("1", null);
		MyThread b = new MyThread("2", a);
		MyThread c = new MyThread("3", b);
		MyThread d = new MyThread("4", c);
		MyThread e = new MyThread("5", d);
		e.start();
		e.join();
	}
}

class MyThread extends Thread{

	private String a ;
	private MyThread myThread;

	MyThread(String a , MyThread myThread){
		this.a = a;
		this.myThread = myThread;
	}

	@Override
	public void run(){
		try {
			Thread.sleep(1000L);
			if(myThread != null) {
				myThread.start();
				System.out.println(a +" join");
				myThread.join();
				System.out.println(a +" after join");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
