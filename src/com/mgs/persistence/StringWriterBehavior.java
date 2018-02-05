package com.mgs.persistence;

import com.mgs.vehicle.Vehicle;

public class StringWriterBehavior implements DataWriterBehavior {

	@Override
	public WriterPayload Save(Vehicle[] vehicles) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vehicles.length; i++)
		{
			if (vehicles[i] != null)
			{
				sb.append(vehicles[i]);
			}
		}
		return new WriterPayload(true, sb.toString());
	}

}
