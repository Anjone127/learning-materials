package anjone.sycn;

/**
 * @author gjy
 * @since 2019/12/02
 */
public class SycnInstanceMethod {

    public static void main(String[] args) {
        InstanceMethod instanceMethod = new InstanceMethod();

        int i = 20;
        while (i-- > 0) new Thread1(instanceMethod).start();


        while (i++ < 20) new Thread2(new InstanceMethod()).start();
    }
}

class InstanceMethod {
    private String a = "1";
    synchronized void print() {
        try {
            System.out.println("synchronized print");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void print2() {
        try {
            System.out.println("print2");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread1 extends Thread {
    private InstanceMethod instanceMethod;

    Thread1(InstanceMethod instanceMethod) {
        this.instanceMethod = instanceMethod;
    }

    @Override
    public void run() {
        instanceMethod.print();
    }
}

class Thread2 extends Thread {
    private InstanceMethod instanceMethod;

    Thread2(InstanceMethod instanceMethod) {
        this.instanceMethod = instanceMethod;
    }

    @Override
    public void run() {
        instanceMethod.print2();
    }
}


