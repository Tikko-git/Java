package lab2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.time.LocalDate;

public class BookingTest {

    @DataProvider(name = "rentalDataToString")
    public Object[][] rentalDataToString() {
        return new Object[][] {
                {
                        new Booking( new Room.RoomBuilder()
                                .setType("Medium")
                                .setNumberOfBeds(2)
                                .setRoomNumber(101)
                                .setAmenities("Balcony, Air Conditioning")
                                .build(),
                                new Resident("Doe", "John", 12345, LocalDate.of(1990, 1, 1)) ,
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 1, 10),
                                true),
                        "Booking{room=Room{type='Medium', numberOfBeds=2, roomNumber=101, amenities='Balcony, Air Conditioning'}, resident=Resident{lastName='Doe', firstName='John', documentId='12345', birthDate='1990-01-01'}, startDate='2024-01-01', endDate='2024-01-10', Paid=true}"
                }
        };
    }

    @Test(dataProvider = "rentalDataToString")
    public void testToString(Booking rental, String expected) {
        assertEquals(rental.toString(), expected);
    }

    @DataProvider(name = "rentalData")
    public Object[][] rentalData() {
        return new Object[][] {
                {
                        new Booking( new Room.RoomBuilder()
                                .setType("Medium")
                                .setNumberOfBeds(2)
                                .setRoomNumber(101)
                                .setAmenities("Kitchen, Air Conditioning")
                                .build(),
                                new Resident("Doe", "John", 12345, LocalDate.of(1990, 1, 1)) ,
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 1, 10),
                                true),
                        new Booking( new Room.RoomBuilder()
                                .setType("Medium")
                                .setNumberOfBeds(2)
                                .setRoomNumber(102)
                                .setAmenities("Kitchen, Air Conditioning")
                                .build(),
                                new Resident("Doe", "Jane", 12345, LocalDate.of(1990, 1, 1)) ,
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 12, 10),
                                true),
                        false
                },
                {
                        new Booking( new Room.RoomBuilder()
                                .setType("Medium")
                                .setNumberOfBeds(2)
                                .setRoomNumber(101)
                                .setAmenities("Kitchen, Air Conditioning")
                                .build(),
                                new Resident("Doe", "John", 12345, LocalDate.of(1990, 1, 1)) ,
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 1, 10),
                                true),
                        new Booking( new Room.RoomBuilder()
                                .setType("Medium")
                                .setNumberOfBeds(2)
                                .setRoomNumber(101)
                                .setAmenities("Kitchen, Air Conditioning")
                                .build(),
                                new Resident("Doe", "John", 12345, LocalDate.of(1990, 1, 1)) ,
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 1, 10),
                                true),
                        true
                }
        };
    }

    @Test(dataProvider = "rentalData")
    public void testequals(Booking booking1, Booking booking2, boolean expected){
        assertEquals(booking1.equals(booking2), expected);
    }

    @Test(dataProvider = "rentalData")
    public void testhash(Booking booking1,Booking booking2, boolean expected){
        if (expected) {
            assertEquals(booking1.hashCode(), booking2.hashCode());
        } else {
            assertNotEquals(booking1.hashCode(), booking2.hashCode());
        }
    }



}
