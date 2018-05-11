package com.mgs;
import com.mgs.persistence.AnyTypeDataWriter;
import com.mgs.persistence.DatabaseWriterBehavior;
import com.mgs.persistence.FileWriterBehavior;
import com.mgs.persistence.VehicleDataWriter;
import com.mgs.persistence.WriterPayload;
import com.mgs.vehicle.*;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Driver {
	private static Scanner input;
	
	private static String VIN = "235423523asdfasda235235";
	//MAKE
	private static String MAKE = "Ford";
	//MODEL
	private static String MODEL = "Mustang GT";
	//YEAR
	private static int YEAR = 2019;
	//COLOR
	private static String COLOR = "Blue";
	//Mileage
	private static double MILEAGE = 25.0;
	private static double DELTA = 0.00001;
	
	private static boolean ISCONVERTIBLE = true;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		Vehicle v1 = new Car();
		v1.setVin("1");
		Vehicle v2 = new Truck(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE);
		v2.setVin("2");
		Car c1 = new Car();
		c1.setVin("3");
		Car c2 = new Car(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE, ISCONVERTIBLE);
		c2.setVin("4");
		
		Truck t1 = new Truck();
		t1.setVin("5");
		Truck t2 = new Truck(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE);
		t2.setVin("6");
		
		Autolot aLot = new Autolot();
		aLot.addOrRemoveVehicle(v1);
		aLot.addOrRemoveVehicle(v2);
		aLot.addOrRemoveVehicle(c1);
		aLot.addOrRemoveVehicle(c2);
		aLot.addOrRemoveVehicle(t1);
		aLot.addOrRemoveVehicle(t2);
		
		Vehicle[] vehicles = aLot.getCurrentInventory();
		
		boolean continueLoop = true;
		VehicleDataWriter vdw;
		
		while (continueLoop)
		{
			///
			int choice = PrintMenu();
			
			switch(choice)
			{
				case 1:
					vdw = new AnyTypeDataWriter();
					break;
				case 2:
					vdw = new AnyTypeDataWriter(new FileWriterBehavior("C:\\Data\\Vehicles.txt"));
					break;
				case 3:
					vdw = new AnyTypeDataWriter(new DatabaseWriterBehavior());
					break;
				default:
					vdw = new AnyTypeDataWriter();
					break;
			}
			
			WriterPayload wp = vdw.Save(vehicles);
			System.out.println(wp.Success());
			System.out.println(wp.Message());
			
			System.out.println("Continue (Y/N)?");
			continueLoop = input.nextLine().toLowerCase().startsWith("y");
		}
		
		for (int i = 0; i < aLot.numberOfVehiclesForSale(); i++)
		{
			Vehicle v = vehicles[i];
			v.start();
			String s = v.DriveVehicle();
			System.out.println(s);
		}
		
		System.out.println("Completed");
	}

	private static void PrintStars(int num)
	{
		IntStream.range(0, num -1).forEach(i -> System.out.print("*"));
		System.out.println();
	}
	
	private static int PrintMenu() 
	{
		PrintStars(80);
		System.out.println("Please enter a choice as follows:");
		System.out.println("1) Output to Terminal");
		System.out.println("2) Save to File");
		System.out.println("3) Save to Database");
		PrintStars(80);
		int retVal = input.nextInt();
		input.nextLine();
		return retVal;
	}
}
