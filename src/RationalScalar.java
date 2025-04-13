public class RationalScalar extends Scalar{

    private int numerator;

    private int denominator;

    public RationalScalar(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denominator;
    }

    @Override
    public Scalar add(Scalar s) {
        return null;
    }

    @Override
    public Scalar mul(Scalar s) {
        return null;
    }

    @Override
    public Scalar neg() {
        return null;
    }

    @Override
    public Scalar power(int exponent) {
        return null;
    }

    @Override
    public int sign() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    protected Scalar addInt(IntegerScalar s) {
        int num = denominator*s.getNumber() + numerator;
        return new RationalScalar(num, denominator);
    }

    @Override
    protected Scalar addRat(RationalScalar s) {
        int num = (this.denominator*s.numerator) + (this.numerator*s.denominator);
        int den = this.denominator*s.denominator;
        return new RationalScalar(num,den);
    }

    @Override
    protected Scalar mulRat(RationalScalar s) {
        return null;
    }

    @Override
    protected Scalar mulInt(IntegerScalar s) {
        return null;
    }

    public RationalScalar reduce(){
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
