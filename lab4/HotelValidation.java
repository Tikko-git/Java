package lab4;

public class HotelValidation {

    /**
     * Перевіряє назву готелю.
     * Назва має бути не порожньою.
     */
    public static void validateHotelName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Hotel name cannot be null or empty.");
        }
    }
}
