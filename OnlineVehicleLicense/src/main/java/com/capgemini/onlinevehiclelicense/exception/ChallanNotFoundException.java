package com.capgemini.onlinevehiclelicense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ChallanNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6517000400128328283L;

	public ChallanNotFoundException(String message) {
		super(message);
	}
}
