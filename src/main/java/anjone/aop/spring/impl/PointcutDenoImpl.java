package anjone.aop.spring.impl;

import anjone.aop.spring.PointcutDemo;
import org.springframework.stereotype.Component;

/**
 * @author anjone
 */
@Component
public class PointcutDenoImpl implements PointcutDemo {

	@Override
	public void a(String str) {
		System.out.println("PointcutDenoImpl method a");
	}
}
