package thread;

class ThreadLockObjB extends Thread{

	private LockObj lock;

	ThreadLockObjB(LockObj lock, String threadName){
		super(threadName);
		this.lock = lock;
	}

	@Override
	public void run(){
		try {
			lock.synMethod2(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
