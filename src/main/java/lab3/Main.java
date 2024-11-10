package lab3;

import lab1.*;
import lab1.Resident;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//
//        Resident resident1 = new Resident("Johnny", "Depp", "1", LocalDate.of(1980, 5, 15));
//        Resident resident2 = new Resident("Angelina", "Jolie", "2", LocalDate.of(1984, 10, 20));
//
//        HotelRoom room101 = new HotelRoom.Builder()
//                .setNumber("101")
//                .setType(RoomType.STANDART)
//                .setCapacity(2)
//                .setFeatures(Arrays.asList(RoomСharacteristics.SEA_VIEW , RoomСharacteristics.SINGLE_BED, RoomСharacteristics.MINI_BAR))
//                .setReservations(List.of())
//                .build();
//
//        HotelRoom room102 = new HotelRoom.Builder()
//                .setNumber("102")
//                .setType(RoomType.LUXURY)
//                .setCapacity(4)
//                .setFeatures(Arrays.asList(RoomСharacteristics.CITY_VIEW, RoomСharacteristics.DOUBLE_BED, RoomСharacteristics.BALCONY))
//                .setReservations(List.of())
//                .build();
//
//        Reservation reservation1 = new Reservation(
//                room101.getNumber(),
//                resident1,
//                LocalDate.of(2024, 1, 10),
//                LocalDate.of(2024, 1, 15),
//                StatusOfPayment.PAID
//        );
//
//        Reservation reservation2 = new Reservation(
//                room102.getNumber(),
//                resident2,
//                LocalDate.of(2024, 2, 5),
//                LocalDate.of(2024, 2, 10),
//                StatusOfPayment.PAID
//        );
//
//        room101.setReservations(Arrays.asList(reservation1));
//        room102.setReservations(Arrays.asList(reservation2));
//
//        List<HotelRoom> roomList = new ArrayList<>();
//        roomList.add(room101);
//        roomList.add(room102);
//
//        Hotel hotel = new Hotel("Sealife Hotel", roomList);
//
//        // JSON
//        Serializer<Hotel> jsonSerializer = new JsonSerializer<>();
//        String jsonData = jsonSerializer.serialize(hotel);
//        System.out.println("JSON: " + jsonData);
//
//        jsonSerializer.writeToFile(hotel, new File("hotel.json"));
//        Hotel hotelFromJson = jsonSerializer.readFromFile(new File("hotel.json"), Hotel.class);
//        System.out.println("Deserialized from JSON: " + hotelFromJson);
//
//        // XML
//        Serializer<Hotel> xmlSerializer = new XmlSerializer<>();
//        String xmlData = xmlSerializer.serialize(hotel);
//        System.out.println("XML: " + xmlData);
//
//        xmlSerializer.writeToFile(hotel, new File("hotel.xml"));
//        Hotel hotelFromXml = xmlSerializer.readFromFile(new File("hotel.xml"), Hotel.class);
//        System.out.println("Deserialized from XML: " + hotelFromXml);

//        Serializer<Hotel> xmlSerializer = new XmlSerializer<>();
//        Hotel hotelFromXml = xmlSerializer.readFromFile(new File("hotel.xml"), Hotel.class);
//        System.out.println("Deserialized from XML: " + hotelFromXml);
//
//        // YAML
//        Serializer<Hotel> yamlSerializer = new YamlSerializer<>();
//        String yamlData = yamlSerializer.serialize(hotel);
//        System.out.println("YAML: " + yamlData);
//
//        yamlSerializer.writeToFile(hotel, new File("hotel.yaml"));
//        Hotel hotelFromYaml = yamlSerializer.readFromFile(new File("hotel.yaml"), Hotel.class);
//        System.out.println("Deserialized from YAML: " + hotelFromYaml);

    }
}
