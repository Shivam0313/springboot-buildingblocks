package com.stacksimplify.restservices.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		CustomErrorDetails customeErrorDetails = new CustomErrorDetails(new Date(),"From MethodArgumentNotValid Exception in GEH",
				ex.getMessage());
		return new ResponseEntity<>(customeErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		CustomErrorDetails customeErrorDetails = new CustomErrorDetails(new Date(),"From MethodArgumentNotValid Exception in GEH-method Not Allowed",
				ex.getMessage());
		return new ResponseEntity<>(customeErrorDetails,HttpStatus.METHOD_NOT_ALLOWED);

	}
	
	@ExceptionHandler(UserNameNotFoundException.class)
	public final  ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex,
			WebRequest request){
		CustomErrorDetails customeErrorDetails = new CustomErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(customeErrorDetails,HttpStatus.NOT_FOUND);
	}
	
	//ConstraintViolationException
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object>handleConstraintViolationException(ConstraintViolationException ex,WebRequest request){
		CustomErrorDetails customeErrorDetails = new CustomErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(customeErrorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
