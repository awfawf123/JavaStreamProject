package streams;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntExample {
	public static void main(String[] args) {
		//1~10까지 정수형 배열
		//배열로부터 스트림 생성
		//스트림을 생성하고 filter를 통해서 짝수값
		//최종집계처리는 sum()
		int[] intAry = {1,2,3,4,5,6,7,8,9,10};
		IntStream iStream = Arrays.stream(intAry);
		int sum=iStream.filter(new IntPredicate() {

			@Override
			public boolean test(int value) {
				return value%2==0;
			}
			
		}).sum();
		System.out.println(sum);
		
		IntStream.range(1, 10).forEach(s -> System.out.println(s));
		System.out.println("-- rangeClosed");
		IntStream.rangeClosed(1, 10).filter(n-> n > 5).forEach(System.out::println);
		
	}

}
