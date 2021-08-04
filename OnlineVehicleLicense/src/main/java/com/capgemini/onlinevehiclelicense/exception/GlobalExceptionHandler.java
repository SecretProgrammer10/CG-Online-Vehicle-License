/**
 * 
 */
package com.capgemini.onlinevehiclelicense.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(RecordNotFoundException.class)
 public ResponseEntity<?> recordNotFoundException(RecordNotFoundException ex, WebRequest request) {
  ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
 }
 
 @ExceptionHandler(RecordAlreadyPresentException.class)
 public ResponseEntity<?> recordAlreadyPresentException(RecordAlreadyPresentException ex, WebRequest request) {
  ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
  return new ResponseEntity<>(errorDetails, HttpStatus.ALREADY_REPORTED);
 }

 @ExceptionHandler(Exception.class)
 public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
  ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
 }
}
