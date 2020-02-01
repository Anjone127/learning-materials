package thread;

public class DemoInterrupte {

	public static void main(String[] args) throws InterruptedException{
		LockObj lockObj = new LockObj();

		Thread tWait = new ThreadSimpleAWait("test"),
				tJoin =new ThreadSimpleJoin(tWait);
		tWait.start();
		Thread.sleep(1000);
	}
}

