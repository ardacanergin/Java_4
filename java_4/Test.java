
// Arda Can Ergin 150123060
import java.util.Date;

public class Test {

	public static void main(String[] args) {

		// creating a CarPark object
		CarPark carpark = new CarPark(10, 5);

		// vehicle objects
		Vehicle vehicle1 = new Vehicle("111Cse111", 4);
		Vehicle vehicle2 = new Vehicle("222Cse222", 2);
		Vehicle vehicle3 = new Vehicle("333Cse333", 1);
		Vehicle vehicle4 = new Vehicle("444Cse444", 2);
		Vehicle vehicle5 = new Vehicle("555Cse555", 4);

		// date objects
		Date date1 = new Date();
		Date date2 = newDate(date1, 1);
		Date date3 = newDate(date2, 1);
		Date date4 = newDate(date3, 1);

		// exit date objects
		Date exitDate1 = newDate(date1, 5);
		Date exitDate2 = newDate(date2, 5);
		Date exitDate3 = newDate(date3, 5);
		Date exitDate4 = newDate(date4, 5);

		// to store the every ticket object that will be returned by parked vehicle so
		// that we can use them for exit vehicle method
		Ticket ticket1 = new Ticket();
		Ticket ticket2 = new Ticket();
		Ticket ticket3 = new Ticket();
		Ticket ticket4 = new Ticket();
		Ticket ticket5 = new Ticket();

		ticket1 = carpark.parkVehicle(vehicle1, date1);
		ticket2 = carpark.parkVehicle(vehicle2, date2);
		ticket3 = carpark.parkVehicle(vehicle3, date3);
		ticket4 = carpark.parkVehicle(vehicle4, date4);
		ticket5 = carpark.parkVehicle(vehicle5, date4); // there is no room in the car park for this one therefore it
														// will be left
														// out which makes the entry date unimportant

		carpark.printVehicleList();

		// 2 vehicles exit from the car park
		carpark.exitVehicle(ticket1, exitDate1);
		carpark.exitVehicle(ticket2, exitDate2);

		// vehicle list must be changed
		carpark.printVehicleList();

		// remaining cars exit from the car park
		carpark.exitVehicle(ticket3, exitDate3);
		carpark.exitVehicle(ticket4, exitDate4);

		// print total income
		System.out.printf("%s%.2f", "Total income :", carpark.getTotalIncome());
		System.out.println();

		// total number of tickets
		System.out.println("Total number of vehicles: " + Ticket.numberOfTickets);

		// details of tickets
		carpark.printTickets();
	}

	// a new method to easily create date objects, later specific amount of hour
	// than the initial one
	public static Date newDate(Date date, int hour) {

		Date newDate = new Date(date.getTime() + (hour * 3600000));

		return newDate;

	}

}
