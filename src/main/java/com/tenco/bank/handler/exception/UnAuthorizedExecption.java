package com.tenco.bank.handler.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UnAuthorizedExecption extends RuntimeException {
	
	private HttpStatus status;
	
	public UnAuthorizedExecption(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
}
