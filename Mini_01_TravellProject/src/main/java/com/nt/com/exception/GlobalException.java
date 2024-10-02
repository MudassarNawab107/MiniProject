package com.nt.com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	// Handle specific exceptions
	@ExceptionHandler(ErrorException.class)
	public ResponseEntity<String> handleIErrorException(ErrorException ex) {
		 return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		 
	}
	
	@ExceptionHandler(UnknownPlanError.class)
	public ResponseEntity<String> handleIUnknownPlanError(UnknownPlanError ex) {
		 return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		 
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
		 return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		 
	}

}
