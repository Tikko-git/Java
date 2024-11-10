package lab1;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a hotel consisting of an array of rooms.
 * Provides methods for creating and managing a hotel,
 * as well as comparing hotels and generating hotel information.
 */
public class Hotel {
    private String name;
    private List<HotelRoom> rooms;

    public Hotel() {
    }

    /**
     * Constructs a Hotel object with the specified array of hotel rooms.
     *
     * @param hotelRooms an array of {@code HotelRoom} objects representing the rooms in the hotel
     */
    public Hotel(String name, List<HotelRoom> hotelRooms) {
        this.name = name;
        this.rooms = hotelRooms;
    }

    public String getName() {
        return name;
    }

    public List<HotelRoom> getRooms() {
        return rooms;
    }

    /**
     * Returns a string representation of the hotel, including information about all rooms.
     *
     * @return a string containing the information of all the rooms in the hotel
     */
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelRooms=" + Arrays.toString(rooms.toArray()) +
                '}';
    }

    /**
     * Compares this hotel to the specified object.
     *
     * @param o the object to compare this hotel against
     * @return {@code true} if the object is equal to this hotel, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Arrays.equals(rooms.toArray(), hotel.rooms.toArray());
    }

    /**
     * Returns a hash code value for the hotel.
     *
     * @return a hash code value for this hotel
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(rooms.toArray());
    }
}
