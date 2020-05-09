package anjone.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class JavaBaseConfig {

    @Bean
    private Object a(){
        return null;
    }

    @Bean
    private Object b(){
        return new String("xixi");
    }
}
