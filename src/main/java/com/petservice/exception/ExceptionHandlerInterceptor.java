package com.petservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerInterceptor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(PetNotFound.class)
	public ResponseEntity<ErrorResponse> handleFavouriteNotFound(PetNotFound exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CreationException.class)
	public ResponseEntity<ErrorResponse> handleFavouriteNotFound(CreationException exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RecordExistException.class)
	public ResponseEntity<ErrorResponse> handleFavouriteNotFound(RecordExistException exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleFavouriteNotFound(Exception exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
