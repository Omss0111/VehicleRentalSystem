package Rental_Vehicle;

import java.util.Scanner;

public class Main {

	public static boolean isIdExists(Vehicle[] vehicles, int vehicleCount, int id) {

		for (int i = 0; i < vehicleCount; i++) {

			if (vehicles[i].getId() == id) {

				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Vehicle[] vehicles = new Vehicle[30];

		vehicles[0] = new Car(101, "BMW", 1500, 5);
		vehicles[1] = new Car(102, "Audi", 1800, 5);
		vehicles[2] = new Car(103, "Toyota", 1200, 7);
		vehicles[3] = new Car(104, "Honda", 1000, 5);
		vehicles[4] = new Car(105, "Hyundai", 900, 5);
		vehicles[5] = new Car(106, "Kia", 1100, 5);
		vehicles[6] = new Car(107, "Mercedes", 2500, 5);
		vehicles[7] = new Car(108, "Tata", 800, 7);
		vehicles[8] = new Car(109, "Mahindra", 1000, 7);
		vehicles[9] = new Car(110, "Skoda", 1300, 5);

		vehicles[10] = new Bike(111, "Yamaha", 700, true);
		vehicles[11] = new Bike(112, "Honda", 600, true);
		vehicles[12] = new Bike(113, "Royal Enfield", 900, true);
		vehicles[13] = new Bike(114, "Bajaj", 550, false);
		vehicles[14] = new Bike(115, "TVS", 500, true);
		vehicles[15] = new Bike(116, "KTM", 1000, true);
		vehicles[16] = new Bike(117, "Suzuki", 650, false);
		vehicles[17] = new Bike(118, "Hero", 450, true);
		vehicles[18] = new Bike(119, "Jawa", 850, true);
		vehicles[19] = new Bike(120, "Pulsar", 600, true);

		int vehicleCount = 20;

		int choice;

		while (true) {

			System.out.println();
			System.out.println("======================================");
			System.out.println("             " + Vehicle.COMPANY);
			System.out.println("        VEHICLE RENTAL SYSTEM");
			System.out.println("======================================");

			System.out.println("1. Add Car");
			System.out.println("2. Add Bike");
			System.out.println("3. Display All Vehicles");
			System.out.println("4. Display Available Vehicles");
			System.out.println("5. My Rented Vehicles");
			System.out.println("6. Rent Vehicle");
			System.out.println("7. Return Vehicle");
			System.out.println("8. Search Vehicle");
			System.out.println("9. Exit");

			System.out.println("======================================");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:

				if (vehicleCount >= vehicles.length) {

					System.out.println("Vehicle storage is full.");
					break;
				}

				System.out.print("Enter ID: ");
				int carId = sc.nextInt();

				if (isIdExists(vehicles, vehicleCount, carId)) {

					System.out.println("Vehicle ID already exists.");
					break;
				}

				sc.nextLine();

				System.out.print("Enter Brand: ");
				String carBrand = sc.nextLine();

				System.out.print("Enter Rent/Day: ");
				double carRent = sc.nextDouble();

				if (carRent <= 0) {

					System.out.println("Rent must be greater than 0.");

					break;
				}

				System.out.print("Enter Seats: ");
				int seats = sc.nextInt();

				if (seats <= 0) {

					System.out.println("Seats must be greater than 0.");

					break;
				}

				vehicles[vehicleCount] = new Car(carId, carBrand, carRent, seats);

				vehicleCount++;

				System.out.println("Car added successfully!");

				break;

			case 2:

				if (vehicleCount >= vehicles.length) {

					System.out.println("Vehicle storage is full.");
					break;
				}

				System.out.print("Enter ID: ");
				int bikeId = sc.nextInt();

				if (isIdExists(vehicles, vehicleCount, bikeId)) {

					System.out.println("Vehicle ID already exists.");
					break;
				}

				sc.nextLine();

				System.out.print("Enter Brand: ");
				String bikeBrand = sc.nextLine();

				System.out.print("Enter Rent/Day: ");
				double bikeRent = sc.nextDouble();

				if (bikeRent <= 0) {

					System.out.println("Rent must be greater than 0.");

					break;
				}

				System.out.print("Helmet available? true/false: ");

				boolean helmet = sc.nextBoolean();

				vehicles[vehicleCount] = new Bike(bikeId, bikeBrand, bikeRent, helmet);

				vehicleCount++;

				System.out.println("Bike added successfully!");

				break;

			case 3:

				if (vehicleCount == 0) {

					System.out.println("No vehicles available.");

				} else {

					System.out.println();
					System.out.println("========== ALL VEHICLES ==========");

					for (int i = 0; i < vehicleCount; i++) {

						vehicles[i].display();
					}
				}

				break;

			case 4:

				boolean foundAvailable = false;

				System.out.println();
				System.out.println("======= AVAILABLE VEHICLES =======");

				for (int i = 0; i < vehicleCount; i++) {

					if (vehicles[i].isAvailable()) {

						vehicles[i].display();

						foundAvailable = true;
					}
				}

				if (!foundAvailable) {

					System.out.println("No vehicles are available.");
				}

				break;

			case 5:

				boolean foundRented = false;

				System.out.println();
				System.out.println("========= MY RENTED VEHICLES =========");

				for (int i = 0; i < vehicleCount; i++) {

					if (!vehicles[i].isAvailable()) {

						vehicles[i].displayRentalDetails();

						foundRented = true;
					}
				}

				if (!foundRented) {

					System.out.println("You have no rented vehicles.");
				}

				break;

			case 6:

				System.out.print("Enter Vehicle ID: ");
				int rentId = sc.nextInt();

				boolean foundRent = false;

				for (int i = 0; i < vehicleCount; i++) {

					if (vehicles[i].getId() == rentId) {

						foundRent = true;

						if (!vehicles[i].isAvailable()) {

							System.out.println("Vehicle is already rented.");

							break;
						}

						sc.nextLine();

						System.out.print("Enter your name: ");
						String name = sc.nextLine();

						System.out.print("Enter number of days: ");

						int days = sc.nextInt();

						if (days <= 0) {

							System.out.println("Days must be greater than 0.");

							break;
						}

						vehicles[i].rentVehicle(name, days);

						System.out.println();
						System.out.println("======================================");

						System.out.println("    VEHICLE RENTED SUCCESSFULLY");

						System.out.println("======================================");

						vehicles[i].displayRentalDetails();

						break;
					}
				}

				if (!foundRent) {

					System.out.println("Vehicle not found.");
				}

				break;

			case 7:

				System.out.print("Enter Vehicle ID: ");

				int returnId = sc.nextInt();

				boolean foundReturn = false;

				for (int i = 0; i < vehicleCount; i++) {

					if (vehicles[i].getId() == returnId) {

						foundReturn = true;

						if (vehicles[i].isAvailable()) {

							System.out.println("Vehicle is not currently rented.");

						} else {

							System.out.println();
							System.out.println("Rental details:");

							vehicles[i].displayRentalDetails();

							vehicles[i].returnVehicle();

							System.out.println("Vehicle returned successfully.");
						}

						break;
					}
				}

				if (!foundReturn) {

					System.out.println("Vehicle not found.");
				}

				break;

			case 8:

				System.out.print("Enter Vehicle ID: ");

				int searchId = sc.nextInt();

				boolean foundSearch = false;

				for (int i = 0; i < vehicleCount; i++) {

					if (vehicles[i].getId() == searchId) {

						vehicles[i].display();

						foundSearch = true;

						break;
					}
				}

				if (!foundSearch) {

					System.out.println("Vehicle not found.");
				}

				break;

			case 9:

				System.out.println();
				System.out.println("Thank you for using " + Vehicle.COMPANY + "!");

				sc.close();

				return;

			default:

				System.out.println("Invalid choice!");
			}
		}
	}
}