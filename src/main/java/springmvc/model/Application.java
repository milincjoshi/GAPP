package springmvc.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="application")
public class Application {

	@Id @GeneratedValue
	@Column(name="applicationId")
	private int applicationId;
	public int getApplicationId() { return applicationId; }
	public void setApplicationId(int applicationId) { this.applicationId = applicationId; }

	@ManyToOne
	@JoinColumn(name="userId")
	private Users userId;
	public Users getUserId() { return userId; }
	public void setUserId(Users userId) { this.userId = userId; }

	/*
	@ManyToOne
	@JoinColumn(name="userId")
	private Student userId;
	public Student getUserId() {
		return userId;
	}
	public void setUserId(Student userId) {
		this.userId = userId;
	}
	 */
	@ManyToOne
	@JoinColumn(name="programId")
	private Program programId;
	public Program getProgramId() { return programId; }
	public void setProgramId(Program programId) { this.programId = programId; }

	@OneToMany(mappedBy = "applicationId")
	private List<ApplicationStatus> applicationStatus;
	public List<ApplicationStatus> getApplicationStatus() { return applicationStatus; }
	public void setApplicationStatus(List<ApplicationStatus> applicationStatus) { this.applicationStatus = applicationStatus; }

	@Column(name="termSeason")
	private String termSeason;
	public String getTermSeason() { return termSeason; }
	public void setTermSeason(String termSeason) { this.termSeason = termSeason; }
	
	@Column(name="termYear")
	private String termYear;
	public String getTermYear() { return termYear; }
	public void setTermYear(String termYear) { this.termYear = termYear; }
	
	@Column(name="isSubmitted")
	private Boolean isSubmitted;
	public Boolean getIsSubmitted() {
		return isSubmitted;
	}
	public void setIsSubmitted(Boolean isSubmitted) {
		this.isSubmitted = isSubmitted;
	}
	
	@Column(name="submittedDate")
	private Date submittedDate;
	
	public Date getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	@Column(name="transcript")
	private String transcript;
	public String getTranscript() {
		return transcript;
	}
	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}
	
	
}
