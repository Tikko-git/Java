package lab2;

import lab2.Car;
import lab2.service.CarRentalService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CarRentalServiceTest {

    private CarRentalService carRentalService;

    @BeforeMethod
    public void setUp() {
        List<Car> cars = Arrays.asList(
                Car.builder().type("Economy").brand("Toyota").dailyPrice(50.0).features("Air conditioning").build(),
                Car.builder().type("Luxury").brand("BMW").dailyPrice(150.0).features("Leather seats, Sunroof").build(),
                Car.builder().type("Compact").brand("Honda").dailyPrice(60.0).features("Bluetooth").build()
        );
        carRentalService = new CarRentalService(cars);
    }

    @Test
    public void testSortCarsByPrice() {
        List<Car> sortedCars = carRentalService.sortCarsByPrice();
        assertEquals(50.0, sortedCars.get(0).getDailyPrice());
        assertEquals(60.0, sortedCars.get(1).getDailyPrice());
        assertEquals(150.0, sortedCars.get(2).getDailyPrice());
    }

    @Test
    public void testGetTotalRentalCost() {
        double totalCost = carRentalService.getTotalRentalCost(3); // 3 дні оренди
        assertEquals(780.0, totalCost);
    }

    @Test
    public void testFindCarsByType() {
        List<Car> luxuryCars = carRentalService.findCarsByType("Luxury");
        assertEquals(1, luxuryCars.size());
        assertEquals("BMW", luxuryCars.get(0).getBrand());
    }
}