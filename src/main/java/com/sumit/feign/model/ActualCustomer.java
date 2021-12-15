package com.sumit.feign.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ActualCustomer {
		
	@Id 
	
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String customerId;
	
	private String firstname;
	private String lastname;
	private String email;
	private String mobileno;
	private String age;
	private String gender;
	private String password;
	private int otpverify;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getOtpverify() {
		return otpverify;
	}
	public void setOtpverify(int otpverify) {
		this.otpverify = otpverify;
	}
	public ActualCustomer( String customerId, String firstname, String lastname, String email, String mobileno,
			String age, String gender, String password, int otpverify) {
		super();
		
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobileno = mobileno;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.otpverify = otpverify;
	}
	public ActualCustomer() {
		super();

	}
	@Override
	public String toString() {
		return "ActualCustomer [id="  + ", customerId=" + customerId + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", mobileno=" + mobileno + ", age=" + age + ", gender=" + gender
				+ ", password=" + password + ", otpverify=" + otpverify + "]";
	}
	
}
