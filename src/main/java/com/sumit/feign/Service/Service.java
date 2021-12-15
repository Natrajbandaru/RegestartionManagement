package com.sumit.feign.Service;

import java.time.LocalDateTime;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sumit.feign.Reposetory.OtpRepository;
import com.sumit.feign.model.OtpGenertion;

@Component
public class Service {
	
	@Autowired
	OtpRepository repo;
	
	
	public void mail(String mailid) {
		OtpGenertion otpSystem=new OtpGenertion();
		
		String to = mailid; // to address. It can be any like gmail, yahoo etc.
	    final String from = "Natrajbandaru12@gmail.com"; // from address. As this is using Gmail SMTP your from address should be gmail
	    final String password = "Natraj@1999"; // password for from gmail address that you have used in above line. 
         
	    Properties prop = new Properties();
	    prop.put("mail.smtp.host", "smtp.gmail.com");
	    prop.put("mail.smtp.port", "465");
	    prop.put("mail.smtp.auth", "true");
	    prop.put("mail.smtp.socketFactory.port", "465");
	    prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	    Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(from, password);
	        }
	    });
	    
	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	        message.setSubject("Otp Mail from Application");
	        
	        otpSystem.setOtp(String.valueOf(((int)(Math.random()*(10000-1000)))+1000));
	        
	       
	      //  otpSystem.setExpirytime(System.currentTimeMillis()+200000);
	    
	        otpSystem.setExpirytime(System.currentTimeMillis()+200000);
	        otpSystem.setEmail(mailid);
	        
	        LocalDateTime s=LocalDateTime.now();
	        otpSystem.setCreated(s);
	  
	        String otp=otpSystem.getOtp();
	        System.out.println(otp);
	        
	        message.setText("The Otp is:  "+otp);
                                         
	        Transport.send(message);
	        repo.save(otpSystem);
      
	        System.out.println("Mail  Sent...");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	
	}

}
