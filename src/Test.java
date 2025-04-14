import poly.Monomial;
import scalar.IntegerScalar;
import scalar.RationalScalar;

public class Test {

    public static void main(String[] args) {
        IntegerScalar s1 = new IntegerScalar(3);
        RationalScalar s2 = new RationalScalar(2, 5);
        IntegerScalar s3 = new IntegerScalar(-5);
        IntegerScalar s0 = new IntegerScalar(0);
        Monomial m1 = new Monomial(3, s2);
        Monomial m2 = new Monomial(3, s3);
        System.out.println(m1.add(m2));
        System.out.println(m1.mul(m2));
        System.out.println(m1.sign());
        System.out.println(m1.evaluate(s1));
        System.out.println(m1.derivative());
        System.out.println(m2.equals(m2));
        System.out.println(m2.equals(m1));

    }
}
