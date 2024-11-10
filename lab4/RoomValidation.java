package lab4;

import java.util.List;

public class RoomValidation {

    public static void validateFeatures(List<RoomCharacteristics> features) {
        if (features == null || features.isEmpty()) {
            throw new IllegalArgumentException("Features list cannot be null or empty.");
        }

        for (RoomCharacteristics feature : features) {
            if (feature == null) {
                throw new IllegalArgumentException("Feature cannot be null.");
            }
        }
    }
}
