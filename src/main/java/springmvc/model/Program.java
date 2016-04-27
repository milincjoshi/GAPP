package springmvc.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Program")
public class Program {

	@Id @GeneratedValue
	@Column(name="programId")
	private int programId;
	public int getProgramId() { return programId; }
	public void setProgramId(int programId) { this.programId = programId; }
	
	@Column(name="programName")
	private String programName;
	public String getProgramName() { return programName; }
	public void setProgramName(String programName) { this.programName = programName; }
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
	public Department getDepartment() {return department; }
	public void setDepartment(Department department) { this.department = department; }
	
	@OneToMany(mappedBy = "programId")
	private List<Application> applicationId;
	public List<Application> getApplicationId() { return applicationId; }
	public void setApplicationId(List<Application> applicationId) { this.applicationId = applicationId; }

}
