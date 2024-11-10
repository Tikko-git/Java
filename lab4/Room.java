package lab4;

import java.util.List;
import java.util.regex.Pattern;

public class Room {
    private int id;
    private String name;
    private int capacity;
    private List<RoomCharacteristics> features;

    // Білдер для Room
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
        private int id;
        private String name;
        private int capacity;
        private List<RoomCharacteristics> features;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder features(List<RoomCharacteristics> features) {
            this.features = features;
            return this;
        }

        public Room build() {
            StringBuilder errors = new StringBuilder();

            if (id < 0) {
                errors.append("id має бути >= 0. ");
            }
            if (name == null || !NAME_PATTERN.matcher(name).matches()) {
                errors.append("Назва кімнати має бути алфавітно-цифровою. ");
            }
            if (capacity <= 0) {
                errors.append("Місткість має бути > 0. ");
            }
            if (features == null || features.isEmpty()) {
                errors.append("Кімната повинна мати принаймні одну характеристику. ");
            }

            if (!errors.isEmpty()) {
                throw new IllegalArgumentException(errors.toString());
            }

            return new Room(id, name, capacity, features);
        }
    }

    private Room(int id, String name, int capacity, List<RoomCharacteristics> features) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.features = features;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", features=" + features +
                '}';
    }
}
