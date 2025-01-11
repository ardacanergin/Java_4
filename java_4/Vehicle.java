//Arda Can Ergin 150123060
public class Vehicle {

	private String plateNumber;
	private int size; // 1 : motorcycle 2 :car 4: truck

	public Vehicle(String plateNumber, int size) {
		this.plateNumber = plateNumber;
		this.size = size;

	}

	// getter method for plate number
	public String getPlateNumber() {

		return plateNumber;
	}

	// getter method for size of the vehicle
	public int getSize() {

		return size;
	}

	// method that will return the whole vehicle info as a single string
	public String getVehicleInfo() {

		String info = "Vehicle Info" + "\nPlate number:" + plateNumber + "\nSize: " + size;

		return info;
	}

}
