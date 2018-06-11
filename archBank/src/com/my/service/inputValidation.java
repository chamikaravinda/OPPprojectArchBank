package com.my.service;

import java.util.regex.Pattern;

public class inputValidation {
	
	public Boolean valideTextOnly(String text) {
		
		Boolean check=Pattern.matches("[a-zA-Z]+", text);
		
		return check;
	}
	
	
	public Boolean valideEmail(String text) {
		Boolean check=Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$",text);
		return check;
		
	}
	
	public Boolean valideNumberOnly(String number) {
		Boolean check=Pattern.matches("[0-9]+",number);
		return check;
	}

}
