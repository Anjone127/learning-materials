package anjone;

import anjone.config.JavaBaseConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class JavaBaseApplicationStarter {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaBaseConfig.class);

//        ctx.getBean();
        System.out.println("xixi");
        System.in.read();
    }

}
