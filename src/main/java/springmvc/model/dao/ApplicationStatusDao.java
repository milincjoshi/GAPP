package springmvc.model.dao;

import java.util.List;

import springmvc.model.ApplicationStatus;

public interface ApplicationStatusDao {
	ApplicationStatus getApplicationStatusById(Integer Id);
	List<ApplicationStatus> getApplicationStatuses();
}
