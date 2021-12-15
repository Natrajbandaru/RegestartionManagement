package com.sumit.feign.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Devicedetails {
	
	@Id	
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String deviceid;
	private String devicename;
	private String deviceversion;
	private String devicetype;
	private String mail;
	private String costemerId;
	
	         
	public String getCostemerId() {
		return costemerId;
	}
	public void setCostemerId(String costemerId) {
		this.costemerId = costemerId;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getDevicename() {
		return devicename;
	}
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	public String getDeviceversion() {
		return deviceversion;
	}
	public void setDeviceversion(String deviceversion) {
		this.deviceversion = deviceversion;
	}
	public String getDevicetype() {
		return devicetype;
	}
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}
	@Override
	public String toString() {
		return "Devicedetails [deviceid=" + deviceid + ", devicename=" + devicename + ", deviceversion=" + deviceversion
				+ ", devicetype=" + devicetype + "]";
	}
	
	
	
	public Devicedetails(String deviceid, String devicename, String deviceversion, String devicetype, String mail,
			String costemerId) {
		super();
		this.deviceid = deviceid;
		this.devicename = devicename;
		this.deviceversion = deviceversion;
		this.devicetype = devicetype;
		this.mail = mail;
		this.costemerId = costemerId;
	}
	public Devicedetails() {
		super();
		
	}	
}


