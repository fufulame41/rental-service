import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private String username;
    private String password;
    private List<Car> interestedCars;

    public Customer(String id, String name, String username, String password) {
        super(id, name);
        this.username = username;
        this.password = password;
        this.interestedCars = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void markInterest(Car car) {
        if (!interestedCars.contains(car)) {
            interestedCars.add(car);
            System.out.println(getName() + " is interested in " + car.getBrand() + " " + car.getModel());
        } else {
            System.out.println("You have already marked interest in this car.");
        }
    }

    public List<Car> getInterestedCars() {
        return interestedCars;
    }
}
