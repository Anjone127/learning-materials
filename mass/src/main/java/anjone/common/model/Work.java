package anjone.common.model;

/**
 * @author anjone
 */
public class Work {
	private String name;
	private long time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Work [name=" + name + ", time=" + time + "]";
	}
}
