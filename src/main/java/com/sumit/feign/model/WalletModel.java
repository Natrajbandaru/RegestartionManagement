package com.sumit.feign.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class WalletModel {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	public String walletId;
	public String customerId;
	public Double amount;
	public LocalDateTime creatat;
	public LocalDateTime updateat;
	
	public WalletModel() {

	}
	public String getWalletId() {
		return walletId;
	}
	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDateTime getCreatat() {
		return creatat;
	}
	public void setCreatat(LocalDateTime creatat) {
		this.creatat = creatat;
	}
	public LocalDateTime getUpdateat() {
		return updateat;
	}
	public void setUpdateat(LocalDateTime updateat) {
		this.updateat = updateat;
	}
	@Override
	public String toString() {
		return "WalletDto [walletId=" + walletId + ", customerId=" + customerId + ", amount=" + amount + ", creatat="
				+ creatat + ", updateat=" + updateat + "]";
	}
	public WalletModel(String walletId, String customerId, Double amount, LocalDateTime creatat, LocalDateTime updateat) {
		super();
		this.walletId = walletId;
		this.customerId = customerId;
		this.amount = amount;
		this.creatat = creatat;
		this.updateat = updateat;
	}
}
