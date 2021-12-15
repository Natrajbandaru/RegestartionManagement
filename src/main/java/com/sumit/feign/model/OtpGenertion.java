package com.sumit.feign.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OtpGenertion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String otp;
	public long expirytime;
	public LocalDateTime created;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}

	public long getExpirytime() {
		return expirytime;
	}
	public void setExpirytime(long expirytime) {
		this.expirytime = expirytime;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Regestration [id=" + id + ", email=" + email + ", otp=" + otp + ", expirytime=" + expirytime
				+ ", created=" + created + "]";
	}
	public OtpGenertion(int id, String email, String otp, long expirytime, LocalDateTime created) {
		super();
		this.id = id;
		this.email = email;
		this.otp = otp;
		this.expirytime = expirytime;
		this.created = created;
	}
	public OtpGenertion() {
		super();

	}
}
