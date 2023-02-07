package com.kiran.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.requestResponse.StudentRequest;
import com.kiran.requestResponse.StudentResponse;
import com.kiran.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	public StudentResponse createStudent(@RequestBody StudentRequest req) {
		 return studentService.createStudent(req);
	}
	
	@GetMapping("/getById/{id}")
	public StudentResponse getById(@PathVariable long id) {
		 return studentService.getById(id);
	}
	
	
	
}
