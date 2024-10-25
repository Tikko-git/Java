package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarCreation() {
        Car car = Car.builder()
                .type("Luxury")
                .brand("BMW")
                .dailyPrice(150.0)
                .features("Leather seats, Sunroof")
                .build();

        assertNotNull(car);
        assertEquals("Luxury", car.getType());
        assertEquals("BMW", car.getBrand());
        assertEquals(150.0, car.getDailyPrice());
        assertEquals("Leather seats, Sunroof", car.getFeatures());
    }

    @Test
    public void testCarEquality() {
        Car car1 = Car.builder()
                .type("Luxury")
                .brand("BMW")
                .dailyPrice(150.0)
                .features("Leather seats, Sunroof")
                .build();

        Car car2 = Car.builder()
                .type("Luxury")
                .brand("BMW")
                .dailyPrice(150.0)
                .features("Leather seats, Sunroof")
                .build();

        assertEquals(car1, car2);
        assertEquals(car1.hashCode(), car2.hashCode());
    }
}
