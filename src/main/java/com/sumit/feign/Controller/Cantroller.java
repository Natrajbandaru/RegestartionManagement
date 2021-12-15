package com.sumit.feign.Controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.feign.Reposetory.DeviceRepository;
import com.sumit.feign.Reposetory.ActualCustomerRepository;
import com.sumit.feign.Reposetory.OtpRepository;
import com.sumit.feign.Service.RegestInterface;
import com.sumit.feign.Service.RegestrationService;
import com.sumit.feign.Service.Service;

import com.sumit.feign.dto.Customerdto;
import com.sumit.feign.dto.Regestrationmail;
import com.sumit.feign.dto.messagedto;
import com.sumit.feign.model.ActualCustomer;
import com.sumit.feign.model.Devicedetails;
import com.sumit.feign.model.OtpGenertion;

import org.springframework.data.domain.Sort;
import com.sumit.feign.Reposetory.WalletRepository;
import org.springframework.data.domain.Sort.Direction;


import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;


@RestController
@RequestMapping("/reg")
public class Cantroller {
	
	Logger logger=LoggerFactory.getLogger(Cantroller.class);


	@Autowired
	RegestInterface Regesterservice;
	
	
	@Autowired
	WalletRepository walletRepository;
	
	messagedto mesg=new messagedto();
	JSONObject jsonobject=new JSONObject();
	
	
	

	@PostMapping("/signup") 
	public String add(@RequestBody Regestrationmail username) {
	String Regestrationservice=Regesterservice.signupservice(username);
	logger.debug("FID=add  TEXT=BEGAIN_SIGNUPCANTROLLER");
       return Regestrationservice.toString();
	}
	
	
	
	
	@PostMapping("/Otp")
	public String otpvaledate(@RequestBody Customerdto cast) {
		String otpservice=	Regesterservice.otpser(cast);
		logger.debug("FID=OTPVALEDATE  TEXT=BEGAIN_OTPCANTROLLER");
		return otpservice.toString(); 	
	}
}
