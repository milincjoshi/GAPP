package springmvc.model.dao;



import java.util.List;

import springmvc.model.AdditionalInfo;
import springmvc.model.Department;
import springmvc.model.Program;

public interface AdditionalInfoDao {
	AdditionalInfo getAdditionalInfoById(Integer Id);
	List<AdditionalInfo> getAdditionalInfo();
	AdditionalInfo saveAdditionalInfo(AdditionalInfo additionalInfo);
	Department getDepartmentByName(String departmentName);
	void removeAdditionalInfo(AdditionalInfo additionalInfo);
}
