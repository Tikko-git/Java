package lab2;

import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class RentalTest {

    @Test
    public void testRentalCreation() {
        Car car = Car.builder()
                .type("Luxury")
                .brand("BMW")
                .dailyPrice(150.0)
                .features("Leather seats, Sunroof")
                .build();

        Renter renter = Renter.builder()
                .firstName("John")
                .lastName("Doe")
                .driverLicenseNumber(123456)
                .birthDate(LocalDate.of(1985, 3, 20))
                .build();

        Rental rental = Rental.builder()
                .car(car)
                .renter(renter)
                .startDate(LocalDate.of(2024, 10, 1))
                .endDate(LocalDate.of(2024, 10, 5))
                .isPaid(true)
                .build();

        assertNotNull(rental);
        assertEquals(car, rental.getCar());
        assertEquals(renter, rental.getRenter());
        assertEquals(LocalDate.of(2024, 10, 1), rental.getStartDate());
        assertEquals(LocalDate.of(2024, 10, 5), rental.getEndDate());
        assertTrue(rental.isPaid());
    }

    @Test
    public void testRentalEquality() {
        Car car1 = Car.builder()
                .type("Luxury")
                .brand("BMW")
                .dailyPrice(150.0)
                .features("Leather seats, Sunroof")
                .build();

        Renter renter1 = Renter.builder()
                .firstName("John")
                .lastName("Doe")
                .driverLicenseNumber(123456)
                .birthDate(LocalDate.of(1985, 3, 20))
                .build();

        Rental rental1 = Rental.builder()
                .car(car1)
                .renter(renter1)
                .startDate(LocalDate.of(2024, 10, 1))
                .endDate(LocalDate.of(2024, 10, 5))
                .isPaid(true)
                .build();

        Rental rental2 = Rental.builder()
                .car(car1)
                .renter(renter1)
                .startDate(LocalDate.of(2024, 10, 1))
                .endDate(LocalDate.of(2024, 10, 5))
                .isPaid(true)
                .build();

        assertEquals(rental1, rental2);
        assertEquals(rental1.hashCode(), rental2.hashCode());
    }
}