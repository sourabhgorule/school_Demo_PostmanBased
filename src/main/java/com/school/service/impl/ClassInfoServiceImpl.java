package com.school.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.exception.ResourceNotFind;
import com.school.model.ClassInfo;
import com.school.repository.ClassRepo;

import con.school.service.ClassService;

@Service
public class ClassInfoServiceImpl implements ClassService {

	private ClassRepo cr;
	
	public ClassInfoServiceImpl(ClassRepo cr) {
		super();
		this.cr = cr;
	}

	@Override
	public ClassInfo saveClass(ClassInfo cl) {
		// TODO Auto-generated method stub
		return cr.save(cl);
	}

	@Override
	public ClassInfo getClassById(long id) {
		// TODO Auto-generated method stub
		return cr.findById(id).orElseThrow(()->new ResourceNotFind("Class", "id",id));
	}

	@Override
	public List<ClassInfo> getAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public ClassInfo updateClass(ClassInfo cl, long id) {
		
	ClassInfo existing_c=cr.findById(id).orElseThrow(()->new ResourceNotFind("Class", "id", id));
	
	existing_c.setClassName(cl.getClassName());
		
		 cr.save(existing_c);
		 
		 return existing_c;
	}

	@Override
	public void deleteClass(long id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}

}
