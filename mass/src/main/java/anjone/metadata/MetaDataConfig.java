package anjone.metadata;

import anjone.common.model.Person;
import anjone.common.model.Work;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anjone
 * @Date 2018/3/16.
 */

@Configuration
public class MetaDataConfig {

	@Bean
	public Person person(){
		Person person = new Person();
		person.setName("anjone");
		person.setAge(12);
		person.setTel("5565");
		return person;
	}

	@Bean
	public Work work(){
		Work work = new Work();
		work.setName("programmer");
		work.setTime(1000);
		return work;
	}
}
