package lab5;

import lab1.Reservation;
import lab1.StatusOfPayment;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO extends DataSource<Reservation> {
    private final RoomDAO roomDAO;
    private final ResidentDAO residentDAO;

    public ReservationDAO() {
        roomDAO = new RoomDAO();
        residentDAO = new ResidentDAO();
    }

    public List<Reservation> getAll() {
        try (var connection = getConnection();
             var statement = connection.createStatement();
             var resultSet = statement.executeQuery("SELECT * FROM reservation")) {

            List<Reservation> reservations = new ArrayList<>();
            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getInt("id"),
                        roomDAO.getOne(resultSet.getInt("room_id")), // Використано екземпляр roomDAO
                        residentDAO.getOne(resultSet.getInt("client")), // Використано екземпляр residentDAO
                        LocalDate.parse(resultSet.getString("enter_date")),
                        LocalDate.parse(resultSet.getString("departure_date")),
                        StatusOfPayment.fromString(resultSet.getString("payment"))
                );
                reservations.add(reservation);
            }
            return reservations;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public Reservation getOne(int id) {
        try (var connection = getConnection();
             var statement = connection.createStatement();
             var resultSet = statement.executeQuery(
                     "SELECT * FROM reservation WHERE id = " + id)) {

            if (resultSet.next()) {
                return new Reservation(
                        resultSet.getInt("id"),
                        roomDAO.getOne(resultSet.getInt("room_id")),
                        residentDAO.getOne(resultSet.getInt("resident_id")),
                        LocalDate.parse(resultSet.getString("enter_date")),
                        LocalDate.parse(resultSet.getString("departure_date")),
                        StatusOfPayment.fromString(resultSet.getString("payment"))
                );
            } else {
                return null;
            }
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void insert(Reservation reservation) {
        try (var connection = getConnection();
             var insert = connection.prepareStatement(
                     "INSERT INTO reservation(room_id, resident_id, enter_date, departure_date, payment_status) VALUES(?,?,?,?,?)")) {

            insert.setInt(1, reservation.getRoomNumber().getId());
            insert.setInt(2, reservation.getResident().getId());
            insert.setString(3, reservation.getEnterDate().toString());
            insert.setString(4, reservation.getDepartureDate().toString());
            insert.setString(5, reservation.getPayment().toString());
            insert.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void update(Reservation reservation) {
        try (var connection = getConnection();
             var update = connection.prepareStatement(
                     "UPDATE reservation SET room_id = ?, resident_id = ?, enter_date = ?, departure_date = ?, payment_status = ? WHERE id = ?")) {

            update.setInt(1, reservation.getRoomNumber().getId());
            update.setInt(2, reservation.getResident().getId());
            update.setString(3, reservation.getEnterDate().toString());
            update.setString(4, reservation.getDepartureDate().toString());
            update.setString(5, reservation.getPayment().toString());
            update.setInt(6, reservation.getId());
            update.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void delete(int id) {
        try (var connection = getConnection();
             var statement = connection.prepareStatement("DELETE FROM reservation WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
}
