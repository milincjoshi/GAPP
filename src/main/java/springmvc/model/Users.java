package springmvc.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED)
public class Users {


	@Id @GeneratedValue
	@Column(name="userId")
	private int userId;

	@Column(name="userEmail")
	private String userEmail;
	
	@Column(name="userPassword")
	private String userPassword;

	@Column(name="userFirstName")
	private String userFirstName;

	@Column(name="userLastName")
	private String userLastName;

	public int getUserId() {return userId;}

	public void setUserId(int userId) {this.userId = userId;}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserCIN() {
		return userCIN;
	}

	public void setUserCIN(String userCIN) {
		this.userCIN = userCIN;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<AdditionalValues> getAdditionalValues() {
		return additionalValues;
	}

	public void setAdditionalValues(List<AdditionalValues> additionalValues) {
		this.additionalValues = additionalValues;
	}

	public List<StudentBackground> getStudentBackgroundId() {
		return studentBackgroundId;
	}

	public void setStudentBackgroundId(List<StudentBackground> studentBackgroundId) {
		this.studentBackgroundId = studentBackgroundId;
	}


	@Column(name="userCIN")
	private String userCIN;

	@Column(name="userType")
	private String userType;
	
	@OneToMany(mappedBy = "userId")
	private List<AdditionalValues> additionalValues;

	@OneToMany(mappedBy = "userId")
	private List<StudentBackground> studentBackgroundId;

	
	@OneToMany(mappedBy="userId")
	private List<Application> application;
	
	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	
}
