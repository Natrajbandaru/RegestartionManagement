package com.sumit.feign.dto;

import java.time.LocalDateTime;

public class WalletDto {
	
	public String walletId;
	public String customerId;
	public Double amount;
	public LocalDateTime creatat;
	public LocalDateTime updateat;
	
	public WalletDto() {
		super();
		
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
	public WalletDto(String walletId, String customerId, Double amount, LocalDateTime creatat, LocalDateTime updateat) {
		super();
		this.walletId = walletId;
		this.customerId = customerId;
		this.amount = amount;
		this.creatat = creatat;
		this.updateat = updateat;
	}

}
