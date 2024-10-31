package lab1;

import java.util.Objects;

/**
 * Represents a car for rent with details such as brand, VIN, plate number, year of manufacture, and mileage.
 */
public class Car {
    private String brand;
    private String vin;
    private String plateNumber;
    private int yearOfManufacture;
    private int mileage;
    private double dailyPrice;

    /**
     * Builder class to construct a Car object step by step.
     */
    public static class Builder {
        private String brand;
        private String vin;
        private String plateNumber;
        private int yearOfManufacture;
        private int mileage;
        private double dailyPrice;

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setVin(String vin) {
            this.vin = vin;
            return this;
        }

        public Builder setPlateNumber(String plateNumber) {
            this.plateNumber = plateNumber;
            return this;
        }

        public Builder setYearOfManufacture(int yearOfManufacture) {
            this.yearOfManufacture = yearOfManufacture;
            return this;
        }

        public Builder setMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Builder setDailyPrice(double dailyPrice) {
            this.dailyPrice = dailyPrice;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    /**
     * Private constructor for Car, called by the Builder.
     */
    private Car(Builder builder) {
        this.brand = builder.brand;
        this.vin = builder.vin;
        this.plateNumber = builder.plateNumber;
        this.yearOfManufacture = builder.yearOfManufacture;
        this.mileage = builder.mileage;
        this.dailyPrice = builder.dailyPrice;
    }

    /**
     * Getter for dailyPrice.
     */
    public double getDailyPrice() {
        return dailyPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", vin='" + vin + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", mileage=" + mileage +
                ", dailyPrice=" + dailyPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(vin, car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }
}
