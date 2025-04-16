package poly;

import scalar.IntegerScalar;
import scalar.RationalScalar;
import scalar.Scalar;

import java.util.TreeMap;

public class Polynomial {

    private TreeMap<Integer, Monomial> monomials;

    public Polynomial() {
        monomials = new TreeMap<>();
    }

    public Polynomial(Polynomial p) {
        monomials = new TreeMap<>(p.monomials);
    }

    public Polynomial add(Polynomial p) {
        Polynomial output = new Polynomial(this);
        for (var entry : p.monomials.entrySet()) {
            Integer currEx = entry.getKey();
            Monomial currM = output.monomials.getOrDefault(currEx, new Monomial(currEx, new IntegerScalar(0)));
            output.monomials.put(currEx, currM.add(entry.getValue()));
        }
        return output;
    }

    public Polynomial mul(Polynomial p) {
        Polynomial output = new Polynomial();
        for (var thisEntry : this.monomials.entrySet()) {
            for (var pEntry : p.monomials.entrySet()) {
                int multEx = thisEntry.getKey() + pEntry.getKey();
                Monomial curr = output.monomials.getOrDefault(multEx, new Monomial(multEx, new IntegerScalar(0)));
                output.monomials.put(multEx, curr.add(thisEntry.getValue().mul(pEntry.getValue())));
            }
        }
        return output;
    }

    public Scalar evaluate(Scalar s) {
        Scalar output = new IntegerScalar(0);
        for (var entry : monomials.entrySet()) {
            output = output.add(entry.getValue().evaluate(s));
        }
        return output;
    }

    public Polynomial derivative() {
        Polynomial output = new Polynomial();
        for (var entry : monomials.entrySet()) {
            if (entry.getKey() > 0) {
                output.monomials.put(entry.getKey()-1, entry.getValue().derivative());
            }
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Polynomial p) {
            for (var entry : this.monomials.entrySet()) {
                if (!(entry.getValue().equals(p.monomials.get(entry.getKey())))) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        int counter = 0;
        for (var entry : monomials.entrySet()) {
            if (entry.getValue().sign() < 0) {
                if (counter > 0) output.append(" - ");
                String monomial = entry.getValue().toString();
                output.append(monomial.substring(1));
                counter++;
            } else if (entry.getValue().sign() > 0) {
                if (counter > 0) output.append(" + ");
                output.append(entry.getValue().toString());
                counter++;
            }
        }
        if (counter == 0) return "0"; // If all monomials were evaluated to zero
        return output.toString();
    }

    /// Static Methods
    public static Polynomial build(String input) {
        String regex = "\s+";
        String[] parts = input.split(regex);
        Polynomial output = new Polynomial();
        for (int i = 0; i < parts.length; i++) {
            Scalar c = stringToScalar(parts[i]);
            output.monomials.put(i, new Monomial(i, c));
        }
        return output;
    }

    private static Scalar stringToScalar(String s) {
        if (s.contains("/")) {
            // It's a rational number
            String[] parts = s.split("/");
            int numerator = Integer.parseInt(parts[0].trim());
            int denominator = Integer.parseInt(parts[1].trim());
            return new RationalScalar(numerator, denominator);
        } else {
            // It's an integer
            int value = Integer.parseInt(s.trim());
            return new IntegerScalar(value);
        }
    }

}
