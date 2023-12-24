package com.accenture.consumer.exception;

public class UserBussinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String messsage;
	
	public UserBussinessException(String msg) {
		super(msg);
		this.messsage = msg;
	}
	
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
}
