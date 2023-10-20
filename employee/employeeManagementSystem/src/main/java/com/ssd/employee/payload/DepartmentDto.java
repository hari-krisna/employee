package com.ssd.employee.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
	private Long id;
	private Long deptNo;
	private String dName;
	private String location;

}
