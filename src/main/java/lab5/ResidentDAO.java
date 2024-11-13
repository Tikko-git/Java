package lab5;

import lab1.Resident;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResidentDAO extends DataSource<Resident> {

    public ResidentDAO() {}

    public List<Resident> getAll() {
        try (var connection = getConnection();
             var statement = connection.createStatement();
             var ResidentDAO = statement.executeQuery("SELECT * FROM resident")) {

            List<Resident> residents = new ArrayList<>();
            while (ResidentDAO.next()) {
                Resident resident = new Resident(
                        ResidentDAO.getInt("id"),
                        ResidentDAO.getString("first_name"),
                        ResidentDAO.getString("last_name"),
                        ResidentDAO.getString("passport_id"),
                        LocalDate.parse(ResidentDAO.getString("date_of_birth"))
                );
                residents.add(resident);
            }
            return residents;
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public  Resident getOne(int id) {
        try (var connection = getConnection();
             var statement = connection.createStatement();
             var ResidentDAO = statement.executeQuery(
                     "SELECT * FROM resident WHERE id = " + id)) {

            if (ResidentDAO.next()) {
                return new Resident(
                        ResidentDAO.getInt("id"),
                        ResidentDAO.getString("first_name"),
                        ResidentDAO.getString("last_name"),
                        ResidentDAO.getString("passport_id"),
                        LocalDate.parse(ResidentDAO.getString("date_of_birth"))
                );
            } else {
                return null;
            }
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void insert(Resident resident) {
        try (var connection = getConnection();
             var insert = connection.prepareStatement(
                     "INSERT INTO resident(first_name, last_name, passport_id, date_of_birth) VALUES(?,?,?,?)")) {

            insert.setString(1, resident.getFirstName());
            insert.setString(2, resident.getLastName());
            insert.setString(3, resident.getPassportId());
            insert.setString(4, resident.getDateOfBirth().toString());
            insert.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void update(Resident resident) {
        try (var connection = getConnection();
             var update = connection.prepareStatement(
                     "UPDATE resident SET first_name = ?, last_name = ?, passport_id = ?, date_of_birth = ? WHERE id = ?")) {

            update.setString(1, resident.getFirstName());
            update.setString(2, resident.getLastName());
            update.setString(3, resident.getPassportId());
            update.setString(4, resident.getDateOfBirth().toString());
            update.setInt(5, resident.getId());
            update.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void delete(int id) {
        try (var connection = getConnection();
             var statement = connection.prepareStatement("DELETE FROM resident WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }


    }
}

