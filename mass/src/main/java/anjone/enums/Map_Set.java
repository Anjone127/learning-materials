package anjone.enums;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class Map_Set {
	public static void main(String[] args ){
		//ordinal为下标初始化数组
		Map<FruitEnums,Integer> enumMap = new EnumMap<FruitEnums, Integer>(FruitEnums.class);

		//可以放入空值 初始化时所有的key对应的value为空
		enumMap.put(FruitEnums.Cherry,null);

		EnumSet<FruitEnums> enumSet= EnumSet.noneOf(FruitEnums.class);
	}
}
