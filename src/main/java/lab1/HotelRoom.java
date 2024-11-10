package lab1;

import lab4.RoomValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hotel room with details about room number, type, capacity, features, and reservations.
 */
public class HotelRoom implements Comparable<HotelRoom> {
    private String number;
    private RoomType type;
    private int capacity;
    private List<RoomСharacteristics> features;
    private List<Reservation> reservations;

    public HotelRoom() {}

    /**
     * Constructs a new HotelRoom object using the Builder.
     *
     * @param builder the Builder object containing the values for the room
     */
    public HotelRoom(Builder builder) {
        this.number = builder.number;
        this.type = builder.type;
        this.capacity = builder.capacity;
        this.features = builder.features;
        this.reservations = builder.reservations;
    }

    /**
     * Returns the room number.
     *
     * @return the room number
     */
    public String getNumber() {
        return this.number;
    }


    /**
     * Returns the room type.
     *
     * @return the room type
     */
    public RoomType getType() {
        return this.type;
    }

    /**
     * Returns the capacity of the room (i.e., how many people it can accommodate).
     *
     * @return the room capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Returns the room's features (e.g., sea view, balcony, air conditioning).
     *
     * @return the room features
     */
    public List<RoomСharacteristics> getFeatures() {
        return this.features;
    }

    /**
     * Returns the reservations associated with the room.
     *
     * @return a List of Reservation objects for the room
     */
    public List<Reservation> getReservations() {
        return this.reservations;
    }

    /**
     * Sets the reservations for the room.
     *
     * @param reservations an array of Reservation objects to be assigned to the room
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    /**
     * The builder class used to create HotelRoom objects.
     */
    public static class Builder {
        private String number;
        private RoomType type;
        private int capacity;
        private List<RoomСharacteristics> features;
        private List<Reservation> reservations;

        /**
         * Sets the room number.
         *
         * @param number the room number to be set
         * @return the Builder object
         */
        public Builder setNumber(String number) {
            RoomValidation.validateNumber(number);
            this.number = number;
            return this;
        }

        /**
         * Sets the room type.
         *
         * @param type the room type to be set
         * @return the Builder object
         */
        public Builder setType(RoomType type) {
            RoomValidation.validateType(type);
            this.type = type;
            return this;
        }
        /**
         * Sets the room capacity.
         *
         * @param capacity the capacity of the room
         * @return the Builder object
         */
        public Builder setCapacity(int capacity) {
            RoomValidation.validateCapacity(capacity);
            this.capacity = capacity;
            return this;
        }

        /**
         * Sets the room features.
         *
         * @param features the features of the room
         * @return the Builder object
         */
        public Builder setFeatures(List<RoomСharacteristics> features) {
            RoomValidation.validateFeatures(features);
            this.features = features;
            return this;
        }

        /**
         * Sets the reservations for the room.
         *
         * @param reservations the array of Reservation objects to be set
         * @return the Builder object
         */
        public Builder setReservations(List<Reservation> reservations) {
            this.reservations = reservations;
            return this;
        }

        /**
         * Builds a new HotelRoom object using the current Builder settings.
         *
         * @return a new HotelRoom object
         */
        public HotelRoom build() {
            List<String> errors = validateFields();
            if (!errors.isEmpty()) {
                throw new IllegalArgumentException("Invalid field values: " + String.join("; ", errors));
            }
            return new HotelRoom(this);
        }

        private List<String> validateFields() {
            List<String> errors = new ArrayList<>();

            if (number == null || number.isEmpty() || !number.matches("^[A-Z0-9]+$")) {
                errors.add("Invalid number: '" + number + "'. Must be non-empty and contain only uppercase letters and numbers.");
            }
            if (type == null) {
                errors.add("Room type cannot be null.");
            }
            if (capacity <= 0) {
                errors.add("Invalid capacity: " + capacity + ". Must be greater than zero.");
            }
            if (features == null || features.isEmpty()) {
                errors.add("Room features cannot be null or empty.");
            }
            return errors;
        }
    }

    /**
     * Returns a string containing information about the room, including its number, type, capacity, features, and reservations.
     *
     * @return a string representation of the room
     */
    @Override
    public String toString() {
        String room = "HotelRoom{" +
                "roomNumber=" + this.number +
                ", roomType='" + this.type + '\'' +
                ", capacity=" + this.capacity +
                ", features='" + this.features;
        if (this.reservations != null) {
            room += "'\\'', reservations=" + this.reservations + '}';
            return room;
        }
        return room + '}';
    }

    /**
     * Compares this HotelRoom object to another object for equality.
     *
     * @param o the object to compare to
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoom hotelRoom = (HotelRoom) o;
        return this.number.equals(hotelRoom.number);
    }

    /**
     * Returns a hash code value for the HotelRoom.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int result = this.type.hashCode();
        result += this.number.hashCode();
        return result;
    }

    @Override
    public int compareTo(HotelRoom other) {
        return this.number.compareTo(other.number);
    }
}
