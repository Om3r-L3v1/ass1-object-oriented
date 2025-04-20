package Tests;

import poly.Polynomial;
import scalar.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PolynomialTest {

    // --- Add Tests ---

    @Test
    public void testAdd_SameExponentMonomials() {
        Polynomial p1 = Polynomial.build("1 2 3");
        Polynomial p2 = Polynomial.build("4 5 6");
        Polynomial expected = Polynomial.build("5 7 9");
        assertEquals(expected, p1.add(p2));
    }

    @Test
    public void testAdd_DifferentExponentMonomials() {
        Polynomial p1 = Polynomial.build("1 2");
        Polynomial p2 = Polynomial.build("0 0 3 4");
        Polynomial expected = Polynomial.build("1 2 3 4");
        assertEquals(expected, p1.add(p2));
    }

    @Test
    public void testAdd_MixedExponentMonomials() {
        Polynomial p1 = Polynomial.build("1 0 3");
        Polynomial p2 = Polynomial.build("2 5 0 4");
        Polynomial expected = Polynomial.build("3 5 3 4");
        assertEquals(expected, p1.add(p2));
    }

    // --- Multiply Tests ---

    @Test
    public void testMul_MultipleMonomials_1() {
        Polynomial p1 = Polynomial.build("1 2 3");
        Polynomial p2 = Polynomial.build("1 1 1");
        Polynomial result = p1.mul(p2);
        assertEquals(Polynomial.build("1 3 6 5 3"), result);
    }

    @Test
    public void testMul_MultipleMonomials_2() {
        Polynomial p1 = Polynomial.build("0 1 0 2");
        Polynomial p2 = Polynomial.build("1 0 1 0");
        Polynomial result = p1.mul(p2);
        assertEquals(Polynomial.build("0 1 0 3 0 2"), result);
    }

    @Test
    public void testMul_MultipleMonomials_3() {
        Polynomial p1 = Polynomial.build("2 3 0 0 1");
        Polynomial p2 = Polynomial.build("0 0 1 2 1");
        Polynomial result = p1.mul(p2);
        assertEquals(Polynomial.build("0 0 2 7 8 3 1 2 1"), result);
    }

    @Test
    public void testMul_MultipleMonomials_4() {
        Polynomial p1 = Polynomial.build("1 0 1 1");
        Polynomial p2 = Polynomial.build("0 1 0 2");
        Polynomial result = p1.mul(p2);
        assertEquals(Polynomial.build("0 1 0 3 1 2"), result);
    }

    // --- Evaluate Tests ---

    @Test
    public void testEvaluate_PositiveInteger() {
        Polynomial p = Polynomial.build("1 2 3");
        Scalar result = p.evaluate(new IntegerScalar(2)); // 1 + 2*2 + 3*4 = 1 + 4 + 12 = 17
        assertEquals(new IntegerScalar(17), result);
    }

    @Test
    public void testEvaluate_NegativeInteger() {
        Polynomial p = Polynomial.build("1 2 3");
        Scalar result = p.evaluate(new IntegerScalar(-1)); // 1 -2 + 3 = 2
        assertEquals(new IntegerScalar(2), result);
    }

    @Test
    public void testEvaluate_PositiveRational() {
        Polynomial p = Polynomial.build("1 2 1");
        Scalar result = p.evaluate(new RationalScalar(1, 2)); // 1 + 1 + 0.25 = 2.25
        assertEquals(new RationalScalar(9, 4), result);
    }

    @Test
    public void testEvaluate_NegativeRational() {
        Polynomial p = Polynomial.build("1 2 1");
        Scalar result = p.evaluate(new RationalScalar(-1, 2)); // 1 -1 + 0.25 = 0.25
        assertEquals(new RationalScalar(1, 4), result);
    }

    // --- Derivative Tests ---

    @Test
    public void testDerivative_MultipleMonomials_1() {
        Polynomial p = Polynomial.build("1 2 3");
        Polynomial expected = Polynomial.build("2 6");
        assertEquals(expected, p.derivative());
    }

    @Test
    public void testDerivative_MultipleMonomials_2() {
        Polynomial p = Polynomial.build("0 0 0 4 1");
        Polynomial expected = Polynomial.build("0 0 12 4");
        assertEquals(expected, p.derivative());
    }

    @Test
    public void testDerivative_MultipleMonomials_3() {
        Polynomial p = Polynomial.build("5 0 3 2 0 1");
        Polynomial expected = Polynomial.build("0 6 6 0 5");
        assertEquals(expected, p.derivative());
    }

    @Test
    public void testDerivative_MultipleMonomials_4() {
        Polynomial p = Polynomial.build("1 1 1 1 1 1");
        Polynomial expected = Polynomial.build("1 2 3 4 5");
        assertEquals(expected, p.derivative());
    }

    // --- Equals Tests ---

    @Test
    public void testEquals_SameInstance() {
        Polynomial p = Polynomial.build("1 2 3");
        assertTrue(p.equals(p));
    }

    @Test
    public void testEquals_EqualInstance() {
        Polynomial p1 = Polynomial.build("1 2 3");
        Polynomial p2 = Polynomial.build("1 2 3");
        assertTrue(p1.equals(p2));
    }

    @Test
    public void testEquals_NotEqualInstance() {
        Polynomial p1 = Polynomial.build("1 2 3");
        Polynomial p2 = Polynomial.build("3 2 1");
        assertFalse(p1.equals(p2));
    }

    @Test
    public void testEquals_DifferentObject() {
        Polynomial p = Polynomial.build("1 2 3");
        String notAPoly = "not a polynomial";
        assertFalse(p.equals(notAPoly));
    }

    // --- ToString Test ---

    @Test
    public void testToString_MixedScalars() {
        Polynomial p = new Polynomial();
        p = Polynomial.build("1 -1 2/3 -3 0 1 -5/2");

        String expected = "1 - x + 2/3x^2 - 3x^3 + x^5 - 5/2x^6";
        assertEquals(expected, p.toString());
    }


}
