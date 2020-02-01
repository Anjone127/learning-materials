package thread;

public class DemoSycnMethod {
	public static void main(String[] args) throws InterruptedException{
		LockObj lockObj = new LockObj();
		new ThreadLockObjA(lockObj, "thread1").start();
		new ThreadLockObjB(lockObj, "thread2").start();
		Thread.sleep(10000);
	}
}





