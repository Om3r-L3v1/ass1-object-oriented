import scalar.IntegerScalar;
import scalar.RationalScalar;

public class Test {

    public static void main(String[] args) {
        IntegerScalar s1 = new IntegerScalar(3);
        RationalScalar s2 = new RationalScalar(9, 3);
        IntegerScalar s3 = new IntegerScalar(-5);
        IntegerScalar s0 = new IntegerScalar(0);
        System.out.println(s1.mul(s3));
        System.out.println(s1.mul(s0));
        System.out.println(s3.sign());
        System.out.println(s0.sign());
    }
}
