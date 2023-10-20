package com.ssd.employee.serviceinterface;

import java.util.List;

import com.ssd.employee.payload.EmployeeDto;
import com.ssd.employee.payload.ResponceDto;
import com.ssd.employee.payload.UpdateEmployeeDto;

public interface EmployeeService {

	public EmployeeDto createEmployee(EmployeeDto employeeDto);

	public String deleteEmployee(Long empNo);
	
	public List<ResponceDto> getAllEMployees();
	
	public ResponceDto getByEmpNo(Long empno);
	
	public EmployeeDto updateByEmpNo(Long empNo,UpdateEmployeeDto dto);

}
