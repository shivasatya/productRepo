package com.dailycodebuffer.productService.exception;

import lombok.Data;

@Data
public class ProductServiceExceptionHandler extends RuntimeException {

	private String errorCode;

public ProductServiceExceptionHandler(String message,String ErroCode) {
	super(message);
	this.errorCode = ErroCode;
}

}
