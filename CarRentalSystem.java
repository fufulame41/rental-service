import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers; 
    private List<Admin> admins; 

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        admins = new ArrayList<>();

        admins.add(new Admin("ADM1", "Admin User", "admin", "0000"));
        customers.add(new Customer("CUS1", "Alice", "alice", "0000"));
        initializeCars();
    }
    
    public void initializeCars() {
        addCar(new Car("C01", "Toyota", "Camry", 60.0));
        addCar(new Car("C02", "Honda", "Accord", 70.0));
        addCar(new Car("C03", "Mahindra", "Thar", 150.0));
        addCar(new Car("C04", "Ford", "Mustang", 120.0));
        addCar(new Car("C05", "Chevrolet", "Cruze", 80.0));
        addCar(new Car("C06", "BMW", "X5", 200.0));
        addCar(new Car("C07", "Mercedes-Benz", "E-Class", 180.0));
        addCar(new Car("C08", "Audi", "Q7", 220.0));
        addCar(new Car("C09", "Nissan", "Altima", 75.0));
        addCar(new Car("C10", "Hyundai", "Tucson", 90.0));
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Welcome to Car Rental System =====");
            System.out.println("0. Exit System");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.print("Enter your choice: ");

            int loginChoice = scanner.nextInt();
            scanner.nextLine();

            if (loginChoice == 0) {
                System.out.println("\nExiting the system. Goodbye!");
                break;
            } else if (loginChoice == 1) {
                adminMenu(scanner);
            } else if (loginChoice == 2) {
                customerMenu(scanner);
            } else {
                System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void showCars() {
        System.out.println("\n===== Car Inventory =====");
        for (Car car : cars) {
            System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
        }
    }

    private boolean authenticateAdmin(String username, String password) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private void adminMenu(Scanner scanner) {
        System.out.print("\nEnter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        if (!authenticateAdmin(username, password)) {
            System.out.println("\nInvalid credentials! Returning to main menu...");
            return;
        }

        System.out.println("\nLogin successful. Welcome, " + username + "!");
        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Add a Car");
            System.out.println("2. View All Cars");
            System.out.println("3. Add a New Customer");
            System.out.println("4. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int adminChoice = scanner.nextInt();
            scanner.nextLine();

            if (adminChoice == 1) {
                System.out.print("\nEnter Car ID: ");
                String carId = scanner.nextLine();
                System.out.print("Enter Brand: ");
                String brand = scanner.nextLine();
                System.out.print("Enter Model: ");
                String model = scanner.nextLine();
                System.out.print("Enter Price per day: ");
                double PricePerDay = scanner.nextDouble();
                scanner.nextLine();

                Car newCar = new Car(carId, brand, model, PricePerDay);
                addCar(newCar);
                System.out.println("\nCar added successfully.");
            } else if (adminChoice == 2) {
                showCars();
            } else if (adminChoice == 3) {
                System.out.print("\nEnter Customer Username: ");
                String customerUsername = scanner.nextLine();
                System.out.print("Enter Customer PIN: ");
                String customerPIN = scanner.nextLine();
                String customerId = "CUS" + (customers.size() + 1);
                Customer newCustomer = new Customer(customerId, "New Customer", customerUsername, customerPIN);
                addCustomer(newCustomer);
                System.out.println("\nCustomer added successfully! Username: " + customerUsername + ", PIN: " + customerPIN);
            } else if (adminChoice == 4) {
                break;
            } else {
                System.out.println("\nInvalid choice. Please enter a valid option.");
            }
        }
    }

    private void customerMenu(Scanner scanner) {
        System.out.print("\nEnter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Customer loggedInCustomer = null;

        for (Customer customer : customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                loggedInCustomer = customer;
                break;
            }
        }

        if (loggedInCustomer == null) {
            System.out.println("\nInvalid credentials! Returning to main menu...");
            return;
        }

        System.out.println("\nLogin successful. Welcome, " + loggedInCustomer.getName() + "!");
        while (true) {
            System.out.println("\n===== Customer Menu =====");
            System.out.println("1. Mark Interest in a Car");
            System.out.println("2. View Available & Interested Cars");
            System.out.println("3. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int customerChoice = scanner.nextInt();
            scanner.nextLine();

            if (customerChoice == 1) {
                System.out.println("\nAvailable Cars:");
                for (Car car : cars) {
                    boolean isInterested = false;
                    for (Customer customer : customers) {
                        if (customer.getInterestedCars().contains(car)) {
                            isInterested = true;
                            break;
                        }
                    }
                    if (!isInterested) {
                        System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
                    }
                }

                System.out.print("\nEnter the car ID you are interested in: ");
                String carId = scanner.nextLine();

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId)) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    loggedInCustomer.markInterest(selectedCar);
                    System.out.println("\nInterest recorded successfully.");
                } else {
                    System.out.println("\nInvalid car selection.");
                }
            } else if (customerChoice == 2) {
                showCars();
            } else if (customerChoice == 3) {
                break;
            } else {
                System.out.println("\nInvalid choice. Please enter a valid option.");
            }
        }
    }
}
