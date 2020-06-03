package anjone.aop;

/**
 * @author anjone
 * @Date 2018/3/14.
 */
public class PrimaryMathImpl implements  PrimaryMath {

	@Override
    public int add(int num1, int num2){
		int result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
		return result;
	}
}
