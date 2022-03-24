package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.School;

public interface SchoolRepo extends JpaRepository<School, Long>{
	
	

}
