package lab2.comparator;

import lab2.Room;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class RoomComparator {

    private static final Map<String, Integer> roomTypeOrder;

    static {
        roomTypeOrder = new HashMap<>();
        roomTypeOrder.put("Standart", 1);
        roomTypeOrder.put("Medium", 2);
        roomTypeOrder.put("Luxury", 3);
        roomTypeOrder.put("Premium", 4);
    }

    public static Comparator<Room> byType() {
        return Comparator.comparingInt(room -> roomTypeOrder.getOrDefault(room.getType(), 0));
    }

    public static Comparator<Room> byNumberOfBeds() {
        return Comparator.comparingInt(Room::getNumberOfBeds);
    }

}