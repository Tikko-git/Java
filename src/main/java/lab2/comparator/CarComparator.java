package lab2.comparator;

import lab2.Car;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CarComparator {

    private static final Map<String, Integer> carTypeOrder;

    static {
        carTypeOrder = new HashMap<>();
        carTypeOrder.put("Economy", 1);
        carTypeOrder.put("Compact", 2);
        carTypeOrder.put("Intermediate", 3);
        carTypeOrder.put("Luxury", 4);
    }

    public static Comparator<Car> byType() {
        return Comparator.comparingInt(car -> carTypeOrder.getOrDefault(car.getType(), 0));
    }

    public static Comparator<Car> byPrice() {
        return Comparator.comparingDouble(Car::getDailyPrice);
    }
}
