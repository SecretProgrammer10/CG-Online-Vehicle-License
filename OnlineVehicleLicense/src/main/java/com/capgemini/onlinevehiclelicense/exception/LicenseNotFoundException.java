package com.capgemini.onlinevehiclelicense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LicenseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7352390464858010948L;

	public LicenseNotFoundException(String msg) {
		super(msg);
	}
}
