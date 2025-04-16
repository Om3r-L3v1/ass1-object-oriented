import poly.Monomial;
import poly.Polynomial;
import scalar.IntegerScalar;
import scalar.RationalScalar;

public class Test {

    public static void main(String[] args) {
        IntegerScalar s1 = new IntegerScalar(3);
        RationalScalar s2 = new RationalScalar(-4, -2);
        IntegerScalar s3 = new IntegerScalar(-5);
        IntegerScalar s0 = new IntegerScalar(0);
        Monomial m1 = new Monomial(3, s2);
        Monomial m2 = new Monomial(3, s3);
        Monomial m3 = new Monomial(1, new IntegerScalar(0));
//        System.out.println(s2);
//        System.out.println(m1.add(m2));
//        System.out.println(m1.mul(m2));
//        System.out.println(m1.sign());
//        System.out.println(m1.evaluate(s1));
//        System.out.println(m1.derivative());
//        System.out.println(m2.equals(m2));
//        System.out.println(m2.equals(m1));
//        System.out.println(m3);

        Polynomial p1 = Polynomial.build("1 2 3");
        Polynomial p2 = Polynomial.build("0 -2 2/3 6/-4");
        System.out.println(p1.add(p2));

//        RationalScalar r1 = new RationalScalar(6, -4);
//        IntegerScalar i1 = new IntegerScalar(-1);
//        System.out.println(r1.equals(i1));
    }
}
