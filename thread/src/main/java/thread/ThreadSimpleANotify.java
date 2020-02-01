package thread;

public class ThreadSimpleANotify extends Thread {

	String synStr;
	@Override
	public void run(){
		synchronized (synStr){
			System.out.println("miaomiaomiao");
			synStr.notify();
		}
	}
}
