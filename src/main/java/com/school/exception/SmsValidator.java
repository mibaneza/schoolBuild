package com.school.exception;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsValidator {
	@JsonProperty("sms")
	private String sms ;
	
	@JsonProperty("invalid")
	private List<Object> invalid ;

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public List<Object> getInvalid() {
		return invalid;
	}

	public void setInvalid(List<Object> invalid) {
		this.invalid = invalid;
	}

	
}
