package lab1;

import java.util.Objects;


/**
 * Represents a renter with details such as last name, first name, identity document, and driver's license.
 */
public class Renter {
    private String lastName;
    private String firstName;
    private String identityDocument;
    private String driverLicense;

    /**
     * Constructs a Renter object with the specified details.
     *
     * @param lastName         the last name of the renter
     * @param firstName        the first name of the renter
     * @param identityDocument the identity document of the renter
     * @param driverLicense    the driver's license of the renter
     */
    public Renter(String lastName, String firstName, String identityDocument, String driverLicense) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.identityDocument = identityDocument;
        this.driverLicense = driverLicense;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", identityDocument='" + identityDocument + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Renter renter = (Renter) o;
        return Objects.equals(lastName, renter.lastName) &&
                Objects.equals(firstName, renter.firstName) &&
                Objects.equals(identityDocument, renter.identityDocument) &&
                Objects.equals(driverLicense, renter.driverLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, identityDocument, driverLicense);
    }
}


