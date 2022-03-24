package con.school.service;

import java.util.List;

import com.school.model.ClassInfo;

public interface ClassService {

	ClassInfo saveClass(ClassInfo cl);
	
	ClassInfo getClassById(long id);
	
	List<ClassInfo> getAll();
	
	ClassInfo updateClass(ClassInfo cl,long id);
	
	void deleteClass(long id);
	
}
