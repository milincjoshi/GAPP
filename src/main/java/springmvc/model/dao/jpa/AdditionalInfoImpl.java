package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.AdditionalInfo;
import springmvc.model.Department;
import springmvc.model.dao.AdditionalInfoDao;
@Repository
public class AdditionalInfoImpl implements AdditionalInfoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public AdditionalInfo getAdditionalInfoById(Integer Id) {
		return entityManager.find(AdditionalInfo.class, Id);
	}

	@Override
	public List<AdditionalInfo> getAdditionalInfo() {
		return entityManager.createQuery("from AdditionalInfo", AdditionalInfo.class).getResultList();
	}

	@Override
	@Transactional
	public AdditionalInfo saveAdditionalInfo(AdditionalInfo additionalInfo) {
		return entityManager.merge(additionalInfo);
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		return (Department) entityManager.createQuery("FROM Department WHERE departmentName = :departmentName", Department.class).setParameter("departmentName",departmentName).getSingleResult();
	}

	@Override
	@Transactional
	public void removeAdditionalInfo(AdditionalInfo additionalInfo) {
		entityManager.remove(additionalInfo);
	
	}

}
