package lab2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room.RoomBuilder()
                .setType("Standart")
                .setNumberOfBeds(2)
                .setRoomNumber(101)
                .setAmenities("Kitchen, TV, Mini-bar")
                .build();

        Resident resident1 = new Resident("Depp", "Johnny", 123456, LocalDate.of(1990, 5, 15));
        Resident resident2 = new Resident("Depp", "Johnny", 1234056, LocalDate.of(1990, 5, 15));

        Booking booking1 = new Booking(room1, resident1, LocalDate.of(2024,9,27), LocalDate.of(2024,9,30), true);

        System.out.println(booking1);
        System.out.println(resident1.equals(resident2));
    }
}
