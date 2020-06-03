package anjone;

import java.util.concurrent.locks.LockSupport;

/**
 * @author gjy
 * @since 2020/04/21
 */
public class LockSupportDemo {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> {
            System.out.println("before park");
            LockSupport.park();
            System.out.println("after park");
        });
        t.start();


        System.in.read();

        LockSupport.unpark(t);

        System.in.read();
    }
}

