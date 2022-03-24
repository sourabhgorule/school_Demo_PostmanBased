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

import com.school.model.teacher;
import com.school.service.impl.TeacherServiceIpml;

import con.school.service.TeacherService;


@RestController
@RequestMapping("/teacher")
public class TeacherController {

	private TeacherService serv;
	
	public TeacherController(TeacherService serv) {
		super();
		this.serv = serv;
	}
	
	@PostMapping
	public ResponseEntity<teacher> saveTeacher(@RequestBody teacher t) {
		
		return new ResponseEntity<teacher>(serv.saveTeacher(t),HttpStatus.CREATED);

		}
	@GetMapping
	public List<teacher> getAllTeacher() {
		return serv.getAllTeacher();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<teacher> updateTeacher(@RequestBody teacher t, @PathVariable long id) {
		return new ResponseEntity<teacher>(serv.updateTeacher(t, id),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<teacher> getById(@PathVariable long id) {
		return new ResponseEntity<teacher>(serv.getTeacherById(id),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable long id) {
		return new ResponseEntity<String>("teacher deleted from database.",HttpStatus.OK);
	}
	
	
}
