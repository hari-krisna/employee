package com.ssd.employee.excptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String msg;
}
