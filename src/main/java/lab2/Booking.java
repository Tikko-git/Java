package lab2;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a booking made by a customer for a hotel room, including details about the
 * room, customer, booking period, and payment status.
 */
@Getter
@Builder
public class Booking {
    private Room room;
    private final Resident resident;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean Paid;

    public Booking(Room room, Resident resident, LocalDate startDate, LocalDate endDate, boolean Paid) {
        this.room = room;
        this.resident = resident;
        this.startDate = startDate;
        this.endDate = endDate;
        this.Paid = Paid;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", resident=" + resident +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", Paid=" + Paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return room.equals(booking.room) &&
                resident.equals(booking.resident) &&
                Objects.equals(startDate, booking.startDate) &&
                Objects.equals(endDate, booking.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, startDate, endDate);
    }
}

