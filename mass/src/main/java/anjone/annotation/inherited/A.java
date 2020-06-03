package anjone.annotation.inherited;

import java.util.Arrays;

@In(values = 0)
@In(values = 1)
class A {

    public static void main(String[] args) {
        A.class.getMethods();
    }

    public static void paramTest(@In(values = 1) String s) {
        System.out.println("paramTest");

        Arrays.stream(s.getClass().getAnnotations()).forEach(System.out::println);
        System.out.println("paramTest");
    }

    public static void paramTest1(@Ins({@In(values = 1)}) String s) {
        System.out.println("paramTest1");
        Arrays.stream(s.getClass().getAnnotations()).forEach(System.out::println);
        System.out.println("paramTest1");
    }
}
