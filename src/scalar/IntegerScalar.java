package scalar;

public class IntegerScalar extends Scalar {

    private int number;


    public IntegerScalar(int number){
        this.number = number;
    }
    public IntegerScalar(){
        this(0);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public Scalar add(Scalar s) {
        if(s == null)
            throw new IllegalArgumentException("scalar should not be null");
        return s.addInt(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInt(this);
    }

    @Override
    public Scalar neg() {
        return new IntegerScalar(number*(-1));
    }

    @Override
    public Scalar power(int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be equal to or greater than 0.");
        }
        int num = (int) Math.pow(number, exponent);
        return new IntegerScalar(num);
    }

    @Override
    public int sign() {
        return (int) Math.signum(number);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IntegerScalar)
            return this.number == ((IntegerScalar) o).number;
        else if (o instanceof RationalScalar)
            return this.number ==
                    (double) ((RationalScalar) o).getNumerator()/((RationalScalar) o).getDenominator();
        else
            return false;
    }

    @Override
    public String toString() {
        return "" + number;
    }

    protected Scalar addInt(IntegerScalar s) {
        return new IntegerScalar(number+s.number);
    }

    @Override
    protected Scalar addRat(RationalScalar s) {
        int num = s.getNumerator() + number*s.getDenominator();
        return new RationalScalar(num, s.getDenominator());
    }

    @Override
    protected Scalar mulRat(RationalScalar s) {
        return new RationalScalar(number*s.getNumerator(), s.getDenominator());
    }

    @Override
    protected Scalar mulInt(IntegerScalar s) {
        return new IntegerScalar(this.number*s.number);
    }
}
