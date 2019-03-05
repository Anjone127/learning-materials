package anjone.aop.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Enhancer既能够代理普通的class，也能够代理接口
 * CGLib不能对声明为final的方法进行代理，CGLib原理是动态生成被代理类的子类。
 * @author anjone
 * @Date 2018/3/14.
 */
public class CglibObjectProxyFactory {

	/**
	 * 产生代理对象
	 * @param clz 被代理类
	 */
	public static Object getProxyInstance(Class clz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clz);
		enhancer.setCallback(new CglibDynamicProxy());
		return enhancer.create();
	}
}
