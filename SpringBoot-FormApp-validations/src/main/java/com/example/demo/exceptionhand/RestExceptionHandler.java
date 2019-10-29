package com.example.demo.exceptionhand;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestController
@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ApiError> handleNoUserFoundException() {
		ApiError error=new ApiError(400, "No user Found", new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
	}

	

}
