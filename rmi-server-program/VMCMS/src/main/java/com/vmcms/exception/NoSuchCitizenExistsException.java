package com.vmcms.exception;

public class NoSuchCitizenExistsException extends RuntimeException {

	private String message;

	public NoSuchCitizenExistsException() {
	}

	public NoSuchCitizenExistsException(String msg) {
		super(msg);
		this.message = msg;
	}
}