package com.mgs.vehicle;

public class Truck extends Vehicle
{
	public Truck() {
		
	}
	
	public Truck(String startVin, String startMake, String startModel, int startYear, String startColor, double startMileage)
	{
		super(startVin, startMake, startModel, startYear, startColor, startMileage);
	}

	@Override
	public double getFuelEconomy(double numberOfMiles, double numberOfGallons) {
		double bonus = -5.0 * numberOfGallons;
		numberOfMiles += bonus;
		return numberOfMiles/numberOfGallons;
	}
}
