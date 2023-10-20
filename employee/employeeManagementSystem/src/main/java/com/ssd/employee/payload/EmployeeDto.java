package com.ssd.employee.payload;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	@NotNull(message = "empNo is required")
	private Long empno;
	@NotNull(message = "ename is required")
	private String ename;
	@NotNull(message = "job is required")
	private String job;
	@NotNull(message = "mgr is required")
	private Long mgr;
	private Date hiredate;
	@NotNull(message = "sal is required")
	private Double sal;
	@NotNull(message = "comm is required")
	private Double comm;
	@NotNull(message = "deptno is required")
	private Long deptno;
}
