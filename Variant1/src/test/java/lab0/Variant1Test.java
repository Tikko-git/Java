package lab0;

import lab0.Variant1.DAY_OF_WEEK;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Variant1Test {

    public static double EPS = 0.0000001;

    //@Test
    public void integerTest(int l, int meters) {
        assertEquals(new Variant1().integerNumbersTask(l), meters);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 100, 1 }, { 150, 1 }, { 250, 2 }, { 95, 0 } };
    }


    public void booleanTest(int a, boolean expectedResult) {
        assertEquals(new Variant1().booleanTask(a), expectedResult);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5, true }, { 0, false }, { -3, false } };
    }

    @Test(dataProvider = "ifProvider")
    public void ifTaskTest(int p1, int p3) {
        assertEquals(new Variant1().ifTask(p1), p3);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 2, 3 }, { 0, 0 }, { -3, -3 } };
    }

    @Test(dataProvider = "switchProvider")
    public void switchTaskTest(int p1, DAY_OF_WEEK p2) {
        assertEquals(new Variant1().switchTask(p1), p2);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 1, DAY_OF_WEEK.MONDAY }, { 2, DAY_OF_WEEK.TUESDAY },
                { 3, DAY_OF_WEEK.WEDNESDAY }, { 4, DAY_OF_WEEK.THURSDAY },
                { 5, DAY_OF_WEEK.FRIDAY }, { 6, DAY_OF_WEEK.SATURDAY },
                { 7, DAY_OF_WEEK.SUNDAY } };
    }

    public void forTest(int k, int n, int[] expectedResult) {
        assertEquals(new Variant1().forTask(k, n), expectedResult);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] {
                { 3, 5, new int[] { 3, 3, 3, 3, 3 } },
                { 7, 2, new int[] { 7, 7 } }
        };
    }

    @Test(dataProvider = "whileProvider")
    public void whileTaskTest(int a, int b, int c) {
        assertEquals(new Variant1().whileTask(a, b), c);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 10, 2, 0 }, { 12, 10, 2 }, { 12, 1, 0 }, { 25, 7, 4 } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTaskTest(int a, int b) {
        new Variant1().whileTask(a, b);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { 1, 2 }, { -2, 1 }, { 2, -1 } };
    }

    @Test(dataProvider = "arrayProvider")
    public void arrayTaskTest(int N, int[] expected) {
        assertEquals(new Variant1().arrayTask(N), expected);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { 3, new int[]{1, 3, 5} }, { 5, new int[]{1, 3, 5, 7, 9} } };
    }

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTaskTest(int M, int N, int[][] expected) {
        assertEquals(new Variant1().twoDimensionArrayTask(M, N), expected);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] expected1 = {{10, 10, 10}, {20, 20, 20}};
        int[][] expected2 = {{10, 10}, {20, 20}};

        return new Object[][] {
                {2, 3, expected1},
                {2, 2, expected2}
        };
    }

}
