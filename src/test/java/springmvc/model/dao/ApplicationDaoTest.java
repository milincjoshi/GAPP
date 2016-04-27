package springmvc.model.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import springmvc.model.*;

@Test(groups = "ApplicationDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ApplicationDaoTest extends AbstractTransactionalTestNGSpringContextTests{

	@Autowired
	DepartmentDao departmentDao;

	/*
    @Test
    public void getApplication()
    {
    	List<Department> departments = (ArrayList<Department>) departmentDao.getDepartments();
    	List<Application> Fall2016Applications = new ArrayList<Application>();
    	for(Department department : departments){
        	if(department.getDepartmentName().equals("Accounting")){
            	List<Program> programs = department.getPrograms();
            	List<Application> applications = new ArrayList<Application>();
            	
            	for(Program program : programs){
            		applications = (List<Application>) program.getApplicationId();
            		
            		for(Application application : applications){
            			if(application.getTermSeason().equals("Fall") && application.getTermYear().equals("2016")){
            				Fall2016Applications.add(application);
            			}
            		}
            	}
            	//assert Fall2016Applications.size() == 1;
        	}
    	}
    }*/
}
