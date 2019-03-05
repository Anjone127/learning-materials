package anjone.enums;

import java.util.Arrays;

/**
 * 根据ordinal比较大小
 * finalize被重写 不会被GC
 * values()方法和valueOf(String name)方法是编译器生成的static方法 FruitEnums.jad
 * toString()方法被重写 及 和name()方法返回值相同
 */
public enum FruitEnums {

	Strawberry("草莓", 10.1) {
		@Override
		public void printFruitName() {
			System.out.print("Strawberry");
		}
	},
	Hamimelon("哈密瓜", 5.5),
	Cherry("樱桃", 3.);


	private String name;
	private Double price;

	FruitEnums(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	/**
	 * enum类中定义方法 (可定义抽象方法)
	 */
	public void printFruitName() {
		System.out.print(this.name);
	}

	/**
	 * 上转型后获取枚举
	 */
	public static void a() {
		FruitEnums[] fruits = FruitEnums.values();
		Enum e = FruitEnums.Strawberry;
		Class<?> clasz = e.getDeclaringClass();
		if (clasz.isEnum()) {
			FruitEnums[] dsz = (FruitEnums[]) clasz.getEnumConstants();
			System.out.println("dsz:" + Arrays.toString(dsz));
		}
	}
}
