//Arda Can Ergin 150123060
public class ParkPlace {

	private int size;
	private Vehicle vehicle;

	public ParkPlace(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.size = vehicle.getSize();

	}

	// getter method size of the park place
	public int getSize() {

		return size;
	}

	// getter method for the vehicle which is parked in a particular park place
	public Vehicle getVehicle() {

		return vehicle;
	}
}
