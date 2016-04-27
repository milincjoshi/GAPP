package springmvc.model;

import javax.persistence.*;
@Entity
@Table(name="AdditionalValues")
public class AdditionalValues {

	@Id @GeneratedValue
	@Column(name="AdditionalValueId")
	private int additionalValueId;
	public int getAdditionalValueId() { return additionalValueId; }
	public void setAdditionalValueId(int additionalValueId) { this.additionalValueId = additionalValueId; }

	@ManyToOne
	@JoinColumn(name="additionalInfoId")
	private AdditionalInfo additionalInfoId;
	public AdditionalInfo getAdditionalInfoId() { return additionalInfoId; }
	public void setAdditionalInfoId(AdditionalInfo additionalInfoId) {this.additionalInfoId = additionalInfoId; }

	private String typeValue;
	public String getTypeValue() { return typeValue; }
	public void setTypeValue(String typeValue) { this.typeValue = typeValue; }
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Users userId;
	public Users getUserId() { return userId; }
	public void setUserId(Users userId) {this.userId = userId; }

}
