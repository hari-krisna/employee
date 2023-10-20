package com.ssd.employee.serviceinterface;

import java.util.List;

import com.ssd.employee.payload.DepartmentDto;

public interface DepartmentService {

	public DepartmentDto createDepartment(DepartmentDto departmentDto);

	public List<DepartmentDto> getAlldept();
	public DepartmentDto getByDepartmentId(Long id );

}
