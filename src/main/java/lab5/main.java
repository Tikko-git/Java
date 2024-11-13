package lab5;

import lab1.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class main {

    public static void main(String[] args) {
        // Створення екземплярів DAO класів
        RoomDAO roomDAO = new RoomDAO();
        ResidentDAO residentDAO = new ResidentDAO();
        ReservationDAO reservationDAO = new ReservationDAO();

        // ---------------------------
        // Перевірка RoomDAO
        // ---------------------------
        System.out.println("=== RoomDAO Operations ===");

        // Отримати всі номери
        List<HotelRoom> rooms = roomDAO.getAll();
        if (rooms.isEmpty()) {
            System.out.println("No rooms found.");
        } else {
            rooms.forEach(System.out::println);
        }

        // Отримати номер за ID
        HotelRoom room = roomDAO.getOne(1);
        System.out.println("Fetched room: " + room);

        // Вставити новий номер
        HotelRoom newRoom = new HotelRoom.Builder()
                .setHotelId(1)
                .setNumber("203")
                .setType(RoomType.STANDART)
                .setCapacity(2)
                .setFeatures(Arrays.asList(RoomCharacteristics.SEA_VIEW , RoomCharacteristics.MINI_BAR))
                .build();
        roomDAO.insert(newRoom);
        System.out.println("Inserted new room: " + newRoom);

        // Оновити номер
        newRoom.setCapacity(3);
        roomDAO.update(newRoom);
        System.out.println("Updated room: " + newRoom);

        // Видалити номер
        roomDAO.delete(newRoom.getId());
        System.out.println("Deleted room with ID: " + newRoom.getId());

        // Видалення кімнати за номером
        String roomNumber = "309";
        roomDAO.deleteByNumber(roomNumber);

        // ---------------------------
        // Перевірка ResidentDAO
        // ---------------------------
        System.out.println("\n=== ResidentDAO Operations ===");

        // Отримати всіх резидентів
        List<Resident> residents = residentDAO.getAll();
        if (residents.isEmpty()) {
            System.out.println("No residents found.");
        } else {
            residents.forEach(System.out::println);
        }

        // Отримати резидента за ID
        Resident resident = residentDAO.getOne(1);
        System.out.println("Fetched resident: " + resident);

        Resident newResident = new Resident(0, "Michael", "Johnson", "LM345678", LocalDate.of(1982, 11, 30));
        residentDAO.insert(newResident);

        System.out.println("Inserted new resident: " + newResident);

        // Оновити резидента
        newResident.setLastName("Jackson");
        residentDAO.update(newResident);
        System.out.println("Updated resident: " + newResident);

        // Видалити резидента
        residentDAO.delete(newResident.getId());
        System.out.println("Deleted resident with ID: " + newResident.getId());

        // ---------------------------
        // Перевірка ReservationDAO
        // ---------------------------
        System.out.println("\n=== ReservationDAO Operations ===");

        // Отримати всі резервації
        List<Reservation> reservations = reservationDAO.getAll();
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            reservations.forEach(System.out::println);
        }

        // Отримати резервацію за ID
        Reservation reservation = reservationDAO.getOne(1);
        System.out.println("Fetched reservation: " + reservation);

        // Вставити нову резервацію
        HotelRoom reservedRoom = roomDAO.getOne(1); // Використовуємо екземпляр roomDAO
        Resident residentForReservation = residentDAO.getOne(1); // Використовуємо екземпляр residentDAO
        Reservation newReservation = new Reservation(0, reservedRoom, residentForReservation, LocalDate.now(), LocalDate.now().plusDays(3), StatusOfPayment.PAID);
        reservationDAO.insert(newReservation);
        System.out.println("Inserted new reservation: " + newReservation);

        // Оновити резервацію
        newReservation.setPayment(StatusOfPayment.UNPAID);
        reservationDAO.update(newReservation);
        System.out.println("Updated reservation: " + newReservation);

        // Видалити резервацію
        reservationDAO.delete(newReservation.getId());
        System.out.println("Deleted reservation with ID: " + newReservation.getId());
    }
}
