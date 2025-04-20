package Tests;

import scalar.*;
import org.junit.*;
import static org.junit.Assert.*;


public class IntegerScalarTest {

    // ----- ADD TESTS -----
    @Test
    public void testAdd_PositiveAddPositive() {
        IntegerScalar a = new IntegerScalar(5);
        IntegerScalar b = new IntegerScalar(3);
        Scalar result = a.add(b);
        Assert.assertEquals(new IntegerScalar(8), result);
    }

    @Test
    public void testAdd_NegativeAddPositive() {
        IntegerScalar a = new IntegerScalar(-5);
        IntegerScalar b = new IntegerScalar(3);
        Scalar result = a.add(b);
        Assert.assertEquals(new IntegerScalar(-2), result);
    }

    @Test
    public void testAdd_PositiveAddNegative() {
        IntegerScalar a = new IntegerScalar(5);
        IntegerScalar b = new IntegerScalar(-3);
        Scalar result = a.add(b);
        Assert.assertEquals(new IntegerScalar(2), result);
    }

    @Test
    public void testAdd_NegativeAddNegative() {
        IntegerScalar a = new IntegerScalar(-5);
        IntegerScalar b = new IntegerScalar(-3);
        Scalar result = a.add(b);
        Assert.assertEquals(new IntegerScalar(-8), result);
    }

    @Test
    public void testAdd_PositiveAddPositiveRational() {
        IntegerScalar a = new IntegerScalar(5);
        RationalScalar b = new RationalScalar(3, 2); // 1.5
        Scalar result = a.add(b);
        Assert.assertEquals(new RationalScalar(13, 2), result); // 5 + 1.5 = 6.5 = 13/2
    }

    @Test
    public void testAdd_NegativeAddPositiveRational() {
        IntegerScalar a = new IntegerScalar(-5);
        RationalScalar b = new RationalScalar(3, 2);
        Scalar result = a.add(b);
        Assert.assertEquals(new RationalScalar(-7, 2), result); // -5 + 1.5 = -3.5 = -7/2
    }

    @Test
    public void testAdd_PositiveAddNegativeRational() {
        IntegerScalar a = new IntegerScalar(5);
        RationalScalar b = new RationalScalar(-3, 2);
        Scalar result = a.add(b);
        Assert.assertEquals(new RationalScalar(7, 2), result); // 5 - 1.5 = 3.5 = 7/2
    }

    @Test
    public void testAdd_NegativeAddNegativeRational() {
        IntegerScalar a = new IntegerScalar(-5);
        RationalScalar b = new RationalScalar(-3, 2);
        Scalar result = a.add(b);
        Assert.assertEquals(new RationalScalar(-13, 2), result); // -5 - 1.5 = -6.5 = -13/2
    }


    // ----- MULTIPLY TESTS -----

    @Test
    public void testMul_PositiveMulPositive() {
        IntegerScalar a = new IntegerScalar(5);
        IntegerScalar b = new IntegerScalar(3);
        Scalar result = a.mul(b);
        assertEquals(new IntegerScalar(15), result);
    }

    @Test
    public void testMul_NegativeMulPositive() {
        IntegerScalar a = new IntegerScalar(-5);
        IntegerScalar b = new IntegerScalar(3);
        Scalar result = a.mul(b);
        assertEquals(new IntegerScalar(-15), result);
    }

    @Test
    public void testMul_PositiveMulNegative() {
        IntegerScalar a = new IntegerScalar(5);
        IntegerScalar b = new IntegerScalar(-3);
        Scalar result = a.mul(b);
        assertEquals(new IntegerScalar(-15), result);
    }

    @Test
    public void testMul_NegativeMulNegative() {
        IntegerScalar a = new IntegerScalar(-5);
        IntegerScalar b = new IntegerScalar(-3);
        Scalar result = a.mul(b);
        assertEquals(new IntegerScalar(15), result);
    }

    @Test
    public void testMul_PositiveMulPositiveRational() {
        IntegerScalar a = new IntegerScalar(5);
        RationalScalar b = new RationalScalar(3, 2);
        Scalar result = a.mul(b);
        assertEquals(new RationalScalar(15, 2), result);
    }

    @Test
    public void testMul_NegativeMulPositiveRational() {
        IntegerScalar a = new IntegerScalar(-5);
        RationalScalar b = new RationalScalar(3, 2);
        Scalar result = a.mul(b);
        assertEquals(new RationalScalar(-15, 2), result);
    }

    @Test
    public void testMul_PositiveMulNegativeRational() {
        IntegerScalar a = new IntegerScalar(5);
        RationalScalar b = new RationalScalar(-3, 2);
        Scalar result = a.mul(b);
        assertEquals(new RationalScalar(-15, 2), result);
    }

    @Test
    public void testMul_NegativeMulNegativeRational() {
        IntegerScalar a = new IntegerScalar(-5);
        RationalScalar b = new RationalScalar(-3, 2);
        Scalar result = a.mul(b);
        assertEquals(new RationalScalar(15, 2), result);
    }

    // ----- NEG TESTS -----

    @Test
    public void testNeg_Positive() {
        IntegerScalar a = new IntegerScalar(7);
        Scalar result = a.neg();
        assertEquals(new IntegerScalar(-7), result);
    }

    @Test
    public void testNeg_Negative() {
        IntegerScalar a = new IntegerScalar(-4);
        Scalar result = a.neg();
        assertEquals(new IntegerScalar(4), result);
    }

    // ----- POWER TESTS -----

    @Test(expected = IllegalArgumentException.class)
    public void testPower_NegativeExponent() {
        IntegerScalar a = new IntegerScalar(2);
        a.power(-3);
    }

    @Test
    public void testPower_PositiveExponent() {
        IntegerScalar a = new IntegerScalar(3);
        Scalar result = a.power(3);
        assertEquals(new IntegerScalar(27), result);
    }

    @Test
    public void testPower_ZeroExponent() {
        IntegerScalar a = new IntegerScalar(3);
        Scalar result = a.power(0);
        assertEquals(new IntegerScalar(1), result);
    }

    // ----- SIGN TESTS -----

    @Test
    public void testSign_Positive() {
        IntegerScalar a = new IntegerScalar(9);
        assertEquals(1, a.sign());
    }

    @Test
    public void testSign_Negative() {
        IntegerScalar a = new IntegerScalar(-9);
        assertEquals(-1, a.sign());
    }

    @Test
    public void testSign_Zero() {
        IntegerScalar a = new IntegerScalar(0);
        assertEquals(0, a.sign());
    }

    // ----- EQUALS TESTS -----

    @Test
    public void testEquals_SameInstance() {
        IntegerScalar a = new IntegerScalar(10);
        assertTrue(a.equals(a));
    }

    @Test
    public void testEquals_IntegerScalarEqual() {
        IntegerScalar a = new IntegerScalar(10);
        IntegerScalar b = new IntegerScalar(10);
        assertTrue(a.equals(b));
    }

    @Test
    public void testEquals_IntegerScalarNotEqual() {
        IntegerScalar a = new IntegerScalar(10);
        IntegerScalar b = new IntegerScalar(5);
        assertFalse(a.equals(b));
    }

    @Test
    public void testEquals_RationalScalarEqual() {
        IntegerScalar a = new IntegerScalar(3);
        RationalScalar b = new RationalScalar(6, 2);
        assertTrue(a.equals(b));
    }

    @Test
    public void testEquals_RationalScalarNotEqual() {
        IntegerScalar a = new IntegerScalar(3);
        RationalScalar b = new RationalScalar(7, 2);
        assertFalse(a.equals(b));
    }

    @Test
    public void testEquals_DifferentObject() {
        IntegerScalar a = new IntegerScalar(3);
        String notAScalar = "not a scalar";
        assertFalse(a.equals(notAScalar));
    }

    // ----- TO_STRING TESTS -----

    @Test
    public void testToString_Positive() {
        IntegerScalar a = new IntegerScalar(42);
        assertEquals("42", a.toString());
    }

    @Test
    public void testToString_Negative() {
        IntegerScalar a = new IntegerScalar(-7);
        assertEquals("-7", a.toString());
    }
}


