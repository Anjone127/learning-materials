package anjone.extend;

/**
 * @author gjy
 * @since 2020/05/15
 */
public class ExtendsDemo {
    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Father {
    private String name = "father";
    private String age = "";

    private String getName() {
        return name;
    }
}

class Son extends Father {
    private String name = "son";
}
