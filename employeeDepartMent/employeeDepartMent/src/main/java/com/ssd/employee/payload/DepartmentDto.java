package com.ssd.employee.payload;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

	private Long id;
	@NotNull(message = "deptNo is required")
	private Long deptNo;
	@NotNull(message = "dName is required")
	private String dName;
	@NotNull(message = "location is required")
	private String location;
}
