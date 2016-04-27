package springmvc.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Students")
public class Student extends Users {

	/*
	@OneToMany(mappedBy = "studentBackgroundId")
	private List<StudentBackground> studentBackground;
	public List<StudentBackground> getStudentBackground() {return studentBackground;}
	public void setStudentBackground(List<StudentBackground> studentBackground) {this.studentBackground = studentBackground;}
	*/

	@Column(name="type")
	private String type;
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	@Column(name="phoneNumber")
	private long phoneNumber;
	public long getPhoneNumber() { return phoneNumber; }
	public void setPhoneNumber(long phoneNumber) { this.phoneNumber = phoneNumber; }

	@Column(name="dateOfBirth")
	private String dateOfBirth;
	public String getDateOfBirth() { return dateOfBirth; }
	public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

	@Column(name="citizenship")
	private String citizenship;
	public String getCitizenship() { return citizenship; }
	public void setCitizenship(String citizenship) { this.citizenship = citizenship; }

	/*
	@OneToMany(mappedBy="applicationId")
	private List<Application> application;
	public List<Application> getApplication() {return application;}
	public void setApplication(List<Application> application) {this.application = application;}
	*/
}
