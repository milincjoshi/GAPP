package springmvc.model.dao;

import java.util.List;

import springmvc.model.Department;
import springmvc.model.Users;

public interface DepartmentDao {
	Department getDepartmentsById(Integer Id);
	List<Department> getDepartments();
	Department saveDepartment(Department department);

}
