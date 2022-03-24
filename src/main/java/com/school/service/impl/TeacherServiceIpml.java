package com.school.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.exception.ResourceNotFind;
import com.school.model.teacher;
import com.school.repository.TeacherRepo;

import con.school.service.TeacherService;
@Service
public class TeacherServiceIpml implements TeacherService{

private TeacherRepo repo;
	
	public TeacherServiceIpml(TeacherRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public teacher saveTeacher(teacher t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public List<teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public teacher getTeacherById(long id) {
		
		return repo.findById(id).orElseThrow(()->new ResourceNotFind("teacher", "id", id));
	}

	@Override
	public teacher updateTeacher(teacher t, long id) {
		
		teacher exist_teach=repo.findById(id).orElseThrow(()->new ResourceNotFind("teacher", "id", id));
		
		exist_teach.setAddress(t.getAddress());
		exist_teach.setName(t.getName());
		
		repo.save(exist_teach);
		
		return exist_teach;
	}

	@Override
	public void deleteTeacher(long id) {
		repo.findById(id).orElseThrow(()->new ResourceNotFind("teacher", "id", id));
		
		repo.deleteById(id);

	}
	
}
