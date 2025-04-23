public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        rentalSystem.addCar(new Car("C01", "Toyota", "Camry", 60.0));
        rentalSystem.addCar(new Car("C02", "Honda", "Accord", 70.0));
        rentalSystem.menu();
    }
}
