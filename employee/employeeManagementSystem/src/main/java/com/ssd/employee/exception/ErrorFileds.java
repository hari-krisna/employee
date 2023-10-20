package com.ssd.employee.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorFileds {

	private Date timeStamp;
	private String msg;
	private String title;
	
	
	
	
	
	
}
