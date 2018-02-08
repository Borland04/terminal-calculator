package tests;

import main.Main;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class nextAtomTest {

    @Test
    public void nextAtom_EmptyString_ReturnsEmptyString() {
        assertEquals("", Main.nextAtom("",0));
    }

    @Test
    public void nextAtom_EndOfString_ReturnsEmptyString() {
        assertEquals("", Main.nextAtom("0123",4));
    }

    @Test
    public void nextAtom_Integer_ReturnsInteger() {
        assertEquals("1234", Main.nextAtom("1234",0));
    }

    @Test
    public void nextAtom_NotFromStartInteger_ReturnsInteger() {
        assertEquals("1234", Main.nextAtom("abcd 1234",5));
    }

    @Test
    public void nextAtom_Float_ReturnsFloat() {
        assertEquals("0.1234", Main.nextAtom("0.1234",0));
    }

    @Test
    public void nextAtom_NegativeNumber_ReturnsNumber() {
        assertEquals("-1234", Main.nextAtom("-1234",0));
        assertEquals("-0.56", Main.nextAtom("-0.56",0));
    }


    @Test
    public void nextAtom_Operator_ReturnsOperator() {
        assertEquals("+", Main.nextAtom("+",0));
        assertEquals("-", Main.nextAtom("-",0));

        assertEquals("*", Main.nextAtom("*",0));
        assertEquals("/", Main.nextAtom("/",0));

        assertEquals("^", Main.nextAtom("^",0));

        assertEquals("(", Main.nextAtom("(",0));
        assertEquals(")", Main.nextAtom(")",0));
    }



    @Test
    public void nextAtom_Unknown_ReturnsUnknown() {
        assertEquals("abcdef", Main.nextAtom("abcdef",0));
    }

    @Test
    public void nextAtom_WhitespacesThenAtom_ReturnsAtom() {
        assertEquals("1234.56", Main.nextAtom("      1234.56",0));
    }

    @Test
    public void nextAtom_NumberWhitespacesAtom_ReturnsNumber() {
        assertEquals("1234", Main.nextAtom("1234 56",0));
    }

    @Test
    public void nextAtom_OperatorWhitespacesAtom_ReturnsOperator() {
        assertEquals("*", Main.nextAtom("* 56",0));
    }

    @Test
    public void nextAtom_NumberOperator_ReturnsNumber() {
        assertEquals("1234.5", Main.nextAtom("1234.5+",0));
    }

    @Test
    public void nextAtom_OperatorNumber_ReturnsOperator() {
        assertEquals("+", Main.nextAtom("+1234.5",0));
    }

    @Test
    public void nextAtom_NumberUnknown_ReturnsNumber() {
        assertEquals("1234.5", Main.nextAtom("1234.5abcd",0));
    }

    @Test
    public void nextAtom_UnknownNumber_ReturnsUnknown() {
        assertEquals("abcd", Main.nextAtom("abcd1234.5",0));
    }

    @Test
    public void nextAtom_Expression_ParseAsExpected() {
        assertEquals("2", Main.nextAtom("2+2 * 2",0));
        assertEquals("+", Main.nextAtom("2+2 * 2",1));
        assertEquals("2", Main.nextAtom("2+2 * 2",2));
        assertEquals("*", Main.nextAtom("2+2 * 2",3));
        assertEquals("2", Main.nextAtom("2+2 * 2",5));
        assertEquals("", Main.nextAtom("2+2 * 2",10));
    }

    @Test
    public void nextAtom_FewOperatorsTogether_ReturnsOperator() {
        assertEquals(")", Main.nextAtom(")^",0));
    }
}