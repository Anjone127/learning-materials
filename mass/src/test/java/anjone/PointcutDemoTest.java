package anjone;

import anjone.aop.PrimaryMath;
import anjone.aop.PrimaryMathImpl;
import anjone.aop.PrimaryMathStaticProxy;
import anjone.aop.cglib.CglibObjectProxyFactory;
import anjone.aop.jdk.PrimaryMathDynamicProxy;
import anjone.aop.spring.PointcutDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:aop.xml"})
public class PointcutDemoTest {

	@Autowired
	PointcutDemo pointcutDemo;

	@Test
	public void springProxy(){
		pointcutDemo.a("testAop");
	}

	@Test
	public void cglibProxy(){
        PrimaryMathImpl primaryMath = (PrimaryMathImpl) CglibObjectProxyFactory.getProxyInstance(PrimaryMathImpl.class);
        primaryMath.add(1,1);
	}

	@Test
	public void dynamicProxy(){
		PrimaryMathDynamicProxy dynamicProxy = new PrimaryMathDynamicProxy();
		PrimaryMath primaryMath = (PrimaryMath) dynamicProxy.getProxyObject(new PrimaryMathImpl());
		primaryMath.add(1,2);
	}

	@Test
	public void staticProxy(){
		PrimaryMathStaticProxy proxy = new PrimaryMathStaticProxy();
		proxy.add(1,3);
	}
}
