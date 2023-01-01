package com.vmcms.exception;

public class CitizenAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 9059362220668692655L;
	private String message;

	public CitizenAlreadyExistsException() {
	}

	public CitizenAlreadyExistsException(String msg) {
		super(msg);
		this.message = msg;
	}
}