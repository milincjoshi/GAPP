package springmvc.model.dao;

import java.util.List;

import springmvc.model.*;

public interface ApplicationDao {
	Application getApplicationById(Integer Id);
	List<Application> getApplications();
	Application saveApplication(Application application);

}
