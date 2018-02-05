package com.mgs.persistence;

import com.mgs.vehicle.Vehicle;

public abstract class VehicleDataWriter implements DataWriterBehavior {
	private DataWriterBehavior dataWriterBehavior;
	
	public VehicleDataWriter() {
		dataWriterBehavior = new StringWriterBehavior();
	}
	
	public VehicleDataWriter(DataWriterBehavior value) {
		dataWriterBehavior = value;
	}
	
	public void setWriterBehavior(DataWriterBehavior value)
	{
		dataWriterBehavior = value;
	}
	
	@Override
	public WriterPayload Save(Vehicle[] vehicles) {
		return dataWriterBehavior.Save(vehicles);
	}

}
