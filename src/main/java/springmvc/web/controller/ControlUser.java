package springmvc.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import springmvc.model.AdditionalInfo;
import springmvc.model.Application;
import springmvc.model.Department;
import springmvc.model.Program;
import springmvc.model.Student;
import springmvc.model.StudentBackground;
import springmvc.model.Users;
import springmvc.model.dao.AdditionalInfoDao;
import springmvc.model.dao.ApplicationDao;
import springmvc.model.dao.ApplicationStatusDao;
import springmvc.model.dao.DepartmentDao;
import springmvc.model.dao.ProgramDao;
import springmvc.model.dao.StudentBackgroundDao;
import springmvc.model.dao.StudentDao;
import springmvc.model.dao.UsersDao;
import springmvc.web.validator.LoginValidator;
import springmvc.web.validator.Signupvalidator;

@Controller
public class ControlUser {
	
		@Autowired
		private UsersDao userDao;
	
		@Autowired
		private StudentDao studentDao;
	
		@Autowired
		private AdditionalInfoDao additionalInfoDao;
	
		@Autowired
		private LoginValidator loginValidator;
	
		@Autowired
		private Signupvalidator signupValidator;
	
		@Autowired
		private DepartmentDao departmentDao;
		
		@Autowired
		private ProgramDao programDao;
		
		@Autowired
		private ApplicationDao applicationDao;
		
		@Autowired
		private ApplicationStatusDao applicationStatusDao;
	
		@Autowired
		private StudentBackgroundDao studentBackgroundDao;
	
		@Autowired
		private ServletContext context;
		
		@RequestMapping(value="/signup.html", method=RequestMethod.GET)
	    public String signUp1(ModelMap model)
	    { 
			//model.put("users", new Users());
			model.put("students", new Student());
			return "signup"; 
		}
		@RequestMapping(value="/signup.html", method=RequestMethod.POST)
	    public String signUp2(@ModelAttribute Student students, BindingResult result)
	    { 
			signupValidator.validate(students, result);
			if(result.hasErrors()){
				return "signup";
			}

			//Student s = (Student)users;
			//users.setUserType("Student");
			//userDao.saveUser(users);
			students.setType("International");
			students.setUserType("Student");
			studentDao.saveStudent(students);
			return "redirect:login.html"; 
		}
		
		@RequestMapping(value={"/login.html"}, method=RequestMethod.GET)
	    public String login1(ModelMap model)
	    { 
			model.put("users", new Users());
			return "login";
		}
		@RequestMapping(value="/login.html", method=RequestMethod.POST)
	    public String login2(@ModelAttribute Users users, BindingResult result)
	    { 
			loginValidator.validate(users, result);
			if(result.hasErrors()){
				return "login";
			}

			for(Users user : userDao.getUsers()){
				if(user.getUserEmail().equals(users.getUserEmail()) && user.getUserPassword().equals(users.getUserPassword())){
					if(user.getUserType().equals("Student")){
						//return "redirect:studenthome.html?id="+user.getUserId()+""; 
						return "redirect:displayApplications.html?id="+user.getUserId()+""; 
						
					}
					if(user.getUserType().equals("Admin")){
						return "redirect:adminhome.html?id="+user.getUserId()+""; 
					}
					if(user.getUserType().equals("Staff")){
						return "redirect:staffhome.html?id="+user.getUserId()+""; 
					}
				}//End if
			}//end for
			return "redirect:login.html"; 
		}
		
		//Home
		@RequestMapping(value="/adminhome.html", method=RequestMethod.GET)
	    public String adminHome()
	    { return "adminhome"; }
		@RequestMapping(value="/studenthome.html", method=RequestMethod.GET)
	    public String studentHome()
	    { return "studenthome"; }
		@RequestMapping(value="/staffhome.html", method=RequestMethod.GET)
	    public String staffhome()
	    { return "staffhome"; }
	
		//Add New Objects
		@RequestMapping(value="/adddepartment.html", method=RequestMethod.GET)
	    public String addNewDepartment(ModelMap model)
	    { 	
			model.put("department",departmentDao.getDepartments());
			return "adddepartment"; 
		}
		@RequestMapping(value="/adddepartment.html", method=RequestMethod.POST)
	    public String signUp2(@ModelAttribute Department department, BindingResult result)
	    { 
			
			System.out.println(department.getDepartmentName());
			departmentDao.saveDepartment(department);
			
			return "redirect:adddepartment.html"; 
		}
		
		//add info
		//Add New Objects
		@RequestMapping(value="/addadditionalinfo.html", method=RequestMethod.GET)
	    public String addAdditionalInfo1(ModelMap model)
	    { 	
			model.put("department",departmentDao.getDepartments());
			model.put("additionalinfo",additionalInfoDao.getAdditionalInfo());
			return "addadditionalinfo"; 
		}
		@RequestMapping(value="/addadditionalinfo.html", method=RequestMethod.POST)
	    public String addAdditionalInfo2(@ModelAttribute AdditionalInfo additionalInfo, BindingResult result,@RequestParam String department)
	    { 
			if(additionalInfo.getInfoRequired()== null){
				additionalInfo.setInfoRequired(false);
			}
			Department depa = additionalInfoDao.getDepartmentByName(department);
			additionalInfo.setDepartmentId(depa);
			additionalInfoDao.saveAdditionalInfo(additionalInfo);
			return "redirect:addadditionalinfo.html"; 
		}
		//end add info
		@RequestMapping(value="/addprogram.html", method=RequestMethod.GET)
	    public String addProgram(ModelMap model)
	    { 	
			model.put("department",departmentDao.getDepartments());
			model.put("program", programDao.getPrograms());
			
			return "addprogram"; 
		}
		@RequestMapping(value="/addprogram.html", method=RequestMethod.POST)
	    public String signUp2(@ModelAttribute Program program, BindingResult result,@RequestParam String department)
	    { 
			Integer deptId = null;
			List<Department> departments = departmentDao.getDepartments();
			for(Department dept : departments){
				if(dept.getDepartmentName().equals(department)){
					deptId = dept.getDepartmentId();
					Department Dept = departmentDao.getDepartmentsById(deptId);
					program.setDepartment(Dept);
					programDao.saveProgram(program);
					
				}
			}
			
			System.out.println(deptId);
			return "redirect:addprogram.html"; 
			
		}
		@RequestMapping(value="/editdepartment.html", method=RequestMethod.GET)
		public String editdepartment1(ModelMap model, @RequestParam Integer departmentId)
	    { 	
			//model.put("department",departmentDao.getDepartments());
			Department dept = departmentDao.getDepartmentsById(departmentId);
			model.put("department", dept);
			return "editdepartment"; 
	    }
		@RequestMapping(value="/editdepartment.html", method=RequestMethod.POST)
	    public String removeProgram(@ModelAttribute Department department)
	    { 	
			departmentDao.saveDepartment(department);
			return "redirect:adddepartment.html"; 
	    }
		@RequestMapping(value="/removeprogram.html")
	    public String removeProgram1(@ModelAttribute Program program, @RequestParam Integer programId)
	    { 	
			Program pro = programDao.getProgramssById(programId);
			programDao.removeProgram(pro);
			return "redirect:addprogram.html";
	    }
		@RequestMapping(value="/removeadditionalinfo.html")
	    public String removeProgram1(@ModelAttribute AdditionalInfo additionalInfo, @RequestParam Integer additionalInfoId)
	    { 	
			AdditionalInfo additionalInfox = additionalInfoDao.getAdditionalInfoById(additionalInfoId);
			additionalInfoDao.removeAdditionalInfo(additionalInfox);
			return "redirect:addadditionalinfo.html";
	    }
		
		@RequestMapping(value="/displayApplications.html")
	    public String displayApplications(ModelMap model,  @RequestParam Integer id)
	    { 	
			
			model.put("userId",id);
			
			model.put("applications",applicationDao.getApplications());
			model.put("applicationStatus",applicationStatusDao.getApplicationStatuses());
			model.put("student", userDao.getUsersById(id));
			
			return "displayApplications"; 
		}
		@RequestMapping(value="/viewApplication.html",method=RequestMethod.GET)
	    public String viewApplications(ModelMap model,  @RequestParam Integer id)
	    { 	
			model.put("application",applicationDao.getApplicationById(id));
			model.put("applicationStatus",applicationStatusDao.getApplicationStatuses());
			return "viewApplication"; 
		}
		@RequestMapping(value="/addNewApplication.html",method=RequestMethod.GET)
	    public String addNewApplications(ModelMap model,@RequestParam Integer id, HttpSession session)
	    { 	
			Integer year = Calendar.getInstance().get(Calendar.YEAR);
			model.put("userId",id);
			
			List<Integer> years = new ArrayList<Integer>(); 
			for(int i = 0; i<5;i++){
				years.add(year++);
			}
			
			session.setAttribute("studentId", id);
			model.put("departments", departmentDao.getDepartments());
			model.put("years", years);
			model.put("application", new Application());
			return "addNewApplication"; 
		}
		@RequestMapping(value="/callajax.html",method=RequestMethod.GET)
	    public String CallAjax(@RequestParam String dept, HttpServletResponse response) throws IOException
	    { 	
			 List<String> list = new ArrayList<String>();
             String json = null;
             
             List<Program> programsList = programDao.getPrograms();
             for(Program program : programsList){
            	 if(program.getDepartment().getDepartmentName().equals(dept)){
            		 list.add(program.getProgramName());
            	 }
             }
             
	         json = new Gson().toJson(list);
	         response.setContentType("application/json");
	         response.getWriter().write(json);
			
	         return null;
	        
	    }
		@Autowired
		private WebApplicationContext webApplicationContext;
		public File getDirectory(){
			
			String path=webApplicationContext.getServletContext().getRealPath("/WEB-INF/files");
			return new File(path);
		}
		@RequestMapping(value="/addNewApplication.html", method=RequestMethod.POST)
	    public String addNewApplication(@RequestParam MultipartFile file, @RequestParam String submit, @RequestParam String program, @ModelAttribute Application application, HttpSession session) throws IllegalStateException, IOException
	    { 	
			Integer studentId =  (Integer) session.getAttribute("studentId");
			Users student = userDao.getUsersById(studentId);
			application.setUserId(student);
			Program saveProgram = null;
			List<Program> programsList = programDao.getPrograms();
			for(Program each_program : programsList){
				if(each_program.getProgramName().equals(program)){
					saveProgram = each_program;
				}
			}
			application.setProgramId(saveProgram);
			if(submit.equals("Submit")){
				application.setIsSubmitted(true);
				Date date = new Date();
				application.setSubmittedDate(date);
			}
			else{
				application.setIsSubmitted(false);
			}
			
			// file upload code
			file.transferTo(new File(getDirectory(), file.getOriginalFilename()) );
			application.setTranscript(file.getOriginalFilename());
			//end file upoad code
			//application.setTranscript(transcript.getOriginalFilename());
			//System.out.println(transcript.getOriginalFilename());
			applicationDao.saveApplication(application);
			return "redirect:addNewApplication.html?id="+studentId; 
	    }
		@RequestMapping(value="/downloadFile.html",method=RequestMethod.GET)
		public String downloadFile(HttpServletResponse response, @RequestParam String name) throws IOException{
			response.setContentType("text/plain");
	    	response.setHeader("Content-Disposition",
	    			"inline; filename=name");
	    	FileInputStream in = new FileInputStream(new File(getDirectory(),name));
	    	OutputStream out = response.getOutputStream();
	    	
	    	byte buffer[] = new byte[2048];
	    	int bytesread;
	    	
	    	while((bytesread = in.read(buffer)) >0)
	    		out.write(buffer,0,bytesread);
	    	
	    	in.close();
	    	
	    	return null;
		}
		@RequestMapping(value="/EditApplication.html",method=RequestMethod.GET)
	    public String editApplications( ModelMap model,  @RequestParam Integer studentId, @RequestParam Integer applicationId)
	    { 	
			Integer year = Calendar.getInstance().get(Calendar.YEAR);
			List<Integer> years = new ArrayList<Integer>(); 
			for(int i = 0; i<5;i++){
				years.add(year++);
			}
			model.put("years", years);
			
			model.put("application", new Application());
			
			model.put("application",applicationDao.getApplicationById(applicationId));
			Application application = applicationDao.getApplicationById(applicationId);
			Integer d = application.getProgramId().getDepartment().getDepartmentId();
			Department dept = departmentDao.getDepartmentsById(d);

			//get programs
			List<Program> programsList = dept.getPrograms();
			model.put("programs", programsList);
			//end get programs
			
			model.put("applicationStatus",applicationStatusDao.getApplicationStatuses());
			model.put("users", userDao.getUsersById(studentId));
			
			//get edu bg
			Users stu = userDao.getUsersById(studentId);
			Student student = studentDao.getStudentsById(studentId);
			
			List<StudentBackground> stuBg = stu.getStudentBackgroundId();
			model.put("stubg", stuBg);
			//edn edu bg
			
			return "EditApplication"; 
		}
		@RequestMapping(value="/EditApplication.html",method=RequestMethod.POST)
	    public String editApplicationSaveSubmit(@RequestParam String dateOfBirth,@RequestParam String phoneNumber,@RequestParam String citizenship, @RequestParam MultipartFile file,@RequestParam Integer programId, @ModelAttribute Application application, BindingResult result, @ModelAttribute Student student, @RequestParam String submit) throws IllegalStateException, IOException{
			
			// file upload code
			file.transferTo(new File(getDirectory(), file.getOriginalFilename()) );
			application.setTranscript(file.getOriginalFilename());
			//end file upoad code
					
			Application app = applicationDao.getApplicationById(application.getApplicationId());
			Program p = programDao.getProgramssById(programId);
			app.setProgramId(p);//set

			String year = app.getTermYear();
			
			app.setTermSeason(application.getTermSeason());
			app.setTermYear(application.getTermYear());
			
			//app.setApplicationStatus(applicationStatus);//set
			if(submit.equals("Submit")){
	    		app.setIsSubmitted(true);
	    		Date date1 = new Date();
				app.setSubmittedDate(date1);
			}
			else{
				app.setIsSubmitted(false);
			}
			System.out.println(submit+" is Ssubmit");
			applicationDao.saveApplication(app);
			
			//save user
			Student st = (Student)userDao.getUsersById(student.getUserId());
			st.setUserEmail(student.getUserEmail());
			st.setUserPassword(student.getUserPassword());
			st.setUserFirstName(student.getUserFirstName());
			st.setUserLastName(student.getUserLastName());
			st.setUserCIN(student.getUserCIN());
			st.setCitizenship(citizenship);
			st.setPhoneNumber(Long.parseLong(phoneNumber));
			st.setDateOfBirth(dateOfBirth);
			userDao.saveUser(st);
			studentDao.saveStudent(st);
			//end save user
			
			System.out.println("Hi");
			return "redirect:displayApplications.html?id="+student.getUserId(); 
		}
		@RequestMapping(value="/addStudentBackground.html",method=RequestMethod.GET)
	    public String addStudentBackground(ModelMap model,  @RequestParam Integer studentId,  HttpSession session)
	    { 	
			session.setAttribute("studentId", studentId);
			model.put("userId", studentId);
			List<StudentBackground> studentBackgroundList = userDao.getUsersById(studentId).getStudentBackgroundId();
			model.put("StudentBackground", studentBackgroundList);
			model.put("studentBackground", new StudentBackground());

			return "addStudentBackground";
		}
		@RequestMapping(value="/addStudentBackground.html",method=RequestMethod.POST)
	    public String addStudentBackground(@ModelAttribute StudentBackground studentBackground, BindingResult result, HttpSession session)
	    { 	
			Integer studentId =  (Integer) session.getAttribute("studentId");
			studentBackground.setUserId(userDao.getUsersById(studentId));
			studentBackgroundDao.saveStudentBackground(studentBackground);
			return "redirect:addStudentBackground.html?studentId="+studentId; 
		}
		@RequestMapping(value="/removeStudentBackground.html")
	    public String removeStudentBackground(@ModelAttribute StudentBackground studentBackground, @RequestParam Integer studentBackgroundId, HttpSession session)
		{	 	
			StudentBackground stubg = studentBackgroundDao.getstudentBackgroundById(studentBackgroundId);
			studentBackgroundDao.removeStudentBackground(stubg);
			Integer studentId =  (Integer) session.getAttribute("studentId");
			
			return "redirect:addStudentBackground.html?studentId="+studentId;
	    }
}
