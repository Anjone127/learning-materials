package thread;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ALL")
public class Mass {

	AtomicInteger a = new AtomicInteger();

//	public static void main(String[] args){
////		StringBuffer str = new StringBuffer("asd asd ffd  ");
////		int index ;
////		while( (index = str.indexOf(" ")) != -1){
////			str = str.replace(index, index+1 , "%20");
////		}
////		System.out.println(str.toString());
//		int[] a = {1,2,3,4,5,6,7,8};
//		reOrderArray(a);
////		System.out.println(pow(2,0));
////		System.out.println(pow(2,1));
////		System.out.println(pow(2,2));
////		System.out.println(pow(2,3));
////		System.out.println(pow(2,4));
////		System.out.println(pow(2,5));
////		System.out.println(pow(2,6));
////		System.out.println(pow(2,7));
//	}

	private static
	int pow(int base,int b) {
		int ans = 1;
		while (b != 0) {
			if (b%2==1){
				ans *= base;
			}
			base *= base;
			b >>= 1;
		}
		return ans;
	}

	public static void reOrderArray(int [] array) {
		int[] ret = new int[array.length];
		int mid = array.length/2;
		for(int i = 0 ; i< array.length ; i++){
			if(i%2 == 0){
				ret[i/2+mid]=array[i];
			}else{
				ret[i/2]=array[i];
			}
		}
		System.out.println(JSON.toJSONString(ret));
	}

}

