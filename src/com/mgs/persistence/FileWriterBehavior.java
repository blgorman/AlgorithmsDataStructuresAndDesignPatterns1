package com.mgs.persistence;

import com.mgs.vehicle.Vehicle;

public class FileWriterBehavior implements DataWriterBehavior {
	private String filePath;
	
	public FileWriterBehavior(String fileSavePath) {
		//TODO : Implement guard clauses.
		filePath = fileSavePath;
	}
	
	@Override
	public WriterPayload Save(Vehicle[] vehicles) {
		//TODO: Write to file, open save, etc
		
		//TODO: Handle any errors, report false and message
		
		return new WriterPayload(true, String.format("Successfully wrote vehicles to file: %s", filePath));
	}

}
