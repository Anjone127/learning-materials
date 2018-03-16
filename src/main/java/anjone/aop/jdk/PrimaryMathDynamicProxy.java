package anjone.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author anjone
 * @Date 2018/3/14.
 */
public class PrimaryMathDynamicProxy implements InvocationHandler{

	Object proxyObject;

	public Object getProxyObject (Object obj){
		this.proxyObject = obj;
		return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), proxyObject.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable{

		System.out.println("before log...");

		Object res = method.invoke(proxyObject,args);

		System.out.println("after log...");

		return res;
	}

}
