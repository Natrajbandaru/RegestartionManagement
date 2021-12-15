package com.sumit.feign.Service;

import org.springframework.stereotype.Service;


import com.sumit.feign.dto.Customerdto;
import com.sumit.feign.dto.Regestrationmail;

@Service
public interface RegestInterface {
	
	public String signupservice(Regestrationmail username);
	
	public String otpser(Customerdto cast);
	
}
