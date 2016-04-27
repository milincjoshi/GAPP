package springmvc.model.dao;

import springmvc.model.*;
import java.util.*;
public interface UsersDao {
	
	Users getUsersById(Integer Id);
	List<Users> getUsers();
	Users saveUser(Users user);
}
