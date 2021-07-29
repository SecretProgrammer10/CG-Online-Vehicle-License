package com.capgemini.onlinevehiclelicense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class RecordAlreadyPresentException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4468937661518085725L;

	public RecordAlreadyPresentException(String message)
	{
		super(message);
	}
}
