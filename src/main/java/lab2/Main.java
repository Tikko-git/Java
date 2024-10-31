package lab2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
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

        System.out.println(rental1);
    }
}
