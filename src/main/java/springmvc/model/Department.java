package springmvc.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="Department")
public class Department {

	@Id @GeneratedValue
	@Column(name="departmentId")
	private int departmentId;
	
	@Column(name="departmentName")
	private String departmentName;
	
	@OneToMany(mappedBy = "department")
	private List<Program> programs;

	@OneToMany(mappedBy = "departmentId")
	private List<AdditionalInfo> additionalInfo;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	public List<AdditionalInfo> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(List<AdditionalInfo> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}
