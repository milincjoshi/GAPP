package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Department;
import springmvc.model.Users;
import springmvc.model.dao.DepartmentDao;
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Department getDepartmentsById(Integer Id) {
		return entityManager.find(Department.class, Id);
	}

	@Override
	public List<Department> getDepartments() {
		return entityManager.createQuery("from Department", Department.class).getResultList();
	}

	@Override
	@Transactional
	public Department saveDepartment(Department department) {
		return entityManager.merge(department);
	}
	
}
