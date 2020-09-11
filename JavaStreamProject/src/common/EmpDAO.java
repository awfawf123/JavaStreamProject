package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionDB;
import common.Employee;

public class EmpDAO {
	public static List<Employee> getEmpList() {
		Connection conn = ConnectionDB.getConnection();
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			String sql = "select * from emp_temp";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				String firstName = rs.getNString("first_name");
				emp.setFirstName(firstName);
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				LocalDate hireDate = rs.getDate("hire_date").toLocalDate();
				emp.setHireDate(hireDate);
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				list.add(emp);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
	// List<Employee> getEmpList();

}
