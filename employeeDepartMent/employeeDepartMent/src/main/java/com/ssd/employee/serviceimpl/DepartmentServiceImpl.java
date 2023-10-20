package com.ssd.employee.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.employee.entity.Department;
import com.ssd.employee.excptions.ClientErrorException;
import com.ssd.employee.payload.DepartmentDto;
import com.ssd.employee.repository.DepartmentRepository;
import com.ssd.employee.serviceinterface.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {

		if (departmentRepository.findByDeptNo(departmentDto.getDeptNo()).isPresent()) {

			throw new ClientErrorException(
					"department number already in database please change : " + departmentDto.getDeptNo());

		}

		Department dept = toEntity(departmentDto);

		dept = departmentRepository.save(dept);

		return todto(dept);
	}

	@Override
	public List<DepartmentDto> getAlldept() {

		List<Department> findAll = departmentRepository.findAll();

		List<DepartmentDto> collect = findAll.stream().map(kk -> mapper.map(kk, DepartmentDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	public DepartmentDto todto(Department department) {

		return mapper.map(department, DepartmentDto.class);
	}

	public Department toEntity(DepartmentDto departmentDto) {

		return mapper.map(departmentDto, Department.class);
	}

	@Override
	public DepartmentDto getByDepartmentId(Long id) {

		Department findByDeptNo = departmentRepository.findByDeptNo(id).get();

		DepartmentDto todto = todto(findByDeptNo);
		return todto;
	}

}
