package lab1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HotelManagementTest {

    private Resident resident;
    private HotelRoom hotelRoom;
    private Hotel hotel;
    private Reservation reservation;

    @BeforeMethod
    public void setUp() {
        resident = new Resident("Johnny", "Depp", "AA123456", LocalDate.of(1990, 1, 1));

        hotelRoom = new HotelRoom.Builder()
                .setNumber("101")
                .setType(RoomType.LUXURY)
                .setCapacity(1)
                .setFeatures(List.of(RoomСharacteristics.AIR_CONDITIONING, RoomСharacteristics.SEA_VIEW))
                .setReservations(List.of())
                .build();

        hotel = new Hotel("Pearl of the sea", List.of(hotelRoom));

        reservation = new Reservation("101", resident, LocalDate.now(), LocalDate.now().plusDays(2), StatusOfPayment.PAID);
    }

    @Test
    public void testClient() {
        assertEquals(resident.getFirstName(), "Johnny");
        assertEquals(resident.getLastName(), "Depp");
        assertEquals(resident.getPassportId(), "AA123456");
        assertEquals(resident.getDateOfBirth(), LocalDate.of(1990, 1, 1));

        String expectedToString = "Client{firstName='Johnny', lastName='Depp', passportId=AA123456, dateOfBirth=1990-01-01}";
        assertEquals(resident.toString(), expectedToString);

        Resident otherResident = new Resident("Johnny", "Depp", "AA123456", LocalDate.of(1990, 1, 1));
        assertEquals(resident, otherResident);
        assertEquals(resident.hashCode(), otherResident.hashCode());
    }

    @Test
    public void testHotelRoom() {
        assertEquals(hotelRoom.getNumber(), "101");
        assertEquals(hotelRoom.getType(), RoomType.LUXURY);
        assertEquals(hotelRoom.getCapacity(), 1);
        assertTrue(hotelRoom.getFeatures().contains(RoomСharacteristics.AIR_CONDITIONING));
        assertTrue(hotelRoom.getFeatures().contains(RoomСharacteristics.SEA_VIEW));

        HotelRoom anotherRoom = new HotelRoom.Builder()
                .setNumber("101")
                .setType(RoomType.LUXURY)
                .setCapacity(1)
                .setFeatures(List.of(RoomСharacteristics.AIR_CONDITIONING, RoomСharacteristics.SEA_VIEW))
                .build();
        assertEquals(hotelRoom, anotherRoom);
        assertEquals(hotelRoom.hashCode(), anotherRoom.hashCode());
    }

    @Test
    public void testHotel() {
        assertEquals(hotel.getName(), "Pearl of the sea");
        assertEquals(hotel.getRooms().size(), 1);
        assertEquals(hotel.getRooms().get(0), hotelRoom);

        String expectedToString = "Hotel{hotelRooms=[HotelRoom{roomNumber=101, roomType='LUXURY', capacity=1, features='[AIR_CONDITIONING, SEA_VIEW]', reservations=[]}]}";
        assertEquals(hotel.toString(), expectedToString);

        Hotel otherHotel = new Hotel("Pearl of the sea", List.of(hotelRoom));
        assertEquals(hotel, otherHotel);
        assertEquals(hotel.hashCode(), otherHotel.hashCode());
    }

    @Test
    public void testReservation() {
        assertEquals(reservation.getRoomNumber(), "101");
        assertEquals(reservation.getResident(), resident);
        assertEquals(reservation.getEnterDate(), LocalDate.now());
        assertEquals(reservation.getDepartureDate(), LocalDate.now().plusDays(2));
        assertEquals(reservation.getPayment(), StatusOfPayment.PAID);

        String expectedToString = "Reservation{room=101, resident=" + resident.toString() +
                ", enterDate=" + LocalDate.now() + ", departureDate=" + LocalDate.now().plusDays(2) +
                ", paymentStatus=PAID}";
        assertEquals(reservation.toString(), expectedToString);

        Reservation otherReservation = new Reservation("101", resident, LocalDate.now(), LocalDate.now().plusDays(2), StatusOfPayment.PAID);
        assertEquals(reservation, otherReservation);
        assertEquals(reservation.hashCode(), otherReservation.hashCode());
    }
}
