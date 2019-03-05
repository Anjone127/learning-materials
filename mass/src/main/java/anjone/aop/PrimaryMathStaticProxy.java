package anjone.aop;

/**
 * @author anjone
 * @Date 2018/3/14.
 */
public class PrimaryMathStaticProxy {

	PrimaryMathImpl primaryMath  = new PrimaryMathImpl();

	public int add(int num1, int num2) {
		long start = System.currentTimeMillis();
		int result = primaryMath.add(num1, num2);
		Long span =  System.currentTimeMillis()-start;
		System.out.println("共用时：" + span);
		return result;
	}

}
