package anjone.common.model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author anjone
 */
public class Person {
	private String name;
	private Integer age;
	private String tel;

	@Autowired
	Work work;

	public Work getWork() {
		return work;
	}
	public void setWork(Work work) {
		this.work = work;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", tel=" + tel + ", work=" + work + "]";
	}
	
}
