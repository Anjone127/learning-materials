/**
 * @author gjy
 * @since 2019/10/09
 */
public class VolatileDemo {

    public static void main(String[] args) throws Exception {
        VolatileDO volatileDO = new VolatileDO();
        UnVolatileDO unVolatileDO = new UnVolatileDO();

        RunThread runThread;
        for (int i = 0; i < 100; i++) {
            runThread = new RunThread(volatileDO, unVolatileDO);
            runThread.join();
            runThread.start();
            Thread.sleep(100);
        }

        System.out.println("volatileDO.a = " + volatileDO.a);
        System.out.println("unVolatileDO.a = " + unVolatileDO.a);
    }
}


class VolatileDO {
    volatile Integer a = 0;
}

class UnVolatileDO {
    Integer a = 0;
}

class RunThread extends Thread {

    private VolatileDO volatileDO;
    private UnVolatileDO unVolatileDO;

    RunThread(VolatileDO volatileDO, UnVolatileDO unVolatileDO) {
        this.volatileDO = volatileDO;
        this.unVolatileDO = unVolatileDO;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (volatileDO) {
                volatileDO.a = volatileDO.a + 1;
            }
            synchronized (unVolatileDO) {
                unVolatileDO.a = unVolatileDO.a + 1;
            }
        }
    }
}