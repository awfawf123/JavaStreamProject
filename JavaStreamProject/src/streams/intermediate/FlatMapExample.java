package streams.intermediate;

import java.time.LocalDate;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FlatMapExample {
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		stream.flatMap(new Function<Integer, Stream<Integer>>(){

			@Override
			public Stream<Integer> apply(Integer t) {
				return Stream.of(t*2);
			}
			
		}).forEach(System.out::println);
		
		//
		OptionalDouble result = Employee.employees().stream().flatMapToDouble(new Function<Employee,DoubleStream>(){

			@Override
			public DoubleStream apply(Employee t) {
				return DoubleStream.of(t.getIncome());
			}
			
		}).filter(n-> n > 8000).min();
		if(result.isPresent()) //ispresnt = 값의 존재여부확인
		System.out.println(result);
		else
			System.out.println("결과없음");
		
		
		System.out.println("-----------");
		
		Employee.employees().stream().flatMap(new Function<Employee,Stream<String>>(){

			@Override
			public Stream<String> apply(Employee t) {
				return Stream.of(t.name);
			}
			
		}).forEach(System.out::println);
		//
		Optional<LocalDate> result1 = Employee.employees().stream().flatMap(new Function<Employee,Stream<LocalDate>>(){

			@Override
			public Stream<LocalDate> apply(Employee t) {
				return Stream.of(t.dateOfBirth);
			}
			
		}).reduce(new BinaryOperator<LocalDate>() {

			@Override
			public LocalDate apply(LocalDate t, LocalDate u) {
				System.out.println(t + ", "+ u);
				return t.isBefore(u) ? t:u;
			}
			
		});
		System.out.println("min값: "+ result1);
	}
	
	

}
