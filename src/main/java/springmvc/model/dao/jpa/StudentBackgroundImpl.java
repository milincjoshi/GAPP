package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.StudentBackground;
import springmvc.model.dao.StudentBackgroundDao;

@Repository
public class StudentBackgroundImpl implements StudentBackgroundDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public StudentBackground getstudentBackgroundById(Integer Id) {
		return entityManager.find(StudentBackground.class, Id);
	}

	@Override
	public List<StudentBackground> getstudentBackgrounds() {
		return entityManager.createQuery("from StudentBackground", StudentBackground.class).getResultList();
	}

	@Override
	@Transactional
	public StudentBackground saveStudentBackground(StudentBackground studentBackground) {
		return entityManager.merge(studentBackground);
	}

	@Override
	@Transactional
	public void removeStudentBackground(StudentBackground studentBackground) {
		entityManager.remove(studentBackground);
	}
	
}
