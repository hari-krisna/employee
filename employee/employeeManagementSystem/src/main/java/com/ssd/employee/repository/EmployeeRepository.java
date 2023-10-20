package com.ssd.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssd.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	Optional<Employee> findByEmpno(Long empno);
	
	
	
	
}
