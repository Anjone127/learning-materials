package anjone;

import java.util.stream.IntStream;

/**
 * @author gjy
 * @since 2019/11/26
 */
public class Size {

    public static void main(String[] args) {

        ValueHolder valueHolder = new ValueHolder();

        IntStream.range(1, 1000).forEach((v) -> new Thread(new Runabble1(valueHolder)).start());
    }

    static class Runabble1 implements Runnable {
        ValueHolder lock;

        Runabble1(ValueHolder valueHolder) {
            this.lock = valueHolder;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                lock.val++;
                System.out.println(lock.val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ValueHolder {
    Integer val = 1;
}


