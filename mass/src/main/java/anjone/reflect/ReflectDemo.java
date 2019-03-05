package anjone.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @author anjone
 */
public class ReflectDemo {


	private static String METHOD_HELLO = "hello";

	public static void main(String[] args) {
		try{
			SayHello sayHello = new SayHello(Anjone.class);
			Class clz = sayHello.getClass();
			Method method = clz.getMethod(METHOD_HELLO, String.class);
			method.invoke(sayHello, "Zhang San");
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}

class SayHello{

	private String name;

	public SayHello(Class clz){
		Person person = (Person) clz.getAnnotation(Person.class);
		this.name = person.name();
	}

	public void hello(String name) {
		System.out.println("Hi " + name + ", i'm " + this.name);
	}

}

@Person(name = "Anjone")
class Anjone{
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Person {
	String name() default "??";
	int age() default -1;
	double weight() default 0;
}
