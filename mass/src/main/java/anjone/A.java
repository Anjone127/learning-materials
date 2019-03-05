package anjone;

public class A {
	public static void main(String[] args){
		MyThread a = new MyThread();
		a.start();
		a.interrupt();
		a.isInterrupted();
		new Thread();
	}
}

class MyThread extends Thread{

	@Override
	public void run(){
		System.out.println("123");
	}
}
