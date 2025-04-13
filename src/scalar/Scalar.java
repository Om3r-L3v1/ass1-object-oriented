package scalar;

public abstract class Scalar {


    abstract public Scalar add(Scalar s);

    abstract public Scalar mul(Scalar s);

    abstract public Scalar neg();

    abstract public Scalar power(int exponent);

    abstract public int sign();

    abstract public boolean equals(Object o);

    abstract protected Scalar addInt(IntegerScalar s);

    abstract protected Scalar addRat(RationalScalar s);

    abstract protected Scalar mulRat(RationalScalar s);

    abstract protected Scalar mulInt(IntegerScalar s);
}
