import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author gjy
 * @since 2020/04/26
 */
public class FutureDemo {
    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = () -> {
            Thread.sleep(1000);
            return 1;
        };

        FutureTask<Integer> future = new FutureTask<>(callable);
        new Thread(future).start();
        System.out.println(future.get());
    }
}

