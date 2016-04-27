package springmvc.model;

import javax.persistence.*;

@Entity
@Table(name="applicationStatus")
public class ApplicationStatus {

	@Id @GeneratedValue
	private int applicationStatusId;
	public int getApplicationStatusId() { return applicationStatusId; }
	public void setApplicationStatusId(int applicationStatusId) { this.applicationStatusId = applicationStatusId; }
	
	@ManyToOne
	@JoinColumn(name="applicationId")
	private Application applicationId;
	public Application getApplicationId() { return applicationId; }
	public void setApplicationId(Application applicationId) { this.applicationId = applicationId; }
	
	@Column(name="applicationStatus")
	private String applicationStatus;
	public String getApplicationStatus() { return applicationStatus; }
	public void setApplicationStatus(String applicationStatus) { this.applicationStatus = applicationStatus; }
	
	@Column(name="applicationTime")
	private String applicationTime;
	public String getApplicationTime() { return applicationTime; }
	public void setApplicationTime(String applicationTime) { this.applicationTime = applicationTime; }
	
	@Column(name="applicationComment")
	private String applicationComment;
	public String getApplicationComment() { return applicationComment; }
	public void setApplicationComment(String applicationComment) { this.applicationComment = applicationComment; }
	
}
