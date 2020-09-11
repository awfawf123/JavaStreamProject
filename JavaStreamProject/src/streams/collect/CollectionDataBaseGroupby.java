package streams.collect;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class CollectionDataBaseGroupby {
	public static void main(String[] args) {
		// 직무별 - 사원그룹

		List<Employee> list = EmpDAO.getEmpList();
		Map<String, List<Employee>> map;

		Map<String, List<Employee>> gMap = list.stream()
				.collect(Collectors.groupingBy(new Function<Employee, String>() {

					@Override
					public String apply(Employee t) {					
						return t.getJobId();
					}

				}, Collectors.toList()));
		Set<String> set = gMap.keySet();
		for(String s : set) {
			System.out.println(s);
			List<Employee> list1 = gMap.get(s);
			for(Employee e : list1) {
				System.out.println("직무: " + e.getJobId() + ", " +"사원 그룹:" + e.getEmployeeId());
			}
			
		}
	}

}
