package lab0;

public class Variant1 {

    public enum DAY_OF_WEEK {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public int inputOutputTask(int k) {
        return 0;
    }

    /** Дана відстань L в сантиметрах. Використовуючи операцію ділення націло,
     *  знайти кількість повних метрів у ньому (1 метр 100 см).
     */
    public int integerNumbersTask(int l) {
        return l / 100;
    }

    /** Дано ціле число A. Перевірити істинність висловлювання: «Число A є позитивним».*/
    public boolean booleanTask(int a) {
        return a > 0;
    }

    /** Дано ціле число. Якщо воно є позитивним, то додати до нього 1;
     * в іншому випадку не змінювати його. Вивести отримане число.
     */
    public int ifTask(int parameter) {
        if (parameter > 0) {
            return parameter + 1;
        }
        return parameter;
    }

    /** Дано ціле число в діапазоні 1 - 7; Вивести рядок — назва дня тижня,
     * що відповідає даному числу (1 — «понеділок», 2 — «вівторок» і т. д.).
     */
    public DAY_OF_WEEK switchTask(int number) {
        switch (number) {
            case 1:
                return DAY_OF_WEEK.MONDAY;
            case 2:
                return DAY_OF_WEEK.TUESDAY;
            case 3:
                return DAY_OF_WEEK.WEDNESDAY;
            case 4:
                return DAY_OF_WEEK.THURSDAY;
            case 5:
                return DAY_OF_WEEK.FRIDAY;
            case 6:
                return DAY_OF_WEEK.SATURDAY;
            case 7:
                return DAY_OF_WEEK.SUNDAY;
            default:
                throw new IllegalArgumentException("Невірний номер дня тижня");
        }
    }

    /** Дані цілі числа K і N (N > 0). Вивести N раз число K. */
    public int[] forTask(int k, int n) {
        assert n > 0 : "N should be more than zero";

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = k;
        }

        return result;
    }


    /** Дано позитивні числа A і B (A > B). На відрізку довжини A розміщено максимально можливу кількість відрізків довжини B (без накладень).
     * Не використовуючи операції множення та поділу, знайти довжину незайнятої частини відрізка A.
     */
    public int whileTask(int a, int b) {
        assert (a > 0 && b > 0 && a > b) : "Arguments should be positive and A should be greater than B";

        while (a >= b) {
            a -= b;
        }

        return a;
    }

    /** Дано ціле число (N > 0). Сформувати і вивести цілий масив розміру N, що містить N  перших позитивних непарних чисел: 1, 3, 5, … .*/
    public static int[] arrayTask(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N should be more than zero");
        }

        int[] oddNumbers = new int[n];

        for (int i = 0; i < n; i++) {
            oddNumbers[i] = 2 * i + 1;
        }

        return oddNumbers;
    }

    /** Дані цілі позитивні числа M і N. Сформувати цілочисленну матрицю розміру M * N,
     * у якої всі елементи I-й рядки мають значення 10·I (I = 1, …, M ).
     */
    public int[][] twoDimensionArrayTask(int m, int n) {
        int[][] array = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = 10 * (i + 1);
            }
        }

        return array;
    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}