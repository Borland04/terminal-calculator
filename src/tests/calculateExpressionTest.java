package tests;

import main.InvalidDataException;
import main.Main;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class calculateExpressionTest {

    // Positive tests

    @Test
    public void calculateExpression_OperatorAddAndValidArgs_ReturnsResult() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(1f));
        stack.push(new BigDecimal(2f));

        assertEquals(3, Main.calculateExpression("+", stack).intValueExact());
    }

    @Test
    public void calculateExpression_OperatorSubAndValidArgs_ReturnsResult() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(1f));
        stack.push(new BigDecimal(2f));

        assertEquals(-1, Main.calculateExpression("-", stack).intValueExact());
    }

    @Test
    public void calculateExpression_OperatorMulAndValidArgs_ReturnsResult() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(2f));
        stack.push(new BigDecimal(2f));

        assertEquals(4, Main.calculateExpression("*", stack).intValueExact());
    }

    @Test
    public void calculateExpression_OperatorDivAndValidArgs_ReturnsResult() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(1f));
        stack.push(new BigDecimal(2f));

        assertEquals(0.5, Main.calculateExpression("/", stack).doubleValue(), 0.0001);
    }

    @Test
    public void calculateExpression_OperatorPowAndValidArgs_ReturnsResult() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(2f));
        stack.push(new BigDecimal(3f));

        assertEquals(8, Main.calculateExpression("^", stack).intValueExact());
    }


    // Negative tests

    @Test(expected = InvalidDataException.class)
    public void calculateExpression_OneArg_Throws() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(1f));

        Main.calculateExpression("+", stack);
    }

    @Test(expected = InvalidDataException.class)
    public void calculateExpression_NoArgs_Throws() {
        Stack<BigDecimal> stack = new Stack<>();

        Main.calculateExpression("+", stack);
    }


    @Test(expected = InvalidDataException.class)
    public void calculateExpression_DivByZero_Throws() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(1f));
        stack.push(new BigDecimal(0f));

        Main.calculateExpression("/", stack);
    }

    @Test(expected = ArithmeticException.class)
    public void calculateExpression_FloatPow_Throws() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(1f));
        stack.push(new BigDecimal(0.1f));

        Main.calculateExpression("^", stack);
    }

    @Test(expected = InvalidDataException.class)
    public void calculateExpression_UnknownOperator_Throws() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(1f));
        stack.push(new BigDecimal(1f));

        Main.calculateExpression("/^", stack);
    }

}
