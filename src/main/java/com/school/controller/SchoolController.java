package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.model.School;

import con.school.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolService serv;

	public SchoolController(SchoolService serv) {
		super();
		this.serv = serv;
	}
	
	@PostMapping
	public ResponseEntity<School> saveSchool(@RequestBody School sch) {
		
		return new ResponseEntity<School>(serv.saveSchool(sch),HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<School> getAll() {
		return serv.getAllSchool();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<School> getById(@PathVariable long id) {
		return new ResponseEntity<School>(serv.getSchoolById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<School> updateSchool(@RequestBody School sch, @PathVariable long id) {
		
		return new ResponseEntity<School>(serv.updateSchool(sch, id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSchool(@PathVariable long id) {
		serv.deleteSchool(id);
		return new ResponseEntity<String>("School deleted successfully",HttpStatus.OK);
	}
	
}
