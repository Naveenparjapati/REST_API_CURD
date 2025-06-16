package com.jsp.student_rest.entity;

import com.jsp.student_rest.dto.StudentDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Student {
	
	public Student(StudentDTO dto) {
		this.name = dto.getName();
		this.mobile = dto.getMobile();
		this.maths = dto.getMaths();
		this.science = dto.getScience();
		this.english = dto.getEnglish();
		this.percentage = (dto.getMaths()+dto.getEnglish()+dto.getScience())/3.0;
	}
	@Id
	@GeneratedValue(generator = "id")
	@SequenceGenerator(initialValue = 101001, allocationSize = 1 , name = "id")
	private Long id;
	private String name;
	private Long mobile;
	private Integer maths;
	private Integer science;
	private Integer english;
	private Double percentage;
}
