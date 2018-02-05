import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AutolotTest {
	private Autolot alot;
	private static String VIN = "1234567890ABCDEFG";
	
	@Before
	public void setUp() throws Exception {
		alot = new Autolot();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		assertNotNull("Autolot not instantiated", alot);
		assertEquals("Number of vehicles for sale not as expected", 0, alot.numberOfVehiclesForSale());
		assertEquals("Max size of inventory not as expected", Dealership.MAX_VEHICLES, alot.getCurrentInventory().length);
	}
	
	@Test
	public void testAddOrRemoveAddVehicle() {
		Vehicle v = new Car();
		v.setVin(VIN);
		
		assertTrue("Could not add auto as expected", alot.addOrRemoveVehicle(v));
		assertEquals("Number of vehicles for sale not as expected", 1, alot.numberOfVehiclesForSale());
	}
	
	@Test
	public void testAdd()
	{
		Vehicle v = new Car();
		v.setVin(VIN);
		assertTrue("Could not add auto as expected", alot.addOrRemoveVehicle(v));
		
		Vehicle[] vehicles = alot.getCurrentInventory();
		for (int i = 0; i < alot.numberOfVehiclesForSale(); i++)
		{
			assertTrue("Vehicle inventory did not add the correct vehicle", vehicles[i].getVin().equalsIgnoreCase(v.getVin()));
		}
	}
	
	@Test
	public void testAddExisting()
	{
		Vehicle v = new Car();
		v.setVin(VIN);
		assertTrue("Could not add auto as expected", alot.addVehicle(v));
		assertFalse("Should not add auto that exists", alot.addVehicle(v));
		assertEquals("Number of vehicles for sale not as expected", 1, alot.numberOfVehiclesForSale());
	}
	
	@Test
	public void testAddExistingPastLength()
	{
		Vehicle v = new Car();
		for (int i = 0; i < Dealership.MAX_VEHICLES; i++)
		{
			v = new Car();
			v.setVin(String.format("VIN:%d", i));
			assertTrue("Could not add auto as expected", alot.addVehicle(v));
		}
		v = new Car();
		v.setVin(VIN);
		assertFalse("Should not add auto past max size", alot.addVehicle(v));
		assertEquals("Number of vehicles for sale not as expected", Dealership.MAX_VEHICLES, alot.numberOfVehiclesForSale());
	}
	
	@Test
	public void testRemove()
	{
		Vehicle v = new Car();
		v.setVin(VIN);
		assertTrue("Could not add auto as expected", alot.addOrRemoveVehicle(v));
		assertEquals("Number of vehicles for sale not as expected", 1, alot.numberOfVehiclesForSale());
		
		assertTrue("Could not remove vehicle as expected", alot.addOrRemoveVehicle(v));
		assertEquals("Number of vehicles for sale not as expected", 0, alot.numberOfVehiclesForSale());
	}

	@Test
	public void testRemoveMultiples()
	{
		Vehicle v = new Car();
		v.setVin("asdfasdfasdsadf");
		assertTrue("Could not add auto as expected", alot.addOrRemoveVehicle(v));
		assertEquals("Number of vehicles for sale not as expected", 1, alot.numberOfVehiclesForSale());
		
		Vehicle v2 = new Car();
		v2.setVin(VIN);
		assertTrue("Could not add auto as expected", alot.addOrRemoveVehicle(v2));
		assertEquals("Number of vehicles for sale not as expected", 2, alot.numberOfVehiclesForSale());
		
		Vehicle v3 = new Car();
		v3.setVin("qwerqwerqwer");
		assertTrue("Could not add auto as expected", alot.addOrRemoveVehicle(v3));
		assertEquals("Number of vehicles for sale not as expected", 3, alot.numberOfVehiclesForSale());
		
		assertTrue("Could not remove vehicle as expected", alot.removeVehicle(v2));
		assertEquals("Number of vehicles for sale not as expected", 2, alot.numberOfVehiclesForSale());
		
		Vehicle[] vehicles = alot.getCurrentInventory();
		for (int i = 0; i < alot.numberOfVehiclesForSale(); i++)
		{
			assertFalse("Vehicle inventory did not remove the correct vehicle", vehicles[i].getVin().equalsIgnoreCase(v2.getVin()));
		}
	}
	
	@Test
	public void testRemoveNonExisting()
	{
		Vehicle v = new Car();
		v.setVin("asdfasdfasdsadf");
		assertTrue("Could not add auto as expected", alot.addOrRemoveVehicle(v));
		assertEquals("Number of vehicles for sale not as expected", 1, alot.numberOfVehiclesForSale());
		
		Vehicle v2 = new Car();
		v2.setVin(VIN);
		assertFalse("Should not remove if vehicle didn't exist", alot.removeVehicle(v2));
		
	}

}
