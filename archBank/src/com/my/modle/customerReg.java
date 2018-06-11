package com.my.modle;

public class customerReg extends customer {
	
	
	private String SecurityKey;
	private String createPassword;
	private String confirmPassword;
	private String customerID;
	
	public String getCreatePassword() {
		return createPassword;
	}
	public void setCreatePassword(String createPassword) {
		this.createPassword = createPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getSecurityKey() {
		return SecurityKey;
	}
	public void setSecurityKey(String securityKey) {
		SecurityKey = securityKey;
	}
	
	public void setCustomerID(String ID) {
		

		this.customerID=ID;
	}
	
	public String getCustomerID() {
		return this.customerID;
		
	}


	
	

}
