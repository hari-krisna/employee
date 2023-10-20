package com.ssd.employee.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.employee.payload.DepartmentDto;
import com.ssd.employee.serviceinterface.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/dept")
	public ResponseEntity<DepartmentDto> createDept(@Valid @RequestBody DepartmentDto departmentDto) {

		return new ResponseEntity<DepartmentDto>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
	}

	@GetMapping("/dept")
	public ResponseEntity<List<DepartmentDto>> getAllDept() {

		return new ResponseEntity<List<DepartmentDto>>(departmentService.getAlldept(), HttpStatus.CREATED);
	}

	@GetMapping("/dept/{id}")
	// @HystrixCommand(fallbackMethod = "getByDeparmentIdReturn")
	public ResponseEntity<DepartmentDto> getByDeparmentId(@PathVariable("id") Long id) {

		return new ResponseEntity<DepartmentDto>(departmentService.getByDepartmentId(id), HttpStatus.CREATED);
	}

	@GetMapping("/dept/msg")
	public String responce() {
		return "dept server";
	}

//	public ResponseEntity<DepartmentDto> getByDeparmentIdReturn(@PathVariable("id") Long id) {
//		DepartmentDto departmentDto = new DepartmentDto();
//		departmentDto.setDeptNo(id);
//
//		return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
//	}

}
