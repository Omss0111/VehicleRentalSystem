package Rental_Vehicle;

public class Vehicle {

	private int id;
	private String brand;
	private double rentPerDay;
	private boolean available;

	private String customerName;
	private int rentedDays;
	private double baseRent;
	private double extraCharge;
	private double totalRent;

	static int count = 0;

	static final String COMPANY = "Om Rentals";

	public Vehicle(int id, String brand, double rentPerDay) {

		this.id = id;
		this.brand = brand;
		this.rentPerDay = rentPerDay;
		this.available = true;

		count++;
	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public double getRentPerDay() {
		return rentPerDay;
	}

	public boolean isAvailable() {
		return available;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getRentedDays() {
		return rentedDays;
	}

	public double getBaseRent() {
		return baseRent;
	}

	public double getExtraCharge() {
		return extraCharge;
	}

	public double getTotalRent() {
		return totalRent;
	}

	protected double calculateBaseRent(int days) {

		return rentPerDay * days;
	}

	public double calculateExtraCharge(int days) {

		return 0;
	}

	public double calculateRent(int days) {

		baseRent = calculateBaseRent(days);

		extraCharge = calculateExtraCharge(days);

		totalRent = baseRent + extraCharge;

		return totalRent;
	}

	public void rentVehicle(String customerName, int days) {

		this.available = false;
		this.customerName = customerName;
		this.rentedDays = days;

		calculateRent(days);
	}

	public void returnVehicle() {

		this.available = true;

		this.customerName = null;
		this.rentedDays = 0;

		this.baseRent = 0;
		this.extraCharge = 0;
		this.totalRent = 0;
	}

	public void display() {

		System.out.println("----------------------------------------");
		System.out.println("ID        : " + id);
		System.out.println("Brand     : " + brand);
		System.out.println("Rent/Day  : Rs." + rentPerDay);

		if (available) {

			System.out.println("Status    : Available");

		} else {

			System.out.println("Status    : Rented");
			System.out.println("Customer  : " + customerName);
			System.out.println("Days      : " + rentedDays);
		}
	}

	public void displayRentalDetails() {

		System.out.println("----------------------------------------");
		System.out.println("Vehicle ID       : " + id);
		System.out.println("Brand            : " + brand);
		System.out.println("Customer         : " + customerName);
		System.out.println("Number of Days   : " + rentedDays);
		System.out.println("Rent Per Day     : Rs." + rentPerDay);
		System.out.println("Base Rent        : Rs." + baseRent);
		System.out.println("Extra Charges    : Rs." + extraCharge);
		System.out.println("Total Rent       : Rs." + totalRent);
		System.out.println("----------------------------------------");
	}
}