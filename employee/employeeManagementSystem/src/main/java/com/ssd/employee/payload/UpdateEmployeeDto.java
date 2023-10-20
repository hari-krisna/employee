package com.ssd.employee.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeDto {

	private String ename;
	private String job;
	private Long mgr;
	private Double sal;
	private Double comm;
	private Long deptno;

}
