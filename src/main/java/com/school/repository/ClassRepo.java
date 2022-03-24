package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.ClassInfo;

public interface ClassRepo extends JpaRepository<ClassInfo, Long> {

}
