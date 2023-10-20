package com.ssd.employee.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponceDto {

	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;
}
