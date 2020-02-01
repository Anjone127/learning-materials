package testdome;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class BaseTest {

	@Test
	public void testLogback(){
		log.error("error ...");
		log.info("info ...");
		log.debug("debug ...");
	}
}
