package lab4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Room room = Room.builder()
                    .id(-1)
                    .name("Invalid#Name")
                    .capacity(0)
                    .features(List.of(RoomCharacteristics.BALCONY)) // Без null
                    .build();
            System.out.println(room);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка створення Room: " + e.getMessage());
        }

        try {
            Hotel hotel = Hotel.builder()
                    .id(-5)
                    .name("")
                    .rating(10)
                    .rooms(List.of())
                    .build();
            System.out.println(hotel);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка створення Hotel: " + e.getMessage());
        }
    }
}
