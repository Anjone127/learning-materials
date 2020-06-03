package anjone.aop.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 两个注解缺一不可
 * @author anjone
 */
@Aspect
@Component
public class AspectDemo {

	ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

	{
		threadLocal.remove();
	}

	@Pointcut("execution(void anjone.aop.spring.PointcutDemo.*(..))")
	public void doSomething() {
		System.out.println("AspectDemo do something");
	}


//	@Before("doSomething()")
//	@Before("within(aop..*)") 	// .*此包下 ..*此包和子包下
	@Before("this(anjone.aop.spring.PointcutDemo)")	//某一类
//	@AfterReturning("")
//	@Before("execution(void anjone.aop.spring.PointcutDemo.*(..))") //表达式解析
	/**
	 *
	 */
	public void beforeDoSomething(JoinPoint jp){
		System.out.println("AspectDemo before do something");
	}

    @Around("doSomething()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("AspectDemo aroundAdvice do something");
        Object o = proceedingJoinPoint.proceed();
        System.out.println("AspectDemo aroundAdvice do something");
        return o;
    }

	@After("doSomething()")
	public void afterDoSomething(JoinPoint jp){
		String className = jp.getThis().getClass().getName();
		String classMethod = jp.getSignature().getName();
		Object[] obj = jp.getArgs();

		System.out.println("AspectDemo after do something \n className " + className + "\n classMethod : " + classMethod  + "\n args : " + obj);

	}

}
