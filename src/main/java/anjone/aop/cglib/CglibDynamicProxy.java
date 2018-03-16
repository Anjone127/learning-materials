package anjone.aop.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author anjone
 * @Date 2018/3/14.
 */
public class CglibDynamicProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
							MethodProxy methodProxy) throws Throwable {
		System.out.println("**********************************");
		System.out.println("class : " + obj.getClass().getName() + "  method : " + method.getName());
		System.out.println(method.getName()+"do someting before saying");
		Object result = methodProxy.invokeSuper(obj,args);
		System.out.println(method.getName()+"do someting after saying");
		return result;
	}
}
