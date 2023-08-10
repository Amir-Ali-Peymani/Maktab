package org.example.Q1;

public class FractionsOperations {


    public static String add(Fraction fraction, Fraction fraction2) {
        Fraction fractionNew = new Fraction();
        int newNumerator;
        int newDenominator;
        if (fraction.getDenominator() == fraction2.getDenominator()){
            newNumerator = fraction.getNumerator() + fraction2.getNumerator();
            fractionNew.setNumerator(newNumerator);
            fractionNew.setDenominator(fraction.getDenominator());
        }
        if (fraction.getDenominator() != fraction2.getDenominator()){
            newDenominator = fraction.getDenominator() * fraction2.getDenominator();
            fractionNew.setDenominator(newDenominator);
            fractionNew.setNumerator(fraction.getNumerator()+ fraction2.getNumerator());
        }

        return fractionNew.toString();

    }

    public static String sub(Fraction fraction, Fraction fraction2) {
        Fraction fractionNew = new Fraction();
        int newNumerator;
        int newDenominator;
        if (fraction.getDenominator() == fraction2.getDenominator()){
            newNumerator = fraction.getNumerator() - fraction2.getNumerator();
            fractionNew.setNumerator(newNumerator);
            fractionNew.setDenominator(fraction.getDenominator());
        }
        if (fraction.getDenominator() != fraction2.getDenominator()){
            newDenominator = fraction.getDenominator() * fraction2.getDenominator();
            fractionNew.setDenominator(newDenominator);
            fractionNew.setNumerator(fraction.getNumerator()- fraction2.getNumerator());
        }
        return fractionNew.toString();
    }

    public static String mul(Fraction fraction, Fraction fraction2) {
        Fraction fractionNew = new Fraction();
        int newNumerator = fraction.getNumerator() * fraction2.getNumerator();
        int newDenominator = fraction.getDenominator() * fraction2.getDenominator();
        fractionNew.setNumerator(newNumerator);
        fractionNew.setDenominator(newDenominator);

        return fractionNew.toString();

    }

    public static String div(Fraction fraction, Fraction fraction2){
        Fraction fractionNew = new Fraction();
        int newNumerator = fraction.getNumerator() * fraction2.getDenominator();
        int newDenominator = fraction.getDenominator() * fraction2.getNumerator();
        fractionNew.setNumerator(newNumerator);
        fractionNew.setDenominator(newDenominator);

        return fractionNew.toString();
    }

    public static float toFloatingPoint(Fraction fraction){
        return (float)fraction.getNumerator()/fraction.getDenominator();
    }
}
