package com.ggpl.Payslip.utility;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ggpl.Payslip.eXception.PayslipEXception;

@RestControllerAdvice
public class ControllerAdviceEXception {

	@Autowired
	Environment environment;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception exception){
		return new ResponseEntity<String>(environment.getProperty("General.Exception.Message"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PayslipEXception.class)
	public ResponseEntity<String> exceptionHandler(PayslipEXception exception){
		return new ResponseEntity<String>(environment.getProperty(exception.getMessage()),HttpStatus.NOT_ACCEPTABLE);
	}
	
}
