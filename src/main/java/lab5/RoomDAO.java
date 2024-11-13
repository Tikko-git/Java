package lab5;

import lab1.HotelRoom;
import lab1.RoomType;
import lab1.RoomCharacteristics;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomDAO extends DataSource<HotelRoom> {

    public RoomDAO() {}

    @Override
    public List<HotelRoom> getAll() {
        String query = "SELECT * FROM room";
        List<HotelRoom> rooms = new ArrayList<>();

        try (var connection = getConnection();
             var statement = connection.createStatement();
             var resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String featuresString = resultSet.getString("features");
                List<RoomCharacteristics> features = parseFeatures(featuresString);

                HotelRoom room = new HotelRoom.Builder()
                        .setId(resultSet.getInt("id"))
                        .setHotelId(resultSet.getInt("hotel_id"))
                        .setNumber(resultSet.getString("number"))
                        .setCapacity(resultSet.getInt("capacity"))
                        .setFeatures(features)
                        .setType(RoomType.fromString(resultSet.getString("type")))
                        .build();
                rooms.add(room);
            }
        } catch (SQLException error) {
            throw new RuntimeException("Error fetching all rooms: " + error.getMessage(), error);
        }

        return rooms;
    }

    @Override
    public HotelRoom getOne(int id) {
        String query = "SELECT * FROM room WHERE id = ?";
        try (var connection = getConnection();
             var statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            try (var resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String featuresString = resultSet.getString("features");
                    List<RoomCharacteristics> features = parseFeatures(featuresString);

                    return new HotelRoom.Builder()
                            .setId(resultSet.getInt("id"))
                            .setHotelId(resultSet.getInt("hotel_id"))
                            .setNumber(resultSet.getString("number"))
                            .setCapacity(resultSet.getInt("capacity"))
                            .setFeatures(features)
                            .setType(RoomType.fromString(resultSet.getString("type")))
                            .build();
                } else {
                    throw new RuntimeException("Room with id " + id + " not found.");
                }
            }
        } catch (SQLException error) {
            throw new RuntimeException("Error fetching room by id: " + error.getMessage(), error);
        }
    }

    @Override
    public void insert(HotelRoom room) {
        String query = "INSERT INTO room(hotel_id, number, type, capacity, features) VALUES (?, ?, ?, ?, ?)";

        try (var connection = getConnection();
             var statement = connection.prepareStatement(query)) {

            statement.setInt(1, room.getHotelId());
            statement.setString(2, room.getNumber());
            statement.setString(3, room.getType().toString());
            statement.setInt(4, room.getCapacity());
            statement.setString(5, room.getFeaturesString());
            statement.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException("Error inserting room: " + error.getMessage(), error);
        }
    }

    @Override
    public void update(HotelRoom room) {
        String query = "UPDATE room SET number = ?, type = ?, capacity = ?, features = ? WHERE id = ?";

        try (var connection = getConnection();
             var statement = connection.prepareStatement(query)) {

            statement.setString(1, room.getNumber());
            statement.setString(2, room.getType().toString());
            statement.setInt(3, room.getCapacity());
            statement.setString(4, room.getFeaturesString());
            statement.setInt(5, room.getId());
            statement.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException("Error updating room: " + error.getMessage(), error);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM room WHERE id = ?";

        try (var connection = getConnection();
             var statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException("Error deleting room: " + error.getMessage(), error);
        }
    }

    public void deleteByNumber(String number) {
        String query = "DELETE FROM room WHERE number = ?";

        try (var connection = getConnection();
             var statement = connection.prepareStatement(query)) {

            statement.setString(1, number);
            statement.executeUpdate();

            System.out.println("Deleted room with number: " + number);

        } catch (SQLException error) {
            throw new RuntimeException("Error deleting room by number: " + error.getMessage(), error);
        }
    }


    // Метод для парсингу характеристики з рядка
    private List<RoomCharacteristics> parseFeatures(String featuresString) {
        if (featuresString == null || featuresString.isEmpty()) {
            return new ArrayList<>();
        }

        String[] featuresArray = featuresString.split(",");  // розділяємо за комою
        List<RoomCharacteristics> features = new ArrayList<>();
        for (String feature : featuresArray) {
            try {
                features.add(RoomCharacteristics.valueOf(feature.trim()));  // додаємо кожну характеристику
            } catch (IllegalArgumentException e) {
                // Якщо характеристика недійсна, її можна ігнорувати або обробити
                System.err.println("Invalid feature: " + feature);
            }
        }
        return features;
    }

    public static void main(String[] args) {
        RoomDAO roomDAO = new RoomDAO();

        // Fetch all rooms
        List<HotelRoom> rooms = roomDAO.getAll();
        rooms.forEach(System.out::println);

        // Fetch a single room by id
        try {
            HotelRoom room = roomDAO.getOne(1);
            System.out.println("Fetched room: " + room);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        // Insert a new room
        HotelRoom newRoom = new HotelRoom.Builder()
                .setHotelId(1)
                .setNumber("207")
                .setType(RoomType.STANDART)
                .setCapacity(2)
                .setFeatures(Arrays.asList(RoomCharacteristics.SEA_VIEW , RoomCharacteristics.MINI_BAR))
                .build();
        roomDAO.insert(newRoom);
        System.out.println("Inserted new room: " + newRoom);

        // Update an existing room
        newRoom.setCapacity(3);
        roomDAO.update(newRoom);
        System.out.println("Updated room: " + newRoom);

        // Delete a room by id
        roomDAO.delete(newRoom.getId());
        System.out.println("Deleted room with id: " + newRoom.getId());
    }
}
