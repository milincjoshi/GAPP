package springmvc.model;

import javax.persistence.*;

@Entity
@Table(name="studentBackground")
public class StudentBackground {

	@Id @GeneratedValue
	@Column(name="studentbackgroundId")
	private int studentBackgroundId;
	public int getStudentBackgroundId() { return studentBackgroundId; }
	public void setStudentBackgroundId(int studentBackgroundId) { this.studentBackgroundId = studentBackgroundId; }
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Users userId;//students
	public Users getUserId() { return userId; }
	public void setUserId(Users userId) { this.userId = userId; }
	
	@Column(name="studentUniversity")
	private String studentUniversity;
	public String getStudentUniversity() { return studentUniversity; }
	public void setStudentUniversity(String studentUniversity) { this.studentUniversity = studentUniversity;	}

	@Column(name="studentDegree")
	private String studentDegree;
	public String getStudentDegree() { return studentDegree; }
	public void setStudentDegree(String studentDegree) { this.studentDegree = studentDegree; }
	
	@Column(name="studentDegreeFrom")
	private String studentDegreeFrom;
	public String getStudentDegreeFrom() { return studentDegreeFrom; }
	public void setStudentDegreeFrom(String studentDegreeFrom) { this.studentDegreeFrom = studentDegreeFrom; }
	
	@Column(name="studentDegreeTo")
	private String studentDegreeTo;
	public String getStudentDegreeTo() { return studentDegreeTo; }
	public void setStudentDegreeTo(String studentDegreeTo) { this.studentDegreeTo = studentDegreeTo; }
	
	@Column(name="studentMajor")
	private String studentMajor;
	public String getStudentMajor() { return studentMajor; }
	public void setStudentMajor(String studentMajor) { this.studentMajor = studentMajor; }
	
}
