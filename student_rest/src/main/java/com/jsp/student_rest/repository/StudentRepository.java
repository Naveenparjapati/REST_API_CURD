package com.jsp.student_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.student_rest.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	boolean existsByMobile(Long mobile);
	
}
