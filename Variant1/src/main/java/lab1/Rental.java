package lab1;

import java.time.LocalDate;
import java.time.Period;
import java.time.Period;
import java.util.Objects;

/**
 * Represents a rental transaction with details such as car, renter, pickup and dropoff locations,
 * rental start and end dates, daily price, and total price.
 */
public class Rental {
    private Car car;
    private Renter renter;
    private String pickupLocation;
    private String dropoffLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    /**
     * Constructs a Rental object with the specified details.
     *
     * @param car             the car being rented
     * @param renter          the renter renting the car
     * @param pickupLocation  the location where the car is picked up
     * @param dropoffLocation the location where the car is dropped off
     * @param rentalStartDate the start date of the rental
     * @param rentalEndDate   the end date of the rental
     * @param dailyPrice      the daily rental price
     */
    public Rental(Car car, Renter renter, String pickupLocation, String dropoffLocation, LocalDate rentalStartDate, LocalDate rentalEndDate, double dailyPrice) {
        this.car = car;
        this.renter = renter;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.startDate = rentalStartDate;
        this.endDate = rentalEndDate;
        long rentalDuration = Period.between (rentalStartDate,  rentalEndDate).getDays() ;
        this.totalPrice = dailyPrice * rentalDuration;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "car=" + car +
                ", renter=" + renter +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", dropoffLocation='" + dropoffLocation + '\'' +
                ", rentalStartDate=" + startDate +
                ", rentalEndDate=" + endDate +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return  Objects.equals(car, rental.car) &&
                Objects.equals(renter, rental.renter) &&
                Objects.equals(pickupLocation, rental.pickupLocation) &&
                Objects.equals(startDate, rental.startDate) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, renter, pickupLocation, startDate);
    }
}


