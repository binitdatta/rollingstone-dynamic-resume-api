package com.rollingstone.exceptions;

import java.util.Date;

public class RestAPIExceptionInfo {

	private Date timestamp;
	
	private final String message;
	private final String details;
	
	public RestAPIExceptionInfo() {
		message= null;
		details=null;
		timestamp = null;
	}
	
	public RestAPIExceptionInfo(Date timestamp, String details, String message) {
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
