package com.sumit.feign.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.sumit.feign.Reposetory.ActualCustomerRepository;
import com.sumit.feign.Reposetory.DeviceRepository;
import com.sumit.feign.Reposetory.ActualCustomerRepository;
import com.sumit.feign.Reposetory.OtpRepository;
import com.sumit.feign.Reposetory.WalletRepository;
import com.sumit.feign.dto.Customerdto;
import com.sumit.feign.dto.Customerdto;
import com.sumit.feign.dto.Regestrationmail;
import com.sumit.feign.dto.messagedto;
import com.sumit.feign.model.ActualCustomer;
import com.sumit.feign.model.Devicedetails;
import com.sumit.feign.model.OtpGenertion;
import com.sumit.feign.model.WalletModel;


@Component
public class RegestrationService implements RegestInterface {
	
	Logger logger=LoggerFactory.getLogger(RegestrationService.class);

	@Autowired
	Service mailservice;

	@Autowired
	OtpRepository otprepository;

	@Autowired
	ActualCustomerRepository customerrepository;

	@Autowired
	DeviceRepository devicerepository;

	@Autowired
	WalletRepository walletRepository;


	//	message mesg=new message();

	JSONObject jsonobject = new JSONObject();
	String messages="";
	String status="";

	@Override
	public String signupservice(Regestrationmail RegestrationmailDTO) {
		
		status="0";
		logger.debug("FID=signupservice ERCD={} TEXT=BEGAIN_SIGNUPSERVICE",status);
		
		

		try {

			String email = RegestrationmailDTO.getEmail();
			ActualCustomer actualCustomer = customerrepository.findByEmail(email);
			// System.out.println("actualCustomer"+actualCustomer.toString());
			if (actualCustomer != null) {

				// ser.mail(m);
				// mesg.setMessage("Mail Id is Already Exestance");
				status="1004";
				messages="Entered Email Id is Already Exested";
				
				logger.debug("FID=signupservice ERCD={} TEXT=CUSTOMERDATA_IS_PRESENT  ",status);
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);

				return jsonobject.toString();
			} else {
			
				mailservice.mail(email);
				
				status="1005";
				messages="OTP is Sended";
				logger.debug("FID=signupservice ERCD={} TEXT=GENTERATED_OTP EMAIL_ID={}  ",status);
				
		        jsonobject.put("message", messages);
				jsonobject.put("status", status);

				return jsonobject.toString();

			}

		} catch (Exception e) {
			status="1007";
			messages="Entered MailId is Already Exested";
			
			logger.debug("FID=signupservice ERCD={} TEXT=CUSTOMERDATA_IS_PRESENT ",status);
			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);
			return jsonobject.toString();
		}

	}

	@Override
	public String otpser(Customerdto cast) {
		
		status="0";
		logger.debug("FID=otpservice ERCD={} TEXT=BEGAIN_SIGNUPSERVICE",status);

		try {

			String firstname = cast.getFirstname();
			String lastname = cast.getLastname();
			String email = cast.getEmail();
			String mobileno = cast.getMobileno();
			String age = cast.getAge();
			String gender = cast.getGender();
			String password = cast.getPassword();

			String devicename = cast.getDevicename();
			String deviceversion = cast.getDeviceversion();
			String devicetype = cast.getDevicetype();

			String otp = cast.getOtp();
			String maill = cast.getEmail();

			List<OtpGenertion> mail = otprepository.findByemail(maill, Sort.by(Direction.DESC, "created"));

			OtpGenertion otpGeneration = mail.get(0);
			System.out.println(otpGeneration);

			String mail1 = otpGeneration.getEmail();
			String otp1 = otpGeneration.getOtp();

			if (!mail.isEmpty()) {

				if (otp.equals(otp1)) {

					ActualCustomer coustomermodel = new ActualCustomer();

					coustomermodel.setFirstname(firstname);
					coustomermodel.setLastname(lastname);
					coustomermodel.setEmail(email);
					coustomermodel.setMobileno(mobileno);
					coustomermodel.setAge(age);
					coustomermodel.setGender(gender);
					coustomermodel.setPassword(password);
					coustomermodel.setOtpverify(1);

					customerrepository.save(coustomermodel);

					ActualCustomer actualCustomer = customerrepository.findByEmail(email);

					String customerId = actualCustomer.getCustomerId();
					System.out.println(customerId);

					Devicedetails details = new Devicedetails();

					details.setDevicename(devicename);
					details.setDevicetype(devicetype);
					details.setDeviceversion(deviceversion);
					details.setCostemerId(customerId);
					details.setMail(email);

					devicerepository.save(details);


					WalletModel walletmodel =new WalletModel();
					walletmodel.setCustomerId(customerId);

					LocalDateTime createdtime=LocalDateTime.now();
					walletmodel.setCreatat(createdtime);
					walletmodel.setAmount(0.00);

					walletRepository.save(walletmodel);
					status="1005";
					logger.debug("FID=otpservice ERCD={} TEXT=OTP_ENTERED_IS_VALIED EMAIL={}  ",status);

					
					messages="Otp is Correct!! Data Added";
					
			        jsonobject.put("message", messages);
					jsonobject.put("status", status);


				}

				else {
					status="1009";
					messages="Entered Otp is Not Correct";
					
					logger.debug("FID=otpservice ERCD={} TEXT=OTP_ENTERED_IS_INVALIED EMAIL={}  ",status);

					
			        jsonobject.put("message", messages);
					jsonobject.put("status", status);				}

			}
			return jsonobject.toString();

		}
		catch(Exception e) {
			status="1009";
			messages="Entered Otp is Not Correct!! Enter Valied Otp";
			
			logger.debug("FID=otpservice ERCD={} TEXT=OTP_ENTERED_IS_INVALIED  ",status);

			
	        jsonobject.put("message", messages);
			jsonobject.put("status", status);	
		}

		return jsonobject.toString();

	
	}

}
