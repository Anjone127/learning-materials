package anjone.aha;

import java.lang.reflect.Field;

public class Aha {

	static final Long a = 10L;
	public static void main(String[] args) throws Exception{
//		Aha.a = 10L;

		String a = "a";
		String.class.getFields();
		Field field = String.class.getDeclaredField("value");
		field.setAccessible(true);
		char[] chars = (char[])field.get(a);
		chars[0] = 'b';
		System.out.println(a);
	}
}
