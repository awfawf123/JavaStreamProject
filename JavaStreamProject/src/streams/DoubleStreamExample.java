package streams;

import java.util.Arrays;
import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class DoubleStreamExample {
	public static void main(String[] args) {
		double[] dAry = {2.3, 4.5, 8.3, 5.5, 4.6};
		//스트림 생성하고 5보다 작은 반복요소를 필터하고 합을 구하라
		DoubleStream dStream = Arrays.stream(dAry);
		double sum=dStream.filter(new DoublePredicate() {

			@Override
			public boolean test(double t) {
				return t < 5;
			}
			
		}).sum();
		System.out.println(sum);
		
		//Stream 타입종류
		LongStream lStream = Arrays.stream(new long[] {10,29,38});
		IntStream iStream = Arrays.stream(new int[] {1,2,3});
		DoubleStream ddStream = Arrays.stream(new double[] {1.1,2.2});
		
		Stream<Integer> intStream;
		Stream<String> sStream = Arrays.stream(new String[] {"Hong","Park"});
//		Stream<Student> tStream = Arrays.stream(new Student[] {new Student})
		
	}

}
