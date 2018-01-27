
public class Autolot implements Dealership 
{
	private Vehicle[] vehicles;
	private int currentNumberOfVehicles;
	
	public Autolot() {
		vehicles = new Vehicle[Dealership.MAX_VEHICLES];
		currentNumberOfVehicles = 0;
	}
	
	@Override
	public boolean addOrRemoveVehicle(Vehicle v)
	{
		for (int i = 0; i < currentNumberOfVehicles; i++)
		{
			if (vehicles[i].getVin().equalsIgnoreCase(v.getVin()))
			{
				return removeVehicle(v);
			}
		}
		return addVehicle(v);
	}
	
	public boolean addVehicle(Vehicle v)
	{
		if (currentNumberOfVehicles >= Dealership.MAX_VEHICLES)
		{
			return false;
		}
		
		for (int i = 0; i < currentNumberOfVehicles; i++)
		{
			if (vehicles[i].getVin().equalsIgnoreCase(v.getVin()))
			{
				return false;
			}
		}
		
		vehicles[currentNumberOfVehicles++] = v;
		return vehicles[currentNumberOfVehicles - 1].getVin().equalsIgnoreCase(v.getVin());
	}
	
	public boolean removeVehicle(Vehicle v)
	{
		for (int i = 0; i < currentNumberOfVehicles; i++)
		{
			if (vehicles[i].getVin().equalsIgnoreCase(v.getVin()))
			{
				vehicles[i] = vehicles[currentNumberOfVehicles - 1];
				vehicles[currentNumberOfVehicles - 1] = null;
				currentNumberOfVehicles--;
				return vehicles[i] == null || !vehicles[i].getVin().equalsIgnoreCase(v.getVin());
			}
		}
		return false;
	}

	@Override
	public int numberOfVehiclesForSale() 
	{
		return currentNumberOfVehicles;
	}

	@Override
	public Vehicle[] getCurrentInventory() {
		return vehicles;
	}
}
