package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gjy
 * @since 2019/04/30
 */
public class Hard982 {

	public static void main(String[] args){
		int[] a ={2,1,3};
		System.out.println(new Hard982().countTriplets(a));
	}

	public int countTriplets(int[] A) {
		int res = 0, tmp;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int aA : A) {
			for (int aA1 : A) {
				tmp = aA&aA1;
				map.put(tmp, map.getOrDefault(tmp,0) +1);
			}
		}
		for (Integer i : map.keySet()){
			for (int aA : A) {
				tmp = i & aA;
				if(tmp == 0){
					res += map.get(i);
				}
			}
		}
		return res;
	}
}
