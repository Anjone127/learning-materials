package anjone.socket;

/**
 * @author anjone
 * @Date 2018/3/13.
 */
public class ServerThreadFactory implements java.util.concurrent.ThreadFactory {

	private Integer count = 1;

	private String threadFactoryName;

	@Override
	public Thread newThread(Runnable run) {
		Thread t = new Thread(run, run.getClass().getName() + "-Thread-" + count++);
		return t;
	}
}
