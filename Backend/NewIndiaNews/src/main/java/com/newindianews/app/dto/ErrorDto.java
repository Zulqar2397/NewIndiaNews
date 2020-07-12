package com.newindianews.app.dto;

public class ErrorDto {

	private String message;
	private Throwable cause;
	
	public ErrorDto() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDto(String message, Throwable cause) {
		super();
		this.message = message;
		this.cause = cause;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	
}
