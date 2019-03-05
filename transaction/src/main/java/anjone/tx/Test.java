package anjone.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(final String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:tx-foo.xml");
		FooService fooService = (FooService) ctx.getBean("fooService");
		fooService.insertFoo (new Foo());
	}
}
