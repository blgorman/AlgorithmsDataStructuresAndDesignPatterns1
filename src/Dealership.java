
public interface Dealership 
{
	boolean addOrRemoveVehicle(Vehicle v);
	int numberOfVehiclesForSale();
	Vehicle[] getCurrentInventory();
	public static final int MAX_VEHICLES = 1000;
}
