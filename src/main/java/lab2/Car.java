package lab2;

import lombok.Builder;
import lombok.Getter;
import java.util.Objects;

/**
 * Represents a car available for rental with details such as type, brand, daily price, and features.
 */
@Getter
@Builder
public class Car {
    private final String type;
    private final String brand;
    private final double dailyPrice;
    private final String features;

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", dailyPrice=" + dailyPrice +
                ", features='" + features + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.dailyPrice, dailyPrice) == 0 &&
                Objects.equals(type, car.type) &&
                Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, brand, dailyPrice);
    }
}
