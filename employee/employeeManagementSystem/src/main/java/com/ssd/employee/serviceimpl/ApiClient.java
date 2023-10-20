package com.ssd.employee.serviceimpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ssd.employee.payload.DepartmentDto;

//@FeignClient(url = "http://localhost:8080"  , name = "department-service")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

	@GetMapping("/api/dept/dept/{id}")
	DepartmentDto getByDeparmentId(@PathVariable("id") Long id);

}
