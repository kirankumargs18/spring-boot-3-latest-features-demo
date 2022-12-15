package com.kiran.gs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * ProblemDetail class introduced in Spring boot 3
	 * */
	@ExceptionHandler(CustomerNotFoundException.class)
	public ProblemDetail handleCustomerNotFoundException(CustomerNotFoundException exception) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400),

				exception.getMessage());

		problemDetail.setTitle("BAD REQUEST");

		return problemDetail;
	}
	
	/**
	 * we can also use ErrorResponse introduced in spring boot 3 like below
	 * */
	@ExceptionHandler(Exception.class)
	public ErrorResponse handleException(Exception exception) {
		
		return ErrorResponse.builder(exception, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage())
				.build();
		
	}

}
