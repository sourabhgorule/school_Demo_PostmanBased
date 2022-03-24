package com.school.controller;

import java.util.List;

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

import com.school.model.ClassInfo;

import con.school.service.ClassService;

@RestController
@RequestMapping("/class")
public class ClassController {

	private ClassService cs;
	
	public ClassController(ClassService cs) {
		super();
		this.cs = cs;
	}

	@PostMapping
	public ResponseEntity<ClassInfo> save(@RequestBody ClassInfo cl) {

		return new ResponseEntity<ClassInfo>(cs.saveClass(cl),HttpStatus.CREATED); 
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ClassInfo> getById(@PathVariable long id) {
		return new ResponseEntity<ClassInfo>(cs.getClassById(id),HttpStatus.OK);
	}
	
	@GetMapping
	public List<ClassInfo> GetAll() {
		
		return cs.getAll();
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ClassInfo> updateClass(@PathVariable long id,@RequestBody ClassInfo cl) {
		
		return new ResponseEntity<ClassInfo>(cs.updateClass(cl, id),HttpStatus.OK);
		
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteClass(@PathVariable long id) {
		cs.deleteClass(id);
		return new ResponseEntity<String>("record deleted successfully..",HttpStatus.OK);
	}
}
