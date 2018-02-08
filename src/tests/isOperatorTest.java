package tests;

import main.Main;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class isOperatorTest {

    @Test
    public void isOperator_ValidOperators_True() {
        assertTrue(Main.isOperator("+"));
        assertTrue(Main.isOperator("-"));

        assertTrue(Main.isOperator("*"));
        assertTrue(Main.isOperator("/"));

        assertTrue(Main.isOperator("^"));

        assertTrue(Main.isOperator("("));
        assertTrue(Main.isOperator(")"));
    }

    @Test
    public void isOperator_InvalidOperator_False() {
        assertFalse(Main.isOperator("$"));
    }

    @Test
    public void isOperator_ManyOperatorsTogether_False() {
        assertFalse(Main.isOperator("*+"));
    }

}
