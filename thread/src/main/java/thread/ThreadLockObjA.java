package thread;

class ThreadLockObjA extends Thread{

	private LockObj lock;

	ThreadLockObjA(){}

	ThreadLockObjA(LockObj lock, String threadName){
		super(threadName);
		this.lock = lock;
	}

	@Override
	public void run(){
		try {
			lock.synMethod(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
