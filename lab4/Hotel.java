package lab4;

import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private int rating;
    private List<Room> rooms;

    // Білдер для Hotel
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private String name;
        private int rating;
        private List<Room> rooms;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder rating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder rooms(List<Room> rooms) {
            this.rooms = rooms;
            return this;
        }

        public Hotel build() {
            // Додаємо валідацію тут
            StringBuilder errors = new StringBuilder();

            if (id < 0) {
                errors.append("id має бути >= 0. ");
            }
            if (name == null || name.isEmpty()) {
                errors.append("Назва готелю не може бути порожньою. ");
            }
            if (rating < 1 || rating > 5) {
                errors.append("Рейтинг має бути від 1 до 5. ");
            }
            if (!errors.isEmpty()) {
                throw new IllegalArgumentException(errors.toString());
            }

            return new Hotel(id, name, rating, rooms);
        }
    }

    private Hotel(int id, String name, int rating, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", rooms=" + rooms +
                '}';
    }
}
