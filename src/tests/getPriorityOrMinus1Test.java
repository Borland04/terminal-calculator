package tests;

import main.Main;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class getPriorityOrMinus1Test {
    
    @Test
    public void getPriorityOrMinus1_ValidOperator_ValidPriority() {
        assertEquals(new Integer(1), Main.getPriorityOrMinus1("+"));
        assertEquals(new Integer(1), Main.getPriorityOrMinus1("-"));

        assertEquals(new Integer(2), Main.getPriorityOrMinus1("*"));
        assertEquals(new Integer(2), Main.getPriorityOrMinus1("/"));

        assertEquals(new Integer(3), Main.getPriorityOrMinus1("^"));

        assertEquals(new Integer(0), Main.getPriorityOrMinus1("("));
        assertEquals(new Integer(0), Main.getPriorityOrMinus1(")"));
    }
    
}
