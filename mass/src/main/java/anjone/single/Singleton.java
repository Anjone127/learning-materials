package anjone.single;

public class Singleton{
	private Singleton(){}

	private static class SingletonContainer{
		private static Singleton instance = new Singleton();
	}

	public static Singleton getInstance(){
		return SingletonContainer.instance;
	}
}

/**
 * 饿汉式 一开始就加载 增加耗时
 */
class Singleton2{
	private static Singleton2 instance = new Singleton2();

	private Singleton2(){}

	public static Singleton2 getInstance(){
		return instance;
	}
}

/**
 * 懒汉式 多线程不安全
 */
class Singleton3{
	private static Singleton3 instance = null;

	private Singleton3(){}

	public static Singleton3 getInstance(){
		if (instance == null) {
			instance = new Singleton3();
		}
		return instance;
	}
}

/**
 * 懒汉式 每次都要获取锁效率低
 */
class Singleton4{
	private static Singleton4 instance = null;

	private Singleton4(){}

	public static synchronized Singleton4 getInstance(){
		if (instance == null) {
			instance = new Singleton4();
		}
		return instance;
	}
}

/**
 * double-checked locking
 */
class Singleton5{
	private static Singleton5 instance = null;

	private Singleton5(){}

	public static Singleton5 getInstance(){
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new Singleton5();
				}
			}
		}
		return instance;
	}
}