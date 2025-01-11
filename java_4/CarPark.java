
//Arda Can Ergin 150123060
import java.util.Date;

public class CarPark {

	private int capacity;
	public ParkPlace[] parkPlaceArray = new ParkPlace[0];
	public Ticket[] ticketArray = new Ticket[0];
	private double hourlyPrice;

	public CarPark(int capacity, double hourlyPrice) {

		this.capacity = capacity;
		this.hourlyPrice = hourlyPrice;
	}

	//method will be used to park a vehicle into a particular CarPark object
	public Ticket parkVehicle(Vehicle vehicle, Date entryDate) {

		//if there are no capacity for more vehicle which will actually be determined based on size the warning comes out 
		if (vehicle.getSize()>capacity) {
			System.out.println("Car park is full !!");
			return null;
		}

		ParkPlace parkPlace = new ParkPlace(vehicle);
		capacity -= vehicle.getSize();

		// copying park place array to a temp one to resize actual array
		ParkPlace[] temp = new ParkPlace[Ticket.numberOfTickets];

		for (int i = 0; i < parkPlaceArray.length; i++) {

			temp[i] = parkPlaceArray[i];
		}

		Ticket ticket = new Ticket(vehicle, entryDate);

		System.out.println("The vehicle with " + vehicle.getPlateNumber() + " plate number is parked.");

		// creating a new parkPlaceArray with the more number of places based on ticket
		// count

		parkPlaceArray = new ParkPlace[Ticket.numberOfTickets];

		for (int i = 0; i < temp.length; i++) {

			parkPlaceArray[i] = temp[i];
		}

		parkPlaceArray[Ticket.numberOfTickets-1] = parkPlace;
		
		ticketArray = new Ticket[Ticket.numberOfTickets];

		return ticket;
	}

	//exit vehicle method for move out a vehicle from the park place
	public Vehicle exitVehicle(Ticket ticket, Date exitDate) {
		
		ticket.setExitDate(exitDate);

		for (int i = 0; i < parkPlaceArray.length; i++) {

			if ((ticket.getVehicle()).getPlateNumber() == (parkPlaceArray[i].getVehicle()).getPlateNumber()) {

				parkPlaceArray[i] = null;

				System.out.println("The price for vehicle with " + (ticket.getVehicle()).getPlateNumber() + " is: "
						+ ticket.calculatePrice(hourlyPrice, exitDate));
				

				//ticket array will have the most recent exited car in the first index
				ticketArray[parkPlaceArray.length-1] = ticket;

			}
		}

		// resize park place array
		int blank = 0 ;
		int counter =0;
		for(int i=0;i<parkPlaceArray.length;i++) {
			if(!(parkPlaceArray[i]==null)) {
				counter++;
			} else {
				blank=i;
			}
		}
		
		ParkPlace[] temp = new ParkPlace[counter];
		//copying park place array for temp one to resize acutal one
		for(int i=0;i<parkPlaceArray.length;i++) {
			if(parkPlaceArray[i]==null) {
				continue;
			}
			if(i>blank) {
				
				temp[i-1]=parkPlaceArray[i];
			} else {
				temp[i]=parkPlaceArray[i];
			}
		}
		
		parkPlaceArray = new ParkPlace[counter];
		//copy temp to park place array to use actual one for further computing
		for(int i=0;i<temp.length;i++) {
			parkPlaceArray[i]=temp[i];
		}

		return ticket.getVehicle();
	}

	//method to calculate total income earned trough a single car park
	public double getTotalIncome() {

		double totalIncome = 0;

		for (int i = 0; i < ticketArray.length; i++) {

			totalIncome += ticketArray[i].calculatePrice(hourlyPrice, ticketArray[i].getExitDate());
		}

		return totalIncome;
	}

	// printVehicleMethod shows the current vehicles that has been parked in the car park 
	public void printVehicleList() {

		for (int i = 0; i < parkPlaceArray.length; i++) {

			System.out.print(parkPlaceArray[i].getVehicle().getVehicleInfo());
			System.out.println();
		}

	}

	//method prints the all tickets that has been printed until now 
	public void printTickets() {

		for (int i = 0; i < ticketArray.length; i++) {

			System.out.print(ticketArray[i].getTicketInfo());
			System.out.println();
		}
	}
}
