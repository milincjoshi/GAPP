package springmvc.model.dao;

import java.util.List;

import springmvc.model.StudentBackground;

public interface StudentBackgroundDao {
	StudentBackground getstudentBackgroundById(Integer Id);
	List<StudentBackground> getstudentBackgrounds();
	StudentBackground saveStudentBackground(StudentBackground studentBackground);
	void removeStudentBackground(StudentBackground studentBackground);

}
