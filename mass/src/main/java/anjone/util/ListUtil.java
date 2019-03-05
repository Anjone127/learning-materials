package anjone.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anjone (guanjiayi@souche.com)
 * @date 2018/6/22.
 */
public class ListUtil {

//	public static <K, V>  Map<K,V> toMap(List<V> list,K key){
//		Map<K,V> resMap = new HashMap<K, V>();
//		for(V v : list){
//			v.getClass().
//			resMap.put("a",v);
//		}
//		return null;
//	}
//
//	public static <K, V> Map<K, V> list2Map1(List<V> list, Field field) {
//		Map<K, V> map = new HashMap<K, V>();
//		if (list != null && list.size() > 0) {
//			try {
//
//				for (int i = 0; i < list.size(); i++) {
//					V object = list.get(i);
//
//					map.put(field.get(object), object);
//				}
//			} catch (Exception e) {
//				throw new IllegalArgumentException("field can't match the key!");
//			}
//		}
//
//		return map;
//	}

	public static <K, V> Map<K, V> list2Map2(List<V> list, String fieldName4Key,Class<V> c) {
		Map<K, V> map = new HashMap<K, V>();
		if (list != null) {
			try {
				PropertyDescriptor propDesc = new PropertyDescriptor(fieldName4Key, c);
				Method methodGetKey = propDesc.getReadMethod();
				for (int i = 0; i < list.size(); i++) {
					V value = list.get(i);
					@SuppressWarnings("unchecked")
					K key = (K) methodGetKey.invoke(list.get(i));
					map.put(key, value);
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("field can't match the key!");
			}
		}

		return map;
	}

}
