package com.sumit.feign.Reposetory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


import com.sumit.feign.model.OtpGenertion;


@Component
public interface OtpRepository extends JpaRepository<OtpGenertion, Serializable> {

	
	OtpGenertion findByotp(String otp);

//	Optional<OtpGenertion> findByotp(String sts);

	List<OtpGenertion> findByemail(String mail,Sort s);


}
