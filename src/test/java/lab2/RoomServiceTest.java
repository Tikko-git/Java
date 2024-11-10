package lab2;

import lab2.comparator.RoomComparator;
import lab2.service.RoomService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RoomServiceTest {
    private RoomService roomService;

    @BeforeTest
    public void setUp() {
        roomService = new RoomService(Arrays.asList(
                new Room.RoomBuilder().setRoomNumber(101).setType("Standart").setNumberOfBeds(2).setAmenities("WiFi").build(),
                new Room.RoomBuilder().setRoomNumber(102).setType("Medium").setNumberOfBeds(1).setAmenities("WiFi").build(),
                new Room.RoomBuilder().setRoomNumber(103).setType("Luxury").setNumberOfBeds(3).setAmenities("WiFi").build()
        ));
    }

    // Test for findRoomsByType method
    @Test
    public void testFindRoomsByType() {
        String type = "Standart";
        int expectedCount = 1;
        List<Room> foundRooms = roomService.findRoomsByType(type);
        assertEquals(foundRooms.size(), expectedCount);
    }

    // Test for getTotalNumberOfBeds method
    @Test
    public void testGetTotalNumberOfBeds() {
        int expected = 6;
        int sum = roomService.getTotalNumberOfBeds();
        assertEquals(sum, expected);
    }

    // DataProvider for sortRoomsByType method
    @DataProvider(name = "sortByType")
    public Object[][] sortByType() {
        return new Object[][] {
                {
                        Arrays.asList(
                                new Room.RoomBuilder().setRoomNumber(101).setType("Standart").setNumberOfBeds(2).setAmenities("WiFi").build(),
                                new Room.RoomBuilder().setRoomNumber(102).setType("Premium").setNumberOfBeds(2).setAmenities("WiFi").build(),
                                new Room.RoomBuilder().setRoomNumber(103).setType("Luxury").setNumberOfBeds(1).setAmenities("WiFi").build()
                        ),
                        Arrays.asList(
                                new Room.RoomBuilder().setRoomNumber(101).setType("Standart").setNumberOfBeds(2).setAmenities("WiFi").build(),
                                new Room.RoomBuilder().setRoomNumber(103).setType("Luxury").setNumberOfBeds(1).setAmenities("WiFi").build(),
                                new Room.RoomBuilder().setRoomNumber(102).setType("Premium").setNumberOfBeds(2).setAmenities("WiFi").build()
                        )
                }
        };
    }

    // Test for sortRoomsByType method
    @Test(dataProvider = "sortByType")
    public void testSortRoomsByType(List<Room> rooms, List<Room> expectedSortedRooms) {
        List<Room> sortedRooms = rooms.stream()
                .sorted(RoomComparator.byType())
                .toList();
        assertEquals(sortedRooms, expectedSortedRooms);
    }

    // Test for sortRoomsByNumberOfBeds method
    @Test
    public void testSortRoomsByNumberOfBeds() {
        List<Room> expectedSortedRooms = Arrays.asList(
                new Room.RoomBuilder().setRoomNumber(102).setType("Medium").setNumberOfBeds(1).setAmenities("WiFi").build(),
                new Room.RoomBuilder().setRoomNumber(101).setType("Standart").setNumberOfBeds(2).setAmenities("WiFi").build(),
                new Room.RoomBuilder().setRoomNumber(103).setType("Luxury").setNumberOfBeds(3).setAmenities("WiFi").build()
        );
        List<Room> sortedRooms = roomService.getRooms().stream()
                .sorted(RoomComparator.byNumberOfBeds())
                .toList();
        assertEquals(sortedRooms, expectedSortedRooms);
    }
}
