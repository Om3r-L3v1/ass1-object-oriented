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
    public String toString() {
        return null;
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
        return null;
    }

    @Override
    protected Scalar mulInt(IntegerScalar s) {
        return null;
    }
}
