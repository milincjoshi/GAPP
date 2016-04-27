package springmvc.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="AdditionalInfo")
public class AdditionalInfo {

	@Id @GeneratedValue
	@Column(name="additionalInfoId")
	private int additionalInfoId;
	
	@Column(name="InfoName")
	private String infoName;
	
	@Column(name="InfoType")
	private String infoType;
	 
	@Column(name="InfoRequired")
	private Boolean infoRequired;

	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department departmentId;
	
	@OneToMany(mappedBy = "additionalInfoId")
	private List<AdditionalValues> additionalValuesId;

	public int getAdditionalInfoId() {
		return additionalInfoId;
	}

	public void setAdditionalInfoId(int additionalInfoId) {
		this.additionalInfoId = additionalInfoId;
	}

	public String getInfoName() {
		return infoName;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public Boolean getInfoRequired() {
		return infoRequired;
	}

	public void setInfoRequired(Boolean infoRequired) {
		this.infoRequired = infoRequired;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public List<AdditionalValues> getAdditionalValuesId() {
		return additionalValuesId;
	}

	public void setAdditionalValuesId(List<AdditionalValues> additionalValuesId) {
		this.additionalValuesId = additionalValuesId;
	}


}
