package thread;

public class ThreadSimpleAWait extends Thread {

	String synStr;

	ThreadSimpleAWait(String synStr){
		this.synStr = synStr;
	}
	@Override
	public void run(){
		try {
			synchronized (synStr){
				System.out.println("miaomiaomiao");
				synStr.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
