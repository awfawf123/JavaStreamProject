package streams.collect;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class CollectionDataBaseExample {
	public static void main(String[] args) {
		// employee 테이블
		// 입사일자 기준 1990년대 입사한 사람들
		List<Employee> list = EmpDAO.getEmpList();

		list.stream().filter(new Predicate<Employee>() {

			@Override
			public boolean test(Employee t) {

				return t.getHireDate().isBefore(LocalDate.of(2000, 01, 01))
						&& t.getHireDate().isAfter(LocalDate.of(1990, 01, 01));

			}

//		}).filter(new Predicate<Employee>() {
//
//			@Override
//			public boolean test(Employee t) {
//				return t.getHireDate().isAfter(LocalDate.of(1990, 01, 01));
//			}

		}).forEach(System.out::println);

		Map<String, Integer> map = list.stream().filter(e -> e.getJobId() == "ST_CLERK")
				.collect(Collectors.toMap(new Function<Employee, String>() {

					@Override
					public String apply(Employee t) {						
						return t.getFirstName();
					}
				}, new Function<Employee, Integer>() {

					@Override
					public Integer apply(Employee t) {						
						return t.getSalary();
					}
				}));
		Set<String> keys = map.keySet();
		for(String s : keys) {
			System.out.println("이름: " + s + ", " + "급여: "+ "," + map.get(s));
		}

	}
}