package com.jsp.student_rest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DataAlredyExistsException  extends RuntimeException{
	
	String message = "Data Already Exists";
}
