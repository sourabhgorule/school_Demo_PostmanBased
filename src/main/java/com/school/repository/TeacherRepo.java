package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.teacher;

public interface TeacherRepo extends JpaRepository<teacher, Long>{

}
