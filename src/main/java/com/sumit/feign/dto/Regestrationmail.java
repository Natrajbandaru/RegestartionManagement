package com.sumit.feign.dto;

public class Regestrationmail {
	
	private String email;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Regestration [email=" + email + "]";
	}

	public Regestrationmail(String email) {
		super();
		this.email = email;
	}
	
	
	public Regestrationmail() {
		super();

	}
	
	
	

}
