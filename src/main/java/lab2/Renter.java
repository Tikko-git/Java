package lab2;

import lombok.Getter;
import lombok.Builder;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a person renting a car, with details like name, driver license, and birthdate.
 */
@Getter
@Builder
public class Renter {
    private final String firstName;
    private final String lastName;
    private final int driverLicenseNumber;
    private final LocalDate birthDate;

    @Override
    public String toString() {
        return "Renter{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", driverLicenseNumber=" + driverLicenseNumber +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Renter renter = (Renter) o;
        return driverLicenseNumber == renter.driverLicenseNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverLicenseNumber);
    }
}
