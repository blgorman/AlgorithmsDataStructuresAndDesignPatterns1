package com.mgs.persistence;

public class WriterPayload {
	private boolean isSuccessful;
	private String message;
	
	public WriterPayload(boolean isSuccess, String reportMessage)
	{
		isSuccessful = isSuccess;
		message = reportMessage;
	}
	
	public boolean Success()
	{
		return isSuccessful;
	}
	
	public String Message() 
	{
		return message;
	}
}
