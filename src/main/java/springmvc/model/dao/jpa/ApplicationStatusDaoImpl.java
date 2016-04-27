package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import springmvc.model.Application;
import springmvc.model.ApplicationStatus;
import springmvc.model.dao.ApplicationStatusDao;
@Repository
public class ApplicationStatusDaoImpl implements ApplicationStatusDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ApplicationStatus getApplicationStatusById(Integer Id) {
		// TODO Auto-generated method stub
		return entityManager.find(ApplicationStatus.class, Id);
	}

	@Override
	public List<ApplicationStatus> getApplicationStatuses() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from ApplicationStatus", ApplicationStatus.class).getResultList();
	}

}
