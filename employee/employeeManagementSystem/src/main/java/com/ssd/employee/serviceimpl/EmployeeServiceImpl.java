package com.ssd.employee.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ssd.employee.entity.Employee;
import com.ssd.employee.exception.ClientErrorException;
import com.ssd.employee.payload.DepartmentDto;
import com.ssd.employee.payload.EmployeeDto;
import com.ssd.employee.payload.ResponceDto;
import com.ssd.employee.payload.UpdateEmployeeDto;
import com.ssd.employee.repository.EmployeeRepository;
import com.ssd.employee.serviceinterface.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ApiClient apiClient;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = toEmp(employeeDto);

		employee.setHiredate(new Date());
		employee = employeeRepository.save(employee);
		employeeDto = toEmpDto(employee);

		return employeeDto;
	}

	@Override
	public String deleteEmployee(Long empNo) {

		Employee employee = employeeRepository.findByEmpno(empNo)
				.orElseThrow(() -> new ClientErrorException("employee number not found in data base"));
		employeeRepository.deleteById(employee.getId());

		return "delete employee " + empNo;
	}

	@Override
	public List<ResponceDto> getAllEMployees() {

		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> employeeDtos = employees.stream().map(emp -> toEmpDto(emp)).collect(Collectors.toList());

		List<ResponceDto> dtos = new ArrayList<>();

		employeeDtos.forEach(emp -> {
			ResponceDto dto = new ResponceDto();
			dto.setEmployeeDto(emp);
			dto.setDepartmentDto(apiClient.getByDeparmentId(emp.getDeptno()));
			dtos.add(dto);

		});

		return dtos;
	}

	@Override
	public ResponceDto getByEmpNo(Long empno) {

		Employee employee = employeeRepository.findByEmpno(empno)
				.orElseThrow(() -> new ClientErrorException("employee number not found in data base"));

//		DepartmentDto departmentDto = apiClient.getByDeparmentId(employee.getDeptno());

		DepartmentDto departmentDto = restTemplate.getForObject("http://localhost:9096/api/dept//dept/{id}",
				DepartmentDto.class, employee.getDeptno());

		ResponceDto dto = new ResponceDto();
		dto.setEmployeeDto(toEmpDto(employee));
		dto.setDepartmentDto(departmentDto);

		return dto;
	}

	@Override
	public EmployeeDto updateByEmpNo(Long empNo, UpdateEmployeeDto dto) {

		Employee employee = employeeRepository.findByEmpno(empNo)
				.orElseThrow(() -> new ClientErrorException("employee number not found in data base"));

		if (dto.getComm() != null) {

			employee.setComm(dto.getComm());
		}

		if (dto.getDeptno() != null) {

			employee.setDeptno(dto.getDeptno());
		}
		if (dto.getEname() != null) {

			employee.setEname(dto.getEname());
		}

		if (dto.getJob() != null) {

			employee.setJob(dto.getJob());
		}
		if (dto.getMgr() != null) {

			employee.setMgr(dto.getMgr());
		}

		if (dto.getSal() != null) {

			employee.setSal(dto.getSal());
		}

		employee = employeeRepository.save(employee);

		EmployeeDto dto2 = toEmpDto(employee);

		return dto2;
	}

	public EmployeeDto toEmpDto(Employee employee) {

		return mapper.map(employee, EmployeeDto.class);
	}

	public Employee toEmp(EmployeeDto dto) {

		return mapper.map(dto, Employee.class);
	}

}
