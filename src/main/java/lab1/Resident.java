package lab1;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a client with personal details including their name, document status, and date of birth.
 */
public class Resident {
    private  String firstName;
    private  String lastName;
    private  String passportId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public Resident() {
    }
    /**
     * Constructs a new Client object with the specified details.
     *
     * @param firstName the first name of the client
     * @param lastName the last name of the client
     * @param passportId the document status of the client (e.g., whether documents are provided)
     * @param dateOfBirth the date of birth of the client
     */
    public Resident(String firstName, String lastName, String passportId, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns a string representation of the client, including their first name, last name, document status, and date of birth.
     *
     * @return a string containing the client's details
     */
    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", passportId=" + this.passportId +
                ", dateOfBirth=" + this.dateOfBirth +
                '}';
    }

    /**
     * Compares this Client object to another object for equality.
     * Two Client objects are considered equal if they have the same first name, last name, document status, and date of birth.
     *
     * @param o the object to compare to
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resident resident = (Resident) o;
        return this.firstName.equals(resident.firstName) &&
                this.lastName.equals(resident.lastName) &&
                this.passportId.equals(resident.passportId) &&
                this.dateOfBirth.equals(resident.dateOfBirth);
    }

    /**
     * Returns the hash code value for this Client object.
     * The hash code is computed based on the client's first name, last name, document status, and date of birth.
     *
     * @return the hash code of the client
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName, this.passportId, this.dateOfBirth);
    }

    /**
     * Returns the first name of the client.
     *
     * @return the first name of the client
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the last name of the client.
     *
     * @return the last name of the client
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns the date of birth of the client.
     *
     * @return the date of birth of the client
     */
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * Returns the document status of the client.
     *
     * @return {@code true} if the client has provided documents, {@code false} otherwise
     */
    public String getPassportId() {
        return this.passportId;
    }
}
