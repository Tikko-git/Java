package lab2.service;

import lab2.Car;
import lab2.comparator.CarComparator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class CarRentalService {
    private List<Car> cars;

    // Method to sort cars by price
    public List<Car> sortCarsByPrice() {
        return cars.stream()
                .sorted(CarComparator.byPrice())
                .collect(Collectors.toList());
    }

    // Method to get total rental cost for a given number of days
    public double getTotalRentalCost(int days) {
        return cars.stream()
                .mapToDouble(car -> car.getDailyPrice() * days)
                .sum();
    }

    // Method to find cars by type
    public List<Car> findCarsByType(String type) {
        return cars.stream()
                .filter(car -> car.getType().equalsIgnoreCase(type))
                .sorted(CarComparator.byType())
                .collect(Collectors.toList());
    }
}
