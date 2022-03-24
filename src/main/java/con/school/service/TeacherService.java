package con.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.model.teacher;


public interface TeacherService {

	teacher saveTeacher(teacher t);
	
	List<teacher> getAllTeacher();
	
	teacher getTeacherById(long id);
	
	teacher updateTeacher(teacher t, long id);
	
	void deleteTeacher(long id);
	
}
