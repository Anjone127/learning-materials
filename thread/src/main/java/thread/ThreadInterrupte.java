package thread;

public class ThreadInterrupte extends Thread {

	@Override
	public void run(){
		Thread.interrupted();
	}
}
