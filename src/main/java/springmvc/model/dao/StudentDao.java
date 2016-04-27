package springmvc.model.dao;

import java.util.List;

import springmvc.model.Student;
import springmvc.model.Users;

public interface StudentDao {
	Student getStudentsById(Integer Id);
	List<Student> getStudents();
	Student saveStudent(Student Student);
}
