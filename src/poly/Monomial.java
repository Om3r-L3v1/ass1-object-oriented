package poly;

import scalar.IntegerScalar;
import scalar.RationalScalar;
import scalar.Scalar;

public class Monomial {

    private int exponent;

    private Scalar coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        if(exponent > 0) {
            this.exponent = exponent;
        }
        this.coefficient = coefficient;
    }
    public Monomial add(Monomial m){
        if(exponent != m.exponent)
            return null;
        return new Monomial(exponent, coefficient.add(m.coefficient));
    }

    public Monomial mul(Monomial m){
        return new Monomial(exponent+m.exponent, coefficient.mul(m.coefficient));
    }

    public Scalar evaluate(Scalar s){
         return coefficient.mul(s.power(exponent));
    }

    public Monomial derivative(){
        if(exponent == 0)
            return new Monomial(0, new IntegerScalar(0));
        Scalar newCoefficient = coefficient.mul(new IntegerScalar(exponent));
        return new Monomial(exponent-1, newCoefficient);
    }

    public int sign(){
        return coefficient.sign();
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Monomial){
            Monomial m = (Monomial)o;
            return m.exponent == exponent && m.coefficient.equals(coefficient);
        }
        return false;
    }

    @Override
    public String toString() {
        if (coefficient.sign() == 0) return "0";
        String output = coefficient.toString();
        if(exponent >= 1){
            if (coefficient.equals(new IntegerScalar(1)))
                output = "x";
            else if (coefficient.equals(new IntegerScalar(-1)))
                output = "-x";
            else
                output += "x";

            if(exponent > 1)
                output += "^"+exponent;
        }
        return output;

    }
}
