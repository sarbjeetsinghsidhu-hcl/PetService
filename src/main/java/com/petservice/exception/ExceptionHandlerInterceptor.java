package com.petservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerInterceptor extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerInterceptor.class);
	
	@ExceptionHandler(PetNotFound.class)
	public ResponseEntity<ErrorResponse> handleFavouriteNotFound(PetNotFound exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}	

	@ExceptionHandler(RecordExistException.class)
	public ResponseEntity<ErrorResponse> handleFavouriteNotFound(RecordExistException exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleFavouriteNotFound(Exception exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
		LOGGER.error("",exception);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
