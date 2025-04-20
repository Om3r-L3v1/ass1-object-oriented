package Tests;

import scalar.*;
import org.junit.*;

public class RationalScalarTest {

    // ----- ADD TESTS -----

    @Test
    public void testAdd_PositiveAddPositive() {
        RationalScalar a = new RationalScalar(1, 2);
        RationalScalar b = new RationalScalar(1, 3);
        Assert.assertEquals(new RationalScalar(5, 6), a.add(b));
    }

    @Test
    public void testAdd_NegativeAddPositive() {
        RationalScalar a = new RationalScalar(-1, 2);
        RationalScalar b = new RationalScalar(1, 3);
        Assert.assertEquals(new RationalScalar(-1, 6), a.add(b));
    }

    @Test
    public void testAdd_PositiveAddNegative() {
        RationalScalar a = new RationalScalar(1, 2);
        RationalScalar b = new RationalScalar(-1, 3);
        Assert.assertEquals(new RationalScalar(1, 6), a.add(b));
    }

    @Test
    public void testAdd_NegativeAddNegative() {
        RationalScalar a = new RationalScalar(-1, 2);
        RationalScalar b = new RationalScalar(-1, 3);
        Assert.assertEquals(new RationalScalar(-5, 6), a.add(b));
    }

    @Test
    public void testAdd_PositiveAddPositiveInteger() {
        RationalScalar a = new RationalScalar(1, 2);
        IntegerScalar b = new IntegerScalar(2);
        Assert.assertEquals(new RationalScalar(5, 2), a.add(b));
    }

    @Test
    public void testAdd_NegativeAddPositiveInteger() {
        RationalScalar a = new RationalScalar(-1, 2);
        IntegerScalar b = new IntegerScalar(2);
        Assert.assertEquals(new RationalScalar(3, 2), a.add(b));
    }

    @Test
    public void testAdd_PositiveAddNegativeInteger() {
        RationalScalar a = new RationalScalar(1, 2);
        IntegerScalar b = new IntegerScalar(-2);
        Assert.assertEquals(new RationalScalar(-3, 2), a.add(b));
    }

    @Test
    public void testAdd_NegativeAddNegativeInteger() {
        RationalScalar a = new RationalScalar(-1, 2);
        IntegerScalar b = new IntegerScalar(-2);
        Assert.assertEquals(new RationalScalar(-5, 2), a.add(b));
    }

    // ----- MULTIPLY TESTS -----

    @Test
    public void testMul_PositiveMulPositive() {
        RationalScalar a = new RationalScalar(1, 2);
        RationalScalar b = new RationalScalar(1, 3);
        Assert.assertEquals(new RationalScalar(1, 6), a.mul(b));
    }

    @Test
    public void testMul_NegativeMulPositive() {
        RationalScalar a = new RationalScalar(-1, 2);
        RationalScalar b = new RationalScalar(1, 3);
        Assert.assertEquals(new RationalScalar(-1, 6), a.mul(b));
    }

    @Test
    public void testMul_PositiveMulNegative() {
        RationalScalar a = new RationalScalar(1, 2);
        RationalScalar b = new RationalScalar(-1, 3);
        Assert.assertEquals(new RationalScalar(-1, 6), a.mul(b));
    }

    @Test
    public void testMul_NegativeMulNegative() {
        RationalScalar a = new RationalScalar(-1, 2);
        RationalScalar b = new RationalScalar(-1, 3);
        Assert.assertEquals(new RationalScalar(1, 6), a.mul(b));
    }

    @Test
    public void testMul_PositiveMulPositiveInteger() {
        RationalScalar a = new RationalScalar(2, 3);
        IntegerScalar b = new IntegerScalar(4);
        Assert.assertEquals(new RationalScalar(8, 3), a.mul(b));
    }

    @Test
    public void testMul_NegativeMulPositiveInteger() {
        RationalScalar a = new RationalScalar(-2, 3);
        IntegerScalar b = new IntegerScalar(4);
        Assert.assertEquals(new RationalScalar(-8, 3), a.mul(b));
    }

    @Test
    public void testMul_PositiveMulNegativeInteger() {
        RationalScalar a = new RationalScalar(2, 3);
        IntegerScalar b = new IntegerScalar(-4);
        Assert.assertEquals(new RationalScalar(-8, 3), a.mul(b));
    }

    @Test
    public void testMul_NegativeMulNegativeInteger() {
        RationalScalar a = new RationalScalar(-2, 3);
        IntegerScalar b = new IntegerScalar(-4);
        Assert.assertEquals(new RationalScalar(8, 3), a.mul(b));
    }

    // ----- NEG TESTS -----

    @Test
    public void testNeg_Positive() {
        RationalScalar a = new RationalScalar(3, 4);
        Assert.assertEquals(new RationalScalar(-3, 4), a.neg());
    }

    @Test
    public void testNeg_Negative() {
        RationalScalar a = new RationalScalar(-3, 4);
        Assert.assertEquals(new RationalScalar(3, 4), a.neg());
    }

    // ----- POWER TESTS -----

    @Test(expected = IllegalArgumentException.class)
    public void testPower_NegativeExponent() {
        RationalScalar a = new RationalScalar(2, 3);
        a.power(-2);
    }

    @Test
    public void testPower_PositiveExponent() {
        RationalScalar a = new RationalScalar(2, 3);
        Assert.assertEquals(new RationalScalar(8, 27), a.power(3));
    }

    @Test
    public void testPower_ZeroExponent() {
        RationalScalar a = new RationalScalar(2, 3);
        Assert.assertEquals(new RationalScalar(1, 1), a.power(0));
    }

    // ----- SIGN TESTS -----

    @Test
    public void testSign_Positive() {
        RationalScalar a = new RationalScalar(2, 3);
        Assert.assertEquals(1, a.sign());
    }

    @Test
    public void testSign_NegativeNumerator() {
        RationalScalar a = new RationalScalar(-2, 3);
        Assert.assertEquals(-1, a.sign());
    }

    @Test
    public void testSign_NegativeDenominator() {
        RationalScalar a = new RationalScalar(2, -3);
        Assert.assertEquals(-1, a.sign());
    }

    @Test
    public void testSign_Zero() {
        RationalScalar a = new RationalScalar(0, 5);
        Assert.assertEquals(0, a.sign());
    }

    // ----- EQUALS TESTS -----

    @Test
    public void testEquals_EqualInstances() {
        RationalScalar a = new RationalScalar(2, 4);
        RationalScalar b = new RationalScalar(1, 2);
        Assert.assertTrue(a.equals(b));
    }

    @Test
    public void testEquals_NotEqual() {
        RationalScalar a = new RationalScalar(2, 4);
        RationalScalar b = new RationalScalar(3, 4);
        Assert.assertFalse(a.equals(b));
    }

    @Test
    public void testEquals_IntegerScalarEqual() {
        RationalScalar a = new RationalScalar(4, 2);
        IntegerScalar b = new IntegerScalar(2);
        Assert.assertTrue(a.equals(b));
    }

    @Test
    public void testEquals_IntegerScalarNotEqual() {
        RationalScalar a = new RationalScalar(5, 2);
        IntegerScalar b = new IntegerScalar(2);
        Assert.assertFalse(a.equals(b));
    }

    @Test
    public void testEquals_DifferentObjectType() {
        RationalScalar a = new RationalScalar(1, 2);
        String notScalar = "not a scalar";
        Assert.assertFalse(a.equals(notScalar));
    }

    // ----- TO_STRING TESTS -----

    @Test
    public void testToString_WholeNumber() {
        RationalScalar a = new RationalScalar(4, 2);
        Assert.assertEquals("2", a.toString());
    }

    @Test
    public void testToString_ProperFraction() {
        RationalScalar a = new RationalScalar(2, 3);
        Assert.assertEquals("2/3", a.toString());
    }

    @Test
    public void testToString_NegativeFraction() {
        RationalScalar a = new RationalScalar(-2, 3);
        Assert.assertEquals("-2/3", a.toString());
    }

}
