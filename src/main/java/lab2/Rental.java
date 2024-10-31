package lab2;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a rental made by a renter for a car, including details about the car, renter, rental period, and payment status.
 */
@Getter
@Builder
public class Rental {
    private final Car car;
    private final Renter renter;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final boolean isPaid;

    @Override
    public String toString() {
        return "Rental{" +
                "car=" + car +
                ", renter=" + renter +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isPaid=" + isPaid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return isPaid == rental.isPaid &&
                Objects.equals(car, rental.car) &&
                Objects.equals(renter, rental.renter) &&
                Objects.equals(startDate, rental.startDate) &&
                Objects.equals(endDate, rental.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, renter, startDate, endDate, isPaid);
    }
}
