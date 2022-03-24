package com.school.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.school.exception.ResourceNotFind;
import com.school.model.School;
import com.school.repository.SchoolRepo;

import con.school.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepo repo;
	
	public SchoolServiceImpl(SchoolRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public School saveSchool(School sch) {
		// TODO Auto-generated method stub
		return repo.save(sch);
	}

	@Override
	public List<School> getAllSchool() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public School getSchoolById(long id) {
		
		return repo.findById(id).orElseThrow(()->new ResourceNotFind("School", "id", id));
	}

	@Override
	public School updateSchool(School sch, long id) {
		
		School exist_sch=repo.findById(id).orElseThrow(()->new ResourceNotFind("School","id",id));
		
		exist_sch.setAddress(sch.getAddress());
		exist_sch.setName(sch.getName());
		
		repo.save(exist_sch);
			return exist_sch;
	}

	@Override
	public void deleteSchool(long id) {
		
		repo.findById(id).orElseThrow(()->new ResourceNotFind("school", "id", id));
		
		repo.deleteById(id);

		
	}

	
	
	}
