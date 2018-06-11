package com.my.modle;

public class TraditionalAccount {

	private long AccountNo;
	private double CurrentBalance;
	private String securityKey;
	
	
	public long getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(long accountNo) {
		AccountNo = accountNo;
	}
	public double getCurrentBalance() {
		return CurrentBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		CurrentBalance = currentBalance;
	}
	public String getSecurityKey() {
		return securityKey;
	}
	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}
	
	
}
