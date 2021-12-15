package com.sumit.feign.Reposetory;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sumit.feign.model.Devicedetails;

public interface DeviceRepository extends JpaRepository<Devicedetails, Serializable>{

	

	
}
