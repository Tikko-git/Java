package lab1;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a reservation made by a client for a specific room in a hotel.
 * Includes details about the room number, client, check-in and check-out dates, and payment status.
 */
public class Reservation {
    private String roomNumber;
    private Resident resident;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate enterDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    private StatusOfPayment payment;

    /**
     * Constructs a new Reservation object with the specified details.
     *
     * @param roomNumber the reserved room
     * @param resident the Client who made the reservation
     * @param enterDate the date when the client will check in
     * @param departureDate the date when the client will check out
     * @param payment indicates whether the reservation has been paid for
     */
    public Reservation(String roomNumber, Resident resident, LocalDate enterDate, LocalDate departureDate, StatusOfPayment payment) {
        this.roomNumber = roomNumber;
        this.resident = resident;
        this.enterDate = enterDate;
        this.departureDate = departureDate;
        this.payment = payment;
    }

    public Reservation() {
    }

    /**
     * Returns the number of the room reserved.
     *
     * @return the room number
     */
    public String getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * Returns the Client who made the reservation.
     *
     * @return the client
     */
    public Resident getResident() {
        return this.resident;
    }

    /**
     * Returns the check-in date for the reservation.
     *
     * @return the check-in date
     */
    public LocalDate getEnterDate() {
        return this.enterDate;
    }

    /**
     * Returns the check-out date for the reservation.
     *
     * @return the check-out date
     */
    public LocalDate getDepartureDate() {
        return this.departureDate;
    }

    /**
     * Returns whether the reservation has been paid for.
     *
     * @return {@code true} if the reservation is paid, {@code false} otherwise
     */
    public StatusOfPayment getPayment() {
        return this.payment;
    }

    /**
     * Returns a string representation of the reservation, including room number, client details,
     * check-in and check-out dates, and payment status.
     *
     * @return a string containing reservation details
     */
    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + this.roomNumber +
                ", resident=" + this.resident +
                ", enterDate=" + this.enterDate +
                ", departureDate=" + this.departureDate +
                ", paymentStatus=" + this.payment +
                '}';
    }

    /**
     * Compares this Reservation object to another object for equality.
     * Two Reservation objects are considered equal if they have the same room number, client,
     * check-in and check-out dates, and payment status.
     *
     * @param o the object to compare to
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(this.roomNumber, that.roomNumber) &&
                this.resident.equals(that.resident) &&
                this.enterDate.equals(that.enterDate) &&
                this.departureDate.equals(that.departureDate) &&
                this.payment.equals(that.payment);
    }

    /**
     * Returns the hash code value for this Reservation object.
     * The hash code is computed based on the room number, client, check-in and check-out dates.
     *
     * @return the hash code of the reservation
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.roomNumber, this.resident, this.enterDate, this.departureDate);
    }
}
