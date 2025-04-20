package Tests;

import poly.Monomial;
import scalar.*;
import org.junit.*;

public class MonomialTest {

    // --------- ADD TESTS ---------

    @Test
    public void testAdd_IntegerAddInteger() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(2, new IntegerScalar(4));
        Assert.assertEquals(new Monomial(2, new IntegerScalar(7)), m1.add(m2));
    }

    @Test
    public void testAdd_RationalAddInteger() {
        Monomial m1 = new Monomial(2, new RationalScalar(1, 2));
        Monomial m2 = new Monomial(2, new IntegerScalar(1));
        Assert.assertEquals(new Monomial(2, new RationalScalar(3, 2)), m1.add(m2));
    }

    @Test
    public void testAdd_RationalAddRational() {
        Monomial m1 = new Monomial(2, new RationalScalar(1, 3));
        Monomial m2 = new Monomial(2, new RationalScalar(2, 3));
        Assert.assertEquals(new Monomial(2, new RationalScalar(1, 1)), m1.add(m2));
    }

    @Test
    public void testAdd_IntegerAddRational() {
        Monomial m1 = new Monomial(2, new IntegerScalar(1));
        Monomial m2 = new Monomial(2, new RationalScalar(1, 2));
        Assert.assertEquals(new Monomial(2, new RationalScalar(3, 2)), m1.add(m2));
    }

    @Test
    public void testAdd_DifferentExponents() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(3, new IntegerScalar(4));
        Assert.assertEquals(null, m1.add(m2));
    }

    // --------- MULTIPLY TESTS ---------

    @Test
    public void testMul_IntegerMulInteger() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(3, new IntegerScalar(4));
        Assert.assertEquals(new Monomial(5, new IntegerScalar(12)), m1.mul(m2));
    }

    @Test
    public void testMul_RationalMulInteger() {
        Monomial m1 = new Monomial(2, new RationalScalar(1, 2));
        Monomial m2 = new Monomial(3, new IntegerScalar(2));
        Assert.assertEquals(new Monomial(5, new RationalScalar(1, 1)), m1.mul(m2));
    }

    @Test
    public void testMul_RationalMulRational() {
        Monomial m1 = new Monomial(1, new RationalScalar(1, 2));
        Monomial m2 = new Monomial(2, new RationalScalar(2, 3));
        Assert.assertEquals(new Monomial(3, new RationalScalar(1, 3)), m1.mul(m2));
    }

    @Test
    public void testMul_IntegerMulRational() {
        Monomial m1 = new Monomial(1, new IntegerScalar(2));
        Monomial m2 = new Monomial(2, new RationalScalar(1, 2));
        Assert.assertEquals(new Monomial(3, new RationalScalar(1, 1)), m1.mul(m2));
    }

    // --------- EVALUATE TESTS ---------

    @Test
    public void testEvaluate_PositiveRational() {
        Monomial m = new Monomial(2, new RationalScalar(1, 2));
        Scalar result = m.evaluate(new RationalScalar(2, 1));
        Assert.assertEquals(new RationalScalar(2, 1), result);
    }

    @Test
    public void testEvaluate_NegativeRational() {
        Monomial m = new Monomial(2, new RationalScalar(1, 2));
        Scalar result = m.evaluate(new RationalScalar(-2, 1));
        Assert.assertEquals(new RationalScalar(2, 1), result);
    }

    @Test
    public void testEvaluate_PositiveInteger() {
        Monomial m = new Monomial(2, new IntegerScalar(3));
        Scalar result = m.evaluate(new IntegerScalar(2));
        Assert.assertEquals(new IntegerScalar(12), result);
    }

    @Test
    public void testEvaluate_NegativeInteger() {
        Monomial m = new Monomial(2, new IntegerScalar(3));
        Scalar result = m.evaluate(new IntegerScalar(-2));
        Assert.assertEquals(new IntegerScalar(12), result);
    }

    @Test
    public void testEvaluate_ExponentZero() {
        Monomial m = new Monomial(0, new IntegerScalar(3));
        Scalar result = m.evaluate(new IntegerScalar(100));
        Assert.assertEquals(new IntegerScalar(3), result);
    }

    // --------- DERIVATIVE TESTS ---------

    @Test
    public void testDerivative_ExponentZero() {
        Monomial m = new Monomial(0, new IntegerScalar(5));
        Assert.assertEquals(new Monomial(0, new IntegerScalar(0)), m.derivative());
    }

    @Test
    public void testDerivative_PositiveScalar() {
        Monomial m = new Monomial(3, new IntegerScalar(2));
        Assert.assertEquals(new Monomial(2, new IntegerScalar(6)), m.derivative());
    }

    @Test
    public void testDerivative_NegativeScalar() {
        Monomial m = new Monomial(3, new IntegerScalar(-2));
        Assert.assertEquals(new Monomial(2, new IntegerScalar(-6)), m.derivative());
    }

    // --------- SIGN TEST ---------

    @Test
    public void testSign_Positive() {
        Monomial m = new Monomial(2, new IntegerScalar(3));
        Assert.assertEquals(1, m.sign());
    }

    // --------- EQUALS TESTS ---------

    @Test
    public void testEquals_EqualMonomials() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(2, new IntegerScalar(3));
        Assert.assertTrue(m1.equals(m2));
    }

    @Test
    public void testEquals_SameExponentDifferentCoefficient() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(2, new IntegerScalar(4));
        Assert.assertFalse(m1.equals(m2));
    }

    @Test
    public void testEquals_SameCoefficientDifferentExponent() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(3, new IntegerScalar(3));
        Assert.assertFalse(m1.equals(m2));
    }

    @Test
    public void testEquals_DifferentExponentAndCoefficient() {
        Monomial m1 = new Monomial(1, new IntegerScalar(2));
        Monomial m2 = new Monomial(3, new IntegerScalar(3));
        Assert.assertFalse(m1.equals(m2));
    }

    @Test
    public void testEquals_DifferentObject() {
        Monomial m = new Monomial(2, new IntegerScalar(3));
        Assert.assertFalse(m.equals("not a monomial"));
    }

    // --------- TO_STRING TESTS ---------

    @Test
    public void testToString_ExponentOne() {
        Monomial m = new Monomial(1, new IntegerScalar(3));
        Assert.assertEquals("3x", m.toString());
    }

    @Test
    public void testToString_ExponentZero() {
        Monomial m = new Monomial(0, new IntegerScalar(5));
        Assert.assertEquals("5", m.toString());
    }

    @Test
    public void testToString_CoefficientZero() {
        Monomial m = new Monomial(3, new IntegerScalar(0));
        Assert.assertEquals("0", m.toString());
    }

    @Test
    public void testToString_CoefficientOne() {
        Monomial m = new Monomial(2, new IntegerScalar(1));
        Assert.assertEquals("x^2", m.toString());
    }

    @Test
    public void testToString_RegularMonomialPositive() {
        Monomial m = new Monomial(2, new IntegerScalar(3));
        Assert.assertEquals("3x^2", m.toString());
    }

    @Test
    public void testToString_RegularMonomialNegative() {
        Monomial m = new Monomial(2, new IntegerScalar(-3));
        Assert.assertEquals("-3x^2", m.toString());
    }
}
