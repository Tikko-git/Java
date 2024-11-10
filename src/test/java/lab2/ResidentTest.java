package lab2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.time.LocalDate;

public class ResidentTest {

    @DataProvider(name = "customerDataToString")
    public Object[][] customerDataToString() {
        return new Object[][] {
                {
                        new Resident("Doe", "John", 12345, LocalDate.of(1990, 1, 1)),
                        "Resident{lastName='Doe', firstName='John', documentId='12345', birthDate='1990-01-01'}"
                }
        };
    }

    @Test(dataProvider = "customerDataToString")
    public void testToString(Resident resident, String expected) {
        assertEquals(resident.toString(), expected);
    }

    @DataProvider(name = "customerDataEquals")
    public Object[][] customerDataEquals() {
        return new Object[][]{
                {
                        new Resident("Doe", "John", 12345, LocalDate.of(1990, 1, 1)),
                        new Resident("Doe", "John", 12345, LocalDate.of(1990, 1, 1)),
                        true
                },
                {
                        new Resident("Doe", "Jane", 12346, LocalDate.of(1990, 1, 1)),
                        new Resident("Doe", "John", 12345, LocalDate.of(1990, 1, 1)),
                        false
                }
        };
    }

    @Test(dataProvider = "customerDataEquals")
    public void testEquals(Resident resident1, Resident resident2, boolean expected) {
        assertEquals(resident1.equals(resident2), expected);
    }

    @Test(dataProvider = "customerDataEquals")
    public void testHashCode(Resident resident1, Resident resident2, boolean expected) {
        if (expected) {
            assertEquals(resident1.hashCode(), resident2.hashCode());
        } else {
            assertNotEquals(resident1.hashCode(), resident2.hashCode());
        }
    }
}
