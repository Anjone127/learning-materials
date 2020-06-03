package anjone.annotation.inherited;

import java.util.Arrays;

/**
 * @author gjy
 * @since 2020/05/01
 */

public class Demo {

    public static void main(String[] args) {
        Arrays.stream(A.class.getAnnotations()).forEach(System.out::println);
        Arrays.stream(B.class.getAnnotations()).forEach(System.out::println);
        Arrays.stream(C.class.getAnnotations()).forEach(System.out::println);
    }
}







