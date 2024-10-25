package lab2;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class RenterTest {

    @Test
    public void testRenterCreation() {
        Renter renter = Renter.builder()
                .firstName("John")
                .lastName("Doe")
                .driverLicenseNumber(123456)
                .birthDate(LocalDate.of(1985, 3, 20))
                .build();

        assertNotNull(renter);
        assertEquals("John", renter.getFirstName());
        assertEquals("Doe", renter.getLastName());
        assertEquals(123456, renter.getDriverLicenseNumber());
        assertEquals(LocalDate.of(1985, 3, 20), renter.getBirthDate());
    }

    @Test
    public void testRenterEquality() {
        Renter renter1 = Renter.builder()
                .firstName("John")
                .lastName("Doe")
                .driverLicenseNumber(123456)
                .birthDate(LocalDate.of(1985, 3, 20))
                .build();

        Renter renter2 = Renter.builder()
                .firstName("John")
                .lastName("Doe")
                .driverLicenseNumber(123456)
                .birthDate(LocalDate.of(1985, 3, 20))
                .build();

        assertEquals(renter1, renter2);
        assertEquals(renter1.hashCode(), renter2.hashCode());
    }
}
