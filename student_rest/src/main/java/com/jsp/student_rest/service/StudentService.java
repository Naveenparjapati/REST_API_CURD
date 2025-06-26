package com.jsp.student_rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jsp.student_rest.dto.StudentDTO;
import com.jsp.student_rest.entity.Student;
import com.jsp.student_rest.exception.DataAlredyExistsException;
import com.jsp.student_rest.exception.DataNotFoundException;
import com.jsp.student_rest.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;
	
	public Student saveStudent(StudentDTO dto) {
		if(!repository.existsByMobile(dto.getMobile())) {
		Student student = new Student(dto);
//		student.setName(dto.getName());
//		student.setMobile(dto.getMobile());
//		student.setMaths(dto.getMaths());
//		student.setScience(dto.getScience());
//		student.setEnglish(dto.getEnglish());
		repository.save(student);
		return student;
		}else {
			throw new DataAlredyExistsException("Mobile Number Already Exists:"+ dto.getMobile());
		}
	}

	public List<Student> saveStudents(List<StudentDTO> dtos) {
		List<Student> students = new ArrayList<Student>();
		for(StudentDTO dto : dtos) {
			if(repository.existsByMobile(dto.getMobile()))
				throw new DataAlredyExistsException("Mobile Number Already Exists: " + dto.getMobile());
			else
				students.add(repository.save(new Student(dto)));
		}
		return students;
	}
	
	public List<Student> fetchAll(String sort, boolean desc, int page, int data) {
		
		Sort sortBasedOn = Sort.by(sort);
		if (desc)
			sortBasedOn = sortBasedOn.descending();
		
		Pageable pageable = PageRequest.of(page - 1, data, sortBasedOn);
		
		Page<Student> records = repository.findAll(pageable);
		
		if(!records.isEmpty())
			return records.getContent();
		else
			throw new DataNotFoundException();
	}

	
	
	public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null); // Fetch student by ID, return null if not found
    }

	
	
	
	public String deleteRecordById(Long id) {
		repository.deleteById(id);
		return "Record Deleted Sucessfully";
	}

	public String updateStudent(Student student) {
		repository.save(student);
		return "Record Updated Sucessfully";
	}
	
	

	public Student updateStudent(Long id, Student updatedStudent) {
	    return repository.findById(id).map(student -> {
	        student.setName(updatedStudent.getName());
	        // student.setEmail(updatedStudent.getEmail());
	        // Update other fields as necessary
	        return repository.save(student); // Save the updated student
	    }).orElseThrow(() -> new DataNotFoundException("Student with ID " + id + " not found"));
	}


	

}
