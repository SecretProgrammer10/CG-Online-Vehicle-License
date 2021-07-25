package com.capgemini.onlinevehiclelicense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class RecordAlreadyPresentException extends Exception{
	
	public RecordAlreadyPresentException(String message)
	{
		super(message);
	}
}
