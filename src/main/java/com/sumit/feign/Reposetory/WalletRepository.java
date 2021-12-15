package com.sumit.feign.Reposetory;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sumit.feign.model.WalletModel;

@Component
public interface WalletRepository  extends JpaRepository<WalletModel, Serializable>{

}
