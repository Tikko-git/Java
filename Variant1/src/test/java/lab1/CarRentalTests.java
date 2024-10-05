package lab1;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;

import java.util.Date;

public class CarRentalTests {

    @Test
    public void testCarConstructor() {
        Car car1 = new Car.Builder()
                .setBrand("Toyota")
                .setVin("JTDBT123456789012")
                .setPlateNumber("ABC-123")
                .setYearOfManufacture(2015)
                .setMileage(50000)
                .build();
        Assert.assertEquals(car1.toString(),
                "Car{brand='Toyota', vin='JTDBT123456789012', plateNumber='ABC-123', yearOfManufacture=2015, mileage=50000, dailyPrice=0.0}",
                "Car details should match the expected values.");
    }


    @Test
    public void testRenterConstructor() {
        Renter renter1 = new Renter("Doe", "John", "Passport", "DL123456");

        Assert.assertEquals(renter1.toString(),
                "Renter{lastName='Doe', firstName='John', identityDocument='Passport', driverLicense='DL123456'}",
                "Renter details should match the expected values.");
    }

    @Test
    public void testRentalConstructor() {
        Car car1 = new Car.Builder()
                .setBrand("Toyota")
                .setVin("JTDBT123456789012")
                .setPlateNumber("ABC-123")
                .setYearOfManufacture(2015)
                .setMileage(50000)
                .setDailyPrice(20.0)
                .build();

        Renter renter1 = new Renter("Doe", "John", "Passport", "DL123456");

        Rental rental1 = new Rental(
                car1,
                renter1,
                "Location A",
                "Location B",
                LocalDate.of(2024, 9, 10),
                LocalDate.of(2024, 9, 15),
                50.0
        );

        Assert.assertEquals(rental1.toString(),
                "Rental{car=Car{brand='Toyota', vin='JTDBT123456789012', plateNumber='ABC-123', yearOfManufacture=2015, mileage=50000, dailyPrice=20.0}, " +
                        "renter=Renter{lastName='Doe', firstName='John', identityDocument='Passport', driverLicense='DL123456'}, " +
                        "pickupLocation='Location A', dropoffLocation='Location B', rentalStartDate=2024-09-10, rentalEndDate=2024-09-15, totalPrice=250.0}",
                "Rental details should match the expected values."
        );
    }

    @Test
    public void testCarEquality() {
        Car car1 = new Car.Builder()
                .setBrand("Toyota")
                .setVin("JTDBT123456789012")
                .setPlateNumber("ABC-123")
                .setYearOfManufacture(2015)
                .setMileage(50000)
                .build();

        Car car2 = new Car.Builder()
                .setBrand("Honda")
                .setVin("HNDA4567890123456")
                .setPlateNumber("XYZ-789")
                .setYearOfManufacture(2018)
                .setMileage(30000)
                .build();

        Assert.assertNotEquals(car1, car2, "Car 1 should not equal Car 2.");
    }

    @Test
    public void testRentalEquality() {
        Car car1 = new Car.Builder()
                .setBrand("Toyota")
                .setVin("JTDBT123456789012")
                .setPlateNumber("ABC-123")
                .setYearOfManufacture(2015)
                .setMileage(50000)
                .build();

        Car car2 = new Car.Builder()
                .setBrand("Honda")
                .setVin("HNDA4567890123456")
                .setPlateNumber("XYZ-789")
                .setYearOfManufacture(2018)
                .setMileage(30000)
                .build();

        Renter renter1 = new Renter("Doe", "John", "Passport", "DL123456");
        Renter renter2 = new Renter("Smith", "Jane", "ID Card", "DL654321");

        Rental rental1 = new Rental(
                car1,
                renter1,
                "Location A",
                "Location B",
                LocalDate.of(2024, 9, 10),
                LocalDate.of(2024, 9, 15),
                50.0
        );

        Rental rental2 = new Rental(
                car2,
                renter2,
                "Location C",
                "Location D",
                LocalDate.of(2024, 10, 1),
                LocalDate.of(2024, 10, 7),
                60.0
        );

        Assert.assertNotEquals(rental1, rental2, "Rental 1 should not equal Rental 2.");
    }

    @Test
    public void testRenterEquality() {
        Renter renter1 = new Renter("Doe", "John", "Passport", "DL123456");
        Renter renter2 = new Renter("Smith", "Jane", "ID Card", "DL654321");

        Assert.assertNotEquals(renter1, renter2, "Renter 1 should not equal Renter 2.");

        Renter sameAsRenter1 = new Renter("Doe", "John", "Passport", "DL123456");
        Assert.assertEquals(renter1, sameAsRenter1, "Renters with the same details should be equal.");
    }

    @Test
    public void testHashCodeConsistency() {
        Car car1 = new Car.Builder()
                .setBrand("Toyota")
                .setVin("JTDBT123456789012")
                .setPlateNumber("ABC-123")
                .setYearOfManufacture(2015)
                .setMileage(50000)
                .build();

        int car1HashCode = car1.hashCode();
        int car1HashCodeAgain = car1.hashCode();
        Assert.assertEquals(car1HashCode, car1HashCodeAgain, "HashCode should be consistent across multiple calls.");

        Renter renter1 = new Renter("Doe", "John", "Passport", "DL123456");

        Rental rental1 = new Rental(
                car1,
                renter1,
                "Location A",
                "Location B",
                LocalDate.of(2024, 9, 10),
                LocalDate.of(2024, 9, 15),
                50.0
        );

        int rental1HashCode = rental1.hashCode();
        int rental1HashCodeAgain = rental1.hashCode();
        Assert.assertEquals(rental1HashCode, rental1HashCodeAgain, "HashCode should be consistent across multiple calls.");
    }
}
