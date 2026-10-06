package Rental_Vehicle;

public class Bike extends Vehicle {

	private boolean helmet;

	private static final double HELMET_CHARGE = 100;

	public Bike(int id, String brand, double rent, boolean helmet) {

		super(id, brand, rent);

		this.helmet = helmet;
	}

	public boolean isHelmet() {
		return helmet;
	}

	@Override
	public double calculateExtraCharge(int days) {

		if (helmet) {

			return HELMET_CHARGE * days;
		}

		return 0;
	}

	@Override
	public void display() {

		super.display();

		System.out.println("Type      : Bike");
		System.out.println("Helmet    : " + helmet);
		System.out.println("----------------------------------------");
	}
}