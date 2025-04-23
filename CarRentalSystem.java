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

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n===== Welcome to Car Rental System =====");
        // Your menu logic here
    }
}
