package anjone;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author gjy
 * @since 2020/04/22
 */
public class RefrenceDemo {
    public static void main(String[] args) throws Exception {
        Map<Object, String> m = new WeakHashMap<>();


//        m.put(new Object(), "123");
//        System.gc();
//        Thread.sleep(1000L);
//        System.out.println(m.size());

        String b = new String("aaa");
        m.put("aaa","aaa");
        m.put(b,"aaa");
        System.gc();
        Thread.sleep(1000L);
        System.out.println(m.size());

    }
}
