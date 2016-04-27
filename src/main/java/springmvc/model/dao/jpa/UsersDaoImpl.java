package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Users;
import springmvc.model.dao.UsersDao;
@Repository
public class UsersDaoImpl implements UsersDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Users getUsersById(Integer userId) {
		return entityManager.find(Users.class, userId);
	}

	@Override
	public List<Users> getUsers() {
		return entityManager.createQuery("from Users", Users.class).getResultList();
	}

	@Override
	@Transactional
	public Users saveUser(Users users) {
		return entityManager.merge(users);
	}

	
}
