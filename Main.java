public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        rentalSystem.addCar(new Car("C01", "Toyota", "Camry", 60.0));
        rentalSystem.addCar(new Car("C02", "Honda", "Accord", 70.0));
        rentalSystem.addCar(new Car("C03", "Mahindra", "Thar", 150.0));
        rentalSystem.addCar(new Car("C04", "Ford", "Mustang", 120.0));
        rentalSystem.addCar(new Car("C05", "Chevrolet", "Cruze", 80.0));
        rentalSystem.addCar(new Car("C06", "BMW", "X5", 200.0));
        rentalSystem.addCar(new Car("C07", "Mercedes-Benz", "E-Class", 180.0));
        rentalSystem.addCar(new Car("C08", "Audi", "Q7", 220.0));
        rentalSystem.addCar(new Car("C09", "Nissan", "Altima", 75.0));
        rentalSystem.addCar(new Car("C10", "Hyundai", "Tucson", 90.0));

        rentalSystem.menu();
    }
}
