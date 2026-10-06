package Rental_Vehicle;

public class Car extends Vehicle {

	private int seats;

	private static final double SERVICE_CHARGE = 200;

	public Car(int id, String brand, double rent, int seats) {

		super(id, brand, rent);

		this.seats = seats;
	}

	public int getSeats() {
		return seats;
	}

	@Override
	public double calculateExtraCharge(int days) {

		return SERVICE_CHARGE * days;
	}

	@Override
	public void display() {

		super.display();

		System.out.println("Type      : Car");
		System.out.println("Seats     : " + seats);
		System.out.println("----------------------------------------");
	}
}