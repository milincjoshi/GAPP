package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Student;
import springmvc.model.Users;
import springmvc.model.dao.StudentDao;
@Repository
public class StudentDaoImpl implements StudentDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Student getStudentsById(Integer Id) {
		return entityManager.find(Student.class, Id);
	}

	@Override
	public List<Student> getStudents() {
		return entityManager.createQuery("from students", Student.class).getResultList();
	}

	@Override
	@Transactional
	public Student saveStudent(Student Student) {
		return entityManager.merge(Student);
	}


}
