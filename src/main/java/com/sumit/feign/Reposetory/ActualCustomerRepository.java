package com.sumit.feign.Reposetory;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sumit.feign.model.ActualCustomer;

public interface ActualCustomerRepository extends JpaRepository<ActualCustomer, Serializable >{
	
	ActualCustomer findByEmail(String email);
		
}
