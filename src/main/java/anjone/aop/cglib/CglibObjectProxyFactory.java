package anjone.aop.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author anjone
 * @Date 2018/3/14.
 */
public class CglibObjectProxyFactory {

	/**
	 * 产生代理对象
	 * @param clz 被代理类
	 * @return
	 */
	public static Object getProxyInstance(Class clz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clz);
		enhancer.setCallback(new CglibDynamicProxy());
		return enhancer.create();
	}
}
