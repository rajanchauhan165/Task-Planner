package com.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class AllExceptionsHandler {

	@ExceptionHandler(SprintException.class)
	public ResponseEntity<ErrorDetails> sprintExceptionHandler(SprintException sprintException, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(sprintException.getMessage());
		errorDetails.setDescription(webRequest.getDescription(false));
		errorDetails.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskException.class)
	public ResponseEntity<ErrorDetails> taskExceptionHandler(TaskException taskException, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(taskException.getMessage());
		errorDetails.setDescription(webRequest.getDescription(false));
		errorDetails.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception exception, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(exception.getMessage());
		errorDetails.setDescription(webRequest.getDescription(false));
		errorDetails.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
		errorDetails.setDescription(webRequest.getDescription(false));
		errorDetails.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException noHandlerFoundException, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(noHandlerFoundException.getMessage());
		errorDetails.setDescription(webRequest.getDescription(false));
		errorDetails.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
}
