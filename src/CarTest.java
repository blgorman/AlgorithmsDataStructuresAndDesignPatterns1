import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CarTest extends VehicleTest {

	//IsConvertible
	private static boolean ISCONVERTIBLE = true;
	private Car c1;
	private Car c2;
	
	@Override
	public Vehicle getVehicle() {
		return new Car();
	}

	@Override
	public Vehicle getVehicle(String vin, String make, String model, int year, String color, double mileage) {
		return new Car(vin, make, model, year, color, mileage, ISCONVERTIBLE);
	}
	
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		c1 = (Car)getVehicle();
		c2 = (Car)getVehicle(VIN, MAKE, MODEL, YEAR, COLOR, MILEAGE);
	}

	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public void testDefaultConstructor() {
		assertNotNull("Could not instantiate Vehicle", c1);
	}
	
	@Test
	public void testExplicitConstructor() {
		super.testExplicitConstructor();
		assertTrue("Is Convertible is not set as expected", c2.getIsConvertible());
	}
	
	@Test
	public void testToString()
	{
		super.testToString();
		String testingString = c2.toString();
		assertTrue("ToString does not contain convertible value", testingString.contains(String.format("Is a Convertible: %b",  c2.getIsConvertible())));
	}

}
