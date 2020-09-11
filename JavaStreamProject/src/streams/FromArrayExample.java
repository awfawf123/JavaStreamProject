package streams;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FromArrayExample {
	public static void main(String[] args) {
		int[] intAry = {3,6,4,9,7};
		IntStream iStream = Arrays.stream(intAry);
		iStream.filter(( value) -> value > 5).forEach((value) ->System.out.println(value));
		
		iStream = Arrays.stream(intAry);
		long cnt = iStream.sum();
		System.out.println("cnt: " + cnt);
		
		iStream = Arrays.stream(intAry, 0, 4);
		cnt = iStream.peek(t-> System.out.println(t)).count();
		System.out.println("cnt: " + cnt);

	}

}
