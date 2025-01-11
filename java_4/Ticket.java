
//Arda Can Ergin 150123060
import java.util.Date;

public class Ticket {

	private Vehicle vehicle;
	private java.util.Date entryDate;
	private java.util.Date exitDate;
	private double totalPrice;
	public static int numberOfTickets;

	// no-arg constructor for ticket object so that we can use it as a argument for
	// exit vehicle method afterwards
	public Ticket() {

	}

	public Ticket(Vehicle vehicle, Date entryDate) {

		this.vehicle = vehicle;
		this.entryDate = entryDate;
		this.numberOfTickets++;
	}

	// calculating price using a extra method called parkTime
	public double calculatePrice(double hourlyPrice, Date exitDate) {

		double parkingCost = vehicle.getSize() * hourlyPrice * parkTime();

		this.totalPrice = (int) (parkingCost * 100) / 100.0;

		return totalPrice;

	}

	// a method that will return the time in hours, that one vehicle spend in the
	// car park
	private int parkTime() {

		int leap = (int) Math.ceil((exitDate.getTime() - entryDate.getTime()) / 3600000);

		return leap;
	}

	// getTicketInfo method returns the info of a particular ticket as a single
	// combined string
	public String getTicketInfo() {
		String TicketInfo;
		TicketInfo = "Ticket Info" + "\nPlate Number: " + getVehicle().getPlateNumber() + "\nEntry: "
				+ entryDate.toString();

		if (exitDate.getTime() == 0) {
			return TicketInfo;
		} else {
			TicketInfo = TicketInfo + "\nExit: " + exitDate.toString() + "\nHour: " + parkTime() + "\nFee: "
					+ totalPrice + " TLs";
			return TicketInfo;
		}

	}

	// getter method of price for a single vehicle
	public double getPrice() {

		return totalPrice;
	}

	// getter method for vehicle itself
	public Vehicle getVehicle() {

		return vehicle;
	}

	// getter method for exit date
	public Date getExitDate() {

		return exitDate;
	}

	// setter method for exit date so that we can initialize particular exit dates
	// that we want
	public void setExitDate(Date exitDate) {

		this.exitDate = exitDate;
	}
}
