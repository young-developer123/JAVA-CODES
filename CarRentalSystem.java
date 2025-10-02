import java.util.ArrayList;
import java.util.Scanner;

// Represents a car in the rental fleet
class Car {
    private String registrationNumber;
    private String model;
    private boolean isAvailable;

    public Car(String registrationNumber, String model) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.isAvailable = true;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rentOut() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return model + " [" + registrationNumber + "] - " + (isAvailable ? "Available" : "Rented");
    }
}

// Represents a customer renting cars
class Customer {
    private String name;
    private String customerId;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getDetails() {
        return name + " (ID: " + customerId + ")";
    }
}

// Manages the car rental operations
class RentalAgency {
    private ArrayList<Car> fleet;

    public RentalAgency() {
        fleet = new ArrayList<>();
    }

    public void addCar(Car car) {
        fleet.add(car);
    }

    public void displayAvailableCars() {
        System.out.println(" Available Cars:");
        for (Car car : fleet) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    public boolean rentCar(String model) {
        for (Car car : fleet) {
            if (car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                car.rentOut();
                System.out.println(" " + model + " has been rented.");
                return true;
            }
        }
        System.out.println(" Car not available or already rented.");
        return false;
    }

    public void returnCar(String model) {
        for (Car car : fleet) {
            if (car.getModel().equalsIgnoreCase(model) && !car.isAvailable()) {
                car.returnCar();
                System.out.println("" + model + " has been returned.");
                return;
            }
        }
        System.out.println("No rented car found with model: " + model);
    }
}

// Main class to run the system — must match filename: CarRentalSystem.java
public class CarRentalSystem {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        Scanner scanner = new Scanner(System.in);

        // Add cars to the fleet
        agency.addCar(new Car("KDA123A", "Toyota Axio"));
        agency.addCar(new Car("KDB456B", "Mazda Demio"));
        agency.addCar(new Car("KDC789C", "Honda Fit"));

        // Create a customer
        Customer customer = new Customer("Elijah Dorcas", "BSE-05-0111/2024");
        System.out.println("👤 Customer: " + customer.getDetails());

        // Rental interaction
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    agency.displayAvailableCars();
                    break;
                case 2:
                    System.out.print("Enter car model to rent: ");
                    String rentModel = scanner.nextLine();
                    agency.rentCar(rentModel);
                    break;
                case 3:
                    System.out.print("Enter car model to return: ");
                    String returnModel = scanner.nextLine();
                    agency.returnCar(returnModel);
                    break;
                case 4:
                    System.out.println("Thank you for using Zetech Car Rental System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
