package scalar;

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
        return s.addRat(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulRat(this);
    }

    @Override
    public Scalar neg() {
        return new RationalScalar(-numerator, denominator);
    }

    @Override
    public Scalar power(int exponent) {
        if (exponent < 0)
            throw new IllegalArgumentException("Exponent must be equal to or greater than 0.");
        return new RationalScalar((int)Math.pow(numerator,exponent), (int)Math.pow(denominator,exponent));
    }

    @Override
    public int sign() {
        if(this.numerator == 0)
            return 0;
        else if(Math.signum(denominator) == Math.signum(numerator))
            return 1;
        else
            return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RationalScalar other) {
            return (double) this.numerator/this.denominator == (double) other.numerator/other.denominator;
        }else if(o instanceof IntegerScalar other){
            boolean ans = other.getNumber() == (double) this.numerator/this.denominator;
            return ans;
        }
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
        int den = (this.denominator*s.denominator);
        int num = (this.numerator*s.numerator);
        return new RationalScalar(num,den);
    }

    @Override
    protected Scalar mulInt(IntegerScalar s) {
        int num = s.getNumber()*this.numerator;
        return new RationalScalar(num,denominator);
    }

    public RationalScalar reduce(){
        int gcd = GCD(denominator,numerator);
        int newNum = numerator/gcd;
        int newDen = denominator/gcd;
        if(Math.signum(denominator) == -1){
            return new RationalScalar(-newNum,-newDen);
        }
        return new RationalScalar(newNum,newDen);
    }
    @Override
    public String toString() {
        RationalScalar temp = this.reduce();
        if (temp.getDenominator() == 1) return ""+temp.numerator;
        return temp.numerator+"/"+temp.denominator;
    }

    private int GCD(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // To handle negative inputs
    }
}
