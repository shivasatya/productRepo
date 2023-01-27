package com.dailycodebuffer.productService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dailycodebuffer.productService.controller.ProductController;
import com.dailycodebuffer.productService.model.ErrorResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ProductServiceExceptionHandler.class)
	public ResponseEntity<ErrorResponse> handelProductCustomException(ProductServiceExceptionHandler exception) {
		return new ResponseEntity<>(ErrorResponse.builder()
				.errorMessage(exception.getMessage())
				.errorCode(exception.getErrorCode())
				.build(),HttpStatus.NOT_FOUND);
		
	}

}
