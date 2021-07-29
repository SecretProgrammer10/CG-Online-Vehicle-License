/**
 * 
 */
package com.capgemini.onlinevehiclelicense.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends RuntimeException{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6322683489719761135L;

	/**
	 * @param message
	 */
	public AddressNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
