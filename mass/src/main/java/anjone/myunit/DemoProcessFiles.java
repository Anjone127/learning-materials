package anjone.myunit;

/**
 * @author gjy
 * @since 2020/05/19
 */
public class DemoProcessFiles {
    public static void main(String[] args) {
        new ProcessFiles(file -> System.out.println(file),
                "java").start(args);
    }
}
