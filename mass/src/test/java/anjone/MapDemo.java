package anjone;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gjy
 * @since 2019/08/30
 */
public class MapDemo {

	public static void main(String[] args){
		Map<Integer, Integer> m1 = new LinkedHashMap<>();
		m1.put(1,1);
		m1.put(3,3);
		m1.put(2,2);

		m1.forEach( (x,y) -> System.out.println(x +" " + y));

		Map<Integer, Integer> m2 = new HashMap<>();
		m1.put(1,1);
		m1.put(3,3);
		m1.put(2,2);

		m1.forEach( (x,y) -> System.out.println(x +" " + y));
	}
}
