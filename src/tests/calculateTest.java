package tests;

import main.InvalidDataException;
import main.Main;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calculateTest {

    @Test
    public void Expression1() {
        assertEquals(6, Main.calculate("2 + 2 * 2").intValueExact());
    }

    @Test
    public void Expression2() {
        assertEquals(1.75, Main.calculate("(4 + 3) * 2 ^ -2").doubleValue(), 0.001);
    }

    @Test(expected = InvalidDataException.class)
    public void Expression3() {
        Main.calculate("5 + 1/0");
    }

    @Test
    public void Expression4() {
        assertEquals(1, Main.calculate("(17 ^ 4 + 5 * 974 ^ 33 + 2.24 * 4.75)^0").intValueExact());
    }

    @Test(expected = InvalidDataException.class)
    public void Expression5() {
        Main.calculate("4 2 * 3");
    }

    @Test(expected = NumberFormatException.class)
    public void Expression6() {
        Main.calculate("4a * 5");
    }

}
