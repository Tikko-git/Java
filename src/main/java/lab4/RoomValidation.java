package lab4;

import lab1.RoomType;
import lab1.RoomСharacteristics;
import java.util.List;

public class RoomValidation {

    public static void validateNumber(String number) {
        if (number == null || !number.matches("^[A-Z0-9]+$")) {
            throw new IllegalArgumentException("Room number must be non-empty and contain only uppercase letters and numbers.");
        }
    }

    public static void validateType(RoomType type) {
        if (type == null) {
            throw new IllegalArgumentException("Room type cannot be null.");
        }
    }

    public static void validateCapacity(int capacity) {
        if (capacity <= 0 || capacity > 10) {
            throw new IllegalArgumentException("Room capacity must be between 1 and 10.");
        }
    }

    public static void validateFeatures(List<RoomСharacteristics> features) {
        if (features == null || features.isEmpty()) {
            throw new IllegalArgumentException("Room features cannot be null or empty.");
        }
    }
}

