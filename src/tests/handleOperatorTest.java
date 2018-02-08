package tests;

import main.Main;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class handleOperatorTest {

    @Test
    public void handleOperator_OneOperator_Valid() {
        Stack<String> operators = new Stack<>();
        Stack<BigDecimal> operands = new Stack<>();

        operands.push(new BigDecimal(1));
        operands.push(new BigDecimal(2));

        Main.handleOperator("+", operators, operands);
        assertEquals(2, operands.pop().intValueExact());
        assertEquals(1, operands.pop().intValueExact());
    }

    @Test
    public void handleOperator_TwoOperatorWithSamePriority_Valid() {
        Stack<String> operators = new Stack<>();
        Stack<BigDecimal> operands = new Stack<>();

        operators.push("+");

        operands.push(new BigDecimal(1));
        operands.push(new BigDecimal(2));

        Main.handleOperator("-", operators, operands);
        assertEquals(3, operands.pop().intValueExact());
        assertEquals("-", operators.pop());
    }

    @Test
    public void handleOperator_TwoOperatorWithDifferentPriority_Valid() {
        Stack<String> operators = new Stack<>();
        Stack<BigDecimal> operands = new Stack<>();

        operators.push("+");

        operands.push(new BigDecimal(1));
        operands.push(new BigDecimal(2));

        Main.handleOperator("*", operators, operands);
        assertEquals("*", operators.pop());
        assertEquals("+", operators.pop());
        assertEquals(2, operands.pop().intValueExact());
        assertEquals(1, operands.pop().intValueExact());



        operators.clear();
        operands.clear();

        operators.push("*");

        operands.push(new BigDecimal(2));
        operands.push(new BigDecimal(2));

        Main.handleOperator("+", operators, operands);
        assertEquals(4, operands.pop().intValueExact());
        assertEquals("+", operators.pop());
    }

    @Test
    public void handleOperator_CloseBracket_Valid() {
        Stack<String> operators = new Stack<>();
        Stack<BigDecimal> operands = new Stack<>();

        operators.push("+");
        operators.push("(");
        operators.push("-");
        operators.push("*");


        operands.push(new BigDecimal(1));
        operands.push(new BigDecimal(2));
        operands.push(new BigDecimal(3));
        operands.push(new BigDecimal(4));

        Main.handleOperator(")", operators, operands);
        assertEquals(-10, operands.pop().intValueExact());

        assertEquals("+", operators.pop());
        assertEquals(1, operands.pop().intValueExact());
    }

}
