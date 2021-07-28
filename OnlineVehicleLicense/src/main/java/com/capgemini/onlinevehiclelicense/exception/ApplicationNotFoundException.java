package com.capgemini.onlinevehiclelicense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class ApplicationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5784740619965247248L;

	public ApplicationNotFoundException(String message) {
		super(message);
	}
	
}
