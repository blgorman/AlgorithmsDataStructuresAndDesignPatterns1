package com.mgs.persistence;

import com.mgs.vehicle.Vehicle;

public class DatabaseWriterBehavior implements DataWriterBehavior {

	private String conStr = "";
	private String dbDriver = "";
	private String userName = "";
	private String passWord = "";
	
	private void SetupForSave() {
		conStr = "jdbc:microsoft:sqlserver://HOST:1433;DatabaseName=AutoLot";
		dbDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
		
		/*
		 * 
		 jdbc: mysql://HOST/DATABASE
		 com.mysql.jdbc.Driver
		 */
		
		//open db, setup connection, etc
		
		//TODO return the connection ...
	}

	@Override
	public WriterPayload Save(Vehicle[] vehicles) {
		SetupForSave(); //TODO: get the connection here..
		
		//TODO Save to database
		//TODO handle errors and report false with error message
		
		return new WriterPayload(true, "Vehicles Successfully Saved to the Database!");
	}

}
