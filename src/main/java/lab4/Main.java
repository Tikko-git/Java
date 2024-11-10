package lab4;

import lab1.HotelRoom;
import lab1.RoomСharacteristics;
import lab1.RoomType;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void  main(String[] args) {
        HotelRoom room101 = new HotelRoom.Builder()
                .setNumber("A101")
                .setType(RoomType.STANDART)
                .setCapacity(2)
                .setFeatures(Arrays.asList(RoomСharacteristics.SEA_VIEW, RoomСharacteristics.SINGLE_BED, RoomСharacteristics.MINI_BAR))
                .setReservations(List.of())
                .build();

        HotelRoom room102 = new HotelRoom.Builder()
                .setNumber("A102")
                .setType(RoomType.LUXURY)
                .setCapacity(4)
                .setFeatures(Arrays.asList(RoomСharacteristics.CITY_VIEW, RoomСharacteristics.DOUBLE_BED, RoomСharacteristics.KITCHENETTE))
                .setReservations(List.of())
                .build();
    }
}
