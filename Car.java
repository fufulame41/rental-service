public class Car {
    private String carId;
    private String brand;
    private String model;
    private double PricePerDay;

    public Car(String carId, String brand, String model, double PricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.PricePerDay = PricePerDay;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return PricePerDay;
    }
}
