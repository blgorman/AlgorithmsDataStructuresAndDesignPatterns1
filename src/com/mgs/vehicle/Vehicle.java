package com.mgs.vehicle;

import java.util.Calendar;

/**
 * A Vehicle.
 * @author Brian
 *
 */
public abstract class Vehicle implements Licensable, Paintable
{
	private final int MAX_VEHICLE_YEAR = Calendar.getInstance().get(Calendar.YEAR) + 1;
	private final int MIN_VEHICLE_YEAR = 1900;
	
	//VIN
	private String vin;
	//MAKE
	private String make;
	//MODEL
	private String model;
	//YEAR
	private int year;
	//COLOR
	private String color;
	//Mileage
	private double mileage;
	
	private boolean isRunning;
	
	private double speed;

	private double bearing;
	
	
	public Vehicle() {
		//do nothing
	}
	
	public Vehicle(String startVin, String startMake, String startModel, int startYear, String startColor, double startMileage)
	{
		setVin(startVin);
		setMake(startMake);
		setModel(startModel);
		setYear(startYear);
		setColor(startColor);
		setMileage(startMileage);
		speed = 0.0;
	}
	
	//
	public String getVin()
	{
		return vin;
	}
	public void setVin(String value)
	{
		if (value == null || value == "")
		{
			throw new IllegalArgumentException("VIN cannot be null");
		}
		vin = value;
	}
	
	//make
	public String getMake()
	{
		return make;
	}
	public void setMake(String value)
	{
		if (value == null || value == "")
		{
			throw new IllegalArgumentException("Make cannot be null");
		}
		make = value;
	}
	
	//model
	public String getModel()
	{
		return model;
	}
	public void setModel(String value)
	{
		if (value == null || value == "")
		{
			throw new IllegalArgumentException("Model cannot be null");
		}
		model = value;
	}
	
	//year
	public int getYear()
	{
		return year;
	}
	public void setYear(int value)
	{
		
		if (value < MIN_VEHICLE_YEAR || value > MAX_VEHICLE_YEAR)
		{
			throw new IllegalArgumentException("Invalid year for vehicle");
		}
		year = value;
	}
	
	//color
	public String getColor()
	{
		return color;
	}
	public void setColor(String value)
	{
		color = value;
	}
	
	//mileage
	public double getMileage()
	{
		return mileage;
	}
	
	public void setMileage(double value)
	{
		if (mileage < 0.0)
		{
			throw new IllegalArgumentException("Invalid mileage for vehicle");
		}
		mileage = value;
	}
	
	
	public void start() 
	{
		isRunning = true;
	}
	
	public void stop()
	{
		isRunning = false;
	}
	
	public boolean isRunning() 
	{
		return isRunning;
	}
	
	public double getSpeed()
	{
		return speed;
	}
	
	public double accellerate()
	{
		speed += .5;
		return this.getSpeed();
	}
	
	public double accellerate(double value)
	{
		speed += value;
		return this.getSpeed();
	}
	
	public void changeDirection(double value)
	{
		bearing = value;
	}
	public double getDirection()
	{
		return bearing;
	}
	
	public String toString() {
		return String.format("VIN: %s\tMake: %s\tModel: %s\tYear: %d\tColor: %s\tMileage: %.1f"
								, this.getVin()
								, this.getMake()
								, this.getModel()
								, this.getYear()
								, this.getColor()
								, this.getMileage());
	}

	@Override
	public String getIdentificationNumber() {
		return getVin();
	}

	@Override
	public void setIdentificationNumber(String value) {
		setVin(value);
	}
	
	public abstract double getFuelEconomy(double numberOfMiles, double numberOfGallons);

	public final String DriveVehicle()
	{
		if (!isRunning)
		{
			throw new VehicleNotStartedException("Must start the vehicle to drive it!");
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%s\n", Start()));
		sb.append(String.format("%s\n", Drive()));
		sb.append(String.format("%s\n", Park()));
		sb.append(String.format("%s\n", Stop()));
		
		return sb.toString();
	}
	
	public abstract String Drive();
	public abstract String Park();
	
	public String Start()
	{
		return "Starting the engine for the vehicle...";
	}
	
	public String Stop()
	{
		return "Stopping the engine for the vehicle...";
	}
	
}
