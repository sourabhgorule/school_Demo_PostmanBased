package con.school.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.School;

public interface SchoolService{

	School saveSchool(School sch);
	
	List<School> getAllSchool();
	
	School getSchoolById(long id);
	
	School updateSchool(School sch,long id);
	
	void deleteSchool(long id);
	
	
	
}
