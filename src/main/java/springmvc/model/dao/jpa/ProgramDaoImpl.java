package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Department;
import springmvc.model.Program;
import springmvc.model.Users;
import springmvc.model.dao.ProgramDao;

@Repository
public class ProgramDaoImpl implements ProgramDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Program getProgramssById(Integer Id) {
			return entityManager.find(Program.class, Id);
	}

	@Override
	public List<Program> getPrograms() {
		return entityManager.createQuery("from Program", Program.class).getResultList();
	}

	@Override
	@Transactional
	public Program saveProgram(Program program) {
			return entityManager.merge(program);
	}

	@Override
	@Transactional
	public void removeProgram(Program program) {
		System.out.println("deleting "+program.getProgramId());
		entityManager.remove(program);
	}

}
