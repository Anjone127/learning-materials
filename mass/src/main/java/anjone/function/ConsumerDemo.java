package anjone.function;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

/**
 * @author gjy
 * @since 2019/08/13
 */
public class ConsumerDemo {

	public static void main(String[] args){
		LongConsumer consumer = (x) -> {x = x+10; System.out.println(x);};
		LongConsumer consumer1 = (x) -> {x = x+100; System.out.println(x);};


		consumer.andThen(consumer1).accept(1);

		Consumer<Long> consumerL = (x) ->{x = x+10; System.out.println(x);};
		Consumer<Long> consumerL1 = (x) -> {x = x+100; System.out.println(x);};
		consumerL.andThen(consumerL1).accept(1L);
	}
}
