package lab3;

import lab1.Car;
import lab1.Rental;
import lab1.Renter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        Renter renter1 = new Renter("Doe", "John", "ID12345", "DL54321");
        Renter renter2 = new Renter("Smith", "Jane", "ID67890", "DL09876");

        Car car1 = new Car.Builder()
                .setBrand("Toyota")
                .setVin("VIN123456")
                .setPlateNumber("AB123CD")
                .setYearOfManufacture(2015)
                .setMileage(50000)
                .setDailyPrice(45.0)
                .build();

        Car car2 = new Car.Builder()
                .setBrand("Honda")
                .setVin("VIN789012")
                .setPlateNumber("EF456GH")
                .setYearOfManufacture(2018)
                .setMileage(30000)
                .setDailyPrice(55.0)
                .build();

        Rental rental1 = new Rental(
                car1, renter1, "Kyiv", "Lviv", LocalDate.of(2024, 3, 1),
                LocalDate.of(2024, 3, 5), car1.getDailyPrice());

        Rental rental2 = new Rental(
                car2, renter2, "Odesa", "Kharkiv", LocalDate.of(2024, 4, 1),
                LocalDate.of(2024, 4, 7), car2.getDailyPrice());

        // JSON
        Serializer<Rental> jsonSerializer = new JSONSerializer<>();
        String jsonData = jsonSerializer.serialize(rental1);
        System.out.println("JSON: " + jsonData);

        jsonSerializer.writeToFile(rental1, new File("rental.json"));
        Rental rentalFromJson = jsonSerializer.readFromFile(new File("rental.json"), Rental.class);
        System.out.println("Deserialized from JSON: " + rentalFromJson);

        // XML
        Serializer<Rental> xmlSerializer = new XMLSerializer<>();
        String xmlData = xmlSerializer.serialize(rental1);
        System.out.println("XML: " + xmlData);

        xmlSerializer.writeToFile(rental1, new File("rental.xml"));
        Rental rentalFromXml = xmlSerializer.readFromFile(new File("rental.xml"), Rental.class);
        System.out.println("Deserialized from XML: " + rentalFromXml);

        // YAML
        Serializer<Rental> yamlSerializer = new YMLSerializer<>();
        String yamlData = yamlSerializer.serialize(rental1);
        System.out.println("YAML: " + yamlData);

        yamlSerializer.writeToFile(rental1, new File("rental.yaml"));
        Rental rentalFromYaml = yamlSerializer.readFromFile(new File("rental.yaml"), Rental.class);
        System.out.println("Deserialized from YAML: " + rentalFromYaml);
    }
}
