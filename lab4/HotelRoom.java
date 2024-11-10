package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HotelRoom {
    private String number;
    private RoomType type;
    private int capacity;
    private List<RoomCharacteristics> features;

    private HotelRoom(String number, RoomType type, int capacity, List<RoomCharacteristics> features) {
        this.number = number;
        this.type = type;
        this.capacity = capacity;
        this.features = features;
    }

    public String getNumber() {
        return number;
    }

    public RoomType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<RoomCharacteristics> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "number='" + number + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                ", features=" + features +
                '}';
    }

    // Вбудований білдер
    public static class Builder {
        private static final Pattern ROOM_NUMBER_PATTERN = Pattern.compile("^[0-9]{3}[A-Z]?$");
        private String number;
        private RoomType type;
        private int capacity;
        private List<RoomCharacteristics> features;

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder setType(RoomType type) {
            this.type = type;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setFeatures(List<RoomCharacteristics> features) {
            this.features = features;
            return this;
        }

        public HotelRoom build() {
            List<String> errors = new ArrayList<>();

            // Валідація номера кімнати
            if (number == null || !ROOM_NUMBER_PATTERN.matcher(number).matches()) {
                errors.add("Invalid room number: " + number + " (must be 3 digits followed by an optional uppercase letter)");
            }

            // Валідація типу кімнати
            if (type == null) {
                errors.add("lab4.Room type cannot be null.");
            }

            // Валідація місткості
            if (capacity <= 0 || capacity > 10) {
                errors.add("Invalid capacity: " + capacity + " (must be between 1 and 10)");
            }

            // Перевірка наявності характеристик
            if (features == null || features.isEmpty()) {
                errors.add("lab4.Room must have at least one feature.");
            }

            // Якщо є помилки, кидаємо виняток
            if (!errors.isEmpty()) {
                throw new IllegalArgumentException("HotelRoom validation failed: " + String.join("; ", errors));
            }

            return new HotelRoom(number, type, capacity, features);
        }
    }
}
