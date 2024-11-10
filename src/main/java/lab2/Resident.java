package lab2;

import lombok.Getter;
import java.util.Objects;
import java.time.LocalDate;
import lombok.Builder;

/**
 * Represents a customer with their personal details such as last name, first name,
 * documentId number, and birthdate.
 */
@Getter
@Builder
public class Resident {
    private final String lastName;
    private final String firstName;
    private final int documentId;
    private final LocalDate birthDate;

    public Resident(String lastName, String firstName, int documentId, LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.documentId = documentId;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", documentId='" + documentId + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resident resident = (Resident) o;
        return documentId == resident.documentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId);
    }
}

