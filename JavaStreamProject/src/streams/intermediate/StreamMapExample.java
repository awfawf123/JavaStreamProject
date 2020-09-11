package streams.intermediate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import common.EmpDAO;
import common.Employee;



public class StreamMapExample {
	public static void main(String[] args) {
		
		List<Employee> list = EmpDAO.getEmpList();
		System.out.println(list);
		
		list.stream().filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				return t.getSalary()> 5000;
			}
			
		}).forEach(System.out::println); 
		
		
		list.stream().flatMap(new Function<Employee,Stream<LocalDate>>() {

			@Override
			public Stream<LocalDate> apply(Employee t) {
				
				return Stream.of(t.getHireDate().parse("1995-00-00", DateTimeFormatter.ISO_DATE));
			}
			
		}).forEach(System.out::println);
		
		

			
		
		
		//salary가 10000이상인 사원들 출력
		//LocalDate date = LocalDate.of(2020, 5, 1);
		//2020-05-01
	//	System.out.println(date.format(DateTimeFormatter.ISO_DATE));
		//date.format(DateTimeFormatter.ISO_DATE);//데이트타입 -> 문자열
		//LocalDate.parse("2010-05-05", DateTimeFormatter.ISO_DATE); //문자열 ->데이트
	}

}
