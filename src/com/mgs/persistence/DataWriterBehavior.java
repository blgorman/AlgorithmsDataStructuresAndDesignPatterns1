package com.mgs.persistence;
import com.mgs.vehicle.Vehicle;

public interface DataWriterBehavior {
	WriterPayload Save(Vehicle[] vehicles);
}
