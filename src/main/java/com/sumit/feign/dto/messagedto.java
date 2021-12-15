package com.sumit.feign.dto;

import org.springframework.stereotype.Component;


public class messagedto {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + "]";
	}

	public messagedto(String message) {
		super();
		this.message = message;
	}

	public messagedto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
