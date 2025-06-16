package com.jsp.student_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.student_rest.dto.StudentDTO;
import com.jsp.student_rest.entity.Student;
import com.jsp.student_rest.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.Delegate;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	//save a record
	@PostMapping("/student")
	@Operation(summary = "Save Record")
	public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO dto ) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(dto));
	}
	
	@PostMapping("/students")
	@Operation(summary = "Save Multiple Records")
	public ResponseEntity<List<Student>> saveMultipleStudent(@RequestBody List<StudentDTO> dtos){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudents(dtos));
	}
	
	//fetch records
	@GetMapping("/students")
	@Operation(summary = "Fetch All The Records")
	public ResponseEntity<List<Student>> fetchStudents
	(@RequestParam(defaultValue = "id") String sort,
	 @RequestParam(defaultValue = "false") boolean desc,
	 @RequestParam(defaultValue = "1") int page,
	 @RequestParam(defaultValue = "10") int data){
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchAll(sort,desc,page,data));
	}
	
	// Fetch a student by ID
	@GetMapping("/student/{id}")
	@Operation(summary = "Fetch a student by ID")
	public ResponseEntity<Student> fetchById(@PathVariable Long id) {
	    Student student = service.getStudentById(id);
	    if (student != null) {
	        return ResponseEntity.status(HttpStatus.OK).body(student);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
		
	//Delete a Record
	@DeleteMapping("/student/{id}")
	@Operation(summary = "Delete by Id")
	public ResponseEntity<String> deleteRecord(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteRecordById(id));
	}
	
	//update
	@PutMapping("/student")
	@Operation(summary = "Update the Record")
	public ResponseEntity<String> updateStudent(@RequestBody Student student ) {
		return ResponseEntity.status(HttpStatus.OK).body(service.updateStudent(student));
	}
	

	// Update a student by ID
	@PutMapping("/student/{id}")
	@Operation(summary = "Update a student by ID")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
	    Student student = service.updateStudent(id, updatedStudent);
	    if (student != null) {
	        return ResponseEntity.status(HttpStatus.OK).body(student);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
	
}
