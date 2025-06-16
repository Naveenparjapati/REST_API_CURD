package com.jsp.student_rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
	private String name;
	private Long mobile;
	private Integer maths;
	private Integer science;
	private Integer english;
}
