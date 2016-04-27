package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Application;
import springmvc.model.dao.ApplicationDao;
@Repository
public class AppicationDaoImpl implements ApplicationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Application getApplicationById(Integer Id) {
		return entityManager.find(Application.class, Id);
	}

	@Override
	public List<Application> getApplications() {
		return entityManager.createQuery("from Application", Application.class).getResultList();
	}

	@Override
	@Transactional
	public Application saveApplication(Application application) {
		return entityManager.merge(application);
	}

}
