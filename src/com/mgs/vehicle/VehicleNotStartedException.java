package com.mgs.vehicle;

public class VehicleNotStartedException extends RuntimeException
{
	public VehicleNotStartedException()
	{
		super("Vehicle Not Started Exception");
	}
	
	public VehicleNotStartedException(String message)
	{
		super(message);
	}
}
