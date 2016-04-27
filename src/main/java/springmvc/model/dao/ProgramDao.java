package springmvc.model.dao;

import java.util.List;

import springmvc.model.Program;

public interface ProgramDao {
	Program getProgramssById(Integer Id);
	List<Program> getPrograms();
	Program saveProgram(Program program);
	void removeProgram(Program program);

}
