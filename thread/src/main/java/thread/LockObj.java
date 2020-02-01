package thread;

class LockObj{
	synchronized void synMethod(Thread t) throws InterruptedException{
		System.out.println(t.getName() + "synMethod before sleep()");
		Thread.sleep(3000);
		System.out.println(t.getName() + "synMethod before wait()");
		this.wait();
		System.out.println(t.getName() + "synMethod after wait()");
	}

	synchronized void synMethod2(Thread t) throws InterruptedException{
		System.out.println(t.getName() + "synMethod2 before sleep()");
		Thread.sleep(3000);
		System.out.println(t.getName() + "synMethod2 before wait()");
		this.wait();
		System.out.println(t.getName() + "synMethod2 after wait()");
	}
}
