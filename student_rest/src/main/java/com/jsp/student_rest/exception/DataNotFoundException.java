package com.jsp.student_rest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataNotFoundException extends RuntimeException {
	String message = "No Data Present";
}
