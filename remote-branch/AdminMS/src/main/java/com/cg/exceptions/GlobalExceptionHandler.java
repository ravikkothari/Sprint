package com.cg.exceptions;
/**
-File Name          : AdminGlobalExceptionHandler
-Author Name        : Capgemini
-Description        : Class for handling Global Exception
-Creation Date		: 15/04/2021
*/
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	/*******************************************************************************
	 - Method Name      : handleCustomerNotFoundException
	 - Input Parameters : CustomerCareNotFoundException e, HttpServletRequest request
	 - Return type      : ErrorInfo
	 - Author           : Capgemini
	 - Creation Date    : 15/04/2021
	 - Description      : handling CustomerCareNotFoundException
	  ******************************************************************************/ 
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}