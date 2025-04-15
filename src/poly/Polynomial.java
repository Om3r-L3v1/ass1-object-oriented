package poly;

import scalar.IntegerScalar;
import scalar.RationalScalar;
import scalar.Scalar;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;

public class Polynomial {

    private TreeMap<Integer, Monomial> monomials;

    public Polynomial(Scalar[] coefficients) {
        monomials = new TreeMap<>();
        for (int i = 0; i < coefficients.length; i += 1) {
            monomials.put(i, new Monomial(i, coefficients[i]));
        }
    }

    public Polynomial add(Polynomial p) {
        return null;
    }

    public Polynomial mul(Polynomial p) {
        return null;
    }

    public Scalar evaluate(Scalar s) {
        return null;
    }

    public Polynomial derivative() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    // TODO
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        int counter = 0;
        for (var entry : monomials.entrySet()) {
            counter++;
            if (entry.getValue().sign() != 0) {
                output.append(entry.getValue().toString());
                if (counter < monomials.size()) {

                }
                    output.append(" + ");
            }
        }
        return output.toString();
    }

    /// Static Methods
    public static Polynomial build(String input) {
        String regex = "\s+";
        String[] parts = input.split(regex);
        Scalar[] coefficients = new Scalar[parts.length];
        for (int i = 0; i < parts.length; i++) {
            Scalar c = convertToScalar(parts[i]);
            if (c == null) {
                return null;
            }
            coefficients[i] = c;
        }
        return new Polynomial(coefficients);
    }

    private static Scalar convertToScalar(String s) {
        String[] parts = s.split("/");
        if (parts.length == 2) {
            int numerator; int denominator;
            try {
                numerator = Integer.parseInt(parts[0]);
                denominator = Integer.parseInt(parts[1]);
            }
            catch (NumberFormatException e) {
                return null;
            }
            return new RationalScalar(numerator, denominator);
        }
        if (parts.length ==1){
            int number;
            try {
                number = Integer.parseInt(parts[0]);
            }
            catch (NumberFormatException e) {
                return null;
            }
            return new IntegerScalar(number);
        }
        return null;
    }
}
