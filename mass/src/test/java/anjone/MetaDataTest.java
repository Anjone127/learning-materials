package anjone;

import anjone.common.model.Employee;
import anjone.common.model.Person;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author anjone
 * @Date 2018/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:metadata.xml"})
public class MetaDataTest {

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void getApplicationContext(){
		System.out.println(JSON.toJSONString(applicationContext.getAutowireCapableBeanFactory()));
	}

	@Test
	public void getBeans(){
		Employee employee = (Employee)applicationContext.getBean("employee1");
		System.out.println("employee 1:" + employee.toString());

		employee = (Employee)applicationContext.getBean("employee2");
		System.out.println("employee 2:" + employee.toString());

		employee = (Employee)applicationContext.getBean("employee3");
		System.out.println("employee 3:" + employee.toString());

		Person p = applicationContext.getBean(Person.class);
		System.out.println(p == null ? "no person obj" :p.toString());
	}
}
