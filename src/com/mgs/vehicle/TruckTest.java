package com.mgs.vehicle;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TruckTest extends VehicleTest {
	Truck t1;
	Truck t2;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		t1 = (Truck)getVehicle();
		t2 = (Truck)getVehicle(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Override
	public Vehicle getVehicle() {
		return new Truck();
	}

	@Override
	public Vehicle getVehicle(String vin, String make, String model, int year, String color, double mileage) {
		return new Truck(vin, make, model, year, color, mileage);
	}



}
