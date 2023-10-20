package com.ssd.employee.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ssd.employee.payload.EmployeeDto;
import com.ssd.employee.payload.ResponceDto;
import com.ssd.employee.payload.UpdateEmployeeDto;
import com.ssd.employee.serviceinterface.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/emp")

public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/welcome")
	//@HystrixCommand(fallbackMethod = "fallBackGetWelcomeNote")
	public String getWelcomeNote() {

	//	String msg = restTemplate.getForObject("http://localhost:8080/api/dept/dept/msg", String.class);

		return "hiiii";
	}

	@PostMapping("/emp")
	public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto dto) {

		return new ResponseEntity<EmployeeDto>(employeeService.createEmployee(dto), HttpStatus.CREATED);
	}

	@GetMapping("/emp")
	public ResponseEntity<List<ResponceDto>> getAllEmployees() {

		return new ResponseEntity<List<ResponceDto>>(employeeService.getAllEMployees(), HttpStatus.OK);
	}

	@GetMapping("/emp/{id}")
	// @HystrixCommand(fallbackMethod = "getByEmpIdh")
	public ResponseEntity<ResponceDto> getByEmpId(@PathVariable("id") Long id) {

		return new ResponseEntity<ResponceDto>(employeeService.getByEmpNo(id), HttpStatus.OK);

	}

	@DeleteMapping("/emp/{id}")
	public ResponseEntity<String> deleteByEmpId(@PathVariable("id") Long id) {

		return new ResponseEntity<String>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}

	@PutMapping("/emp/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody UpdateEmployeeDto dto) {

		return new ResponseEntity<EmployeeDto>(employeeService.updateByEmpNo(id, dto), HttpStatus.UPGRADE_REQUIRED);
	}

	public String fallBackGetWelcomeNote() {
		return "dept server down";
	}

}
