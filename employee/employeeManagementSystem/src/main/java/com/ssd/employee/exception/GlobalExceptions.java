package com.ssd.employee.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(ClientErrorException.class)
	public ResponseEntity<ErrorFileds> throwException(ClientErrorException errorException, WebRequest request) {

		ErrorFileds errorFileds = new ErrorFileds(new Date(), errorException.getMsg(), request.getDescription(true));

		return new ResponseEntity<ErrorFileds>(errorFileds, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> throwException(BindingResult request) {

		Map<String, String> map = new HashMap<>();

		for (FieldError fe : request.getFieldErrors()) {
			map.put( fe.getField(),fe.getDefaultMessage());

		}

		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);

	}

}
