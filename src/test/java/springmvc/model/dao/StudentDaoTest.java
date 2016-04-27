package springmvc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import springmvc.model.Users;
@Test(groups = "StudentDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	 
	@Autowired
	ApplicationDao applicationDao;

	@Autowired
	UsersDao userDao;

	@Test
	public void getStudentApplication()
	{
		List<Users> usersList = userDao.getUsers();
		for(Users user : usersList ){
			if(user.getUserEmail().equals("student1@localhost.localdomain")){
				try{user.getApplication();}
				catch(Exception ex){ex.printStackTrace();}
			}
		}
		
	}
}
