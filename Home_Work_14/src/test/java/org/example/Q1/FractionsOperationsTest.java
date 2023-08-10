package org.example.Q1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionsOperationsTest {
    @Test
    void addingTwoFractions(){
        Fraction fraction = new Fraction();
        fraction.setNumerator(3);
        fraction.setDenominator(4);
        Fraction fraction2 = new Fraction();
        fraction2.setNumerator(5);
        fraction2.setDenominator(5);
        assertEquals("8/20", FractionsOperations.add(fraction, fraction2));
    }

    @Test
    void subtractionTwoFractions(){
        Fraction fraction = new Fraction();
        fraction.setNumerator(3);
        fraction.setDenominator(4);
        Fraction fraction2 = new Fraction();
        fraction2.setNumerator(5);
        fraction2.setDenominator(5);
        assertEquals("-2/20", FractionsOperations.sub(fraction, fraction2));
    }

    @Test
    void multiplierTwoFractions() {
        Fraction fraction = new Fraction();
        fraction.setNumerator(3);
        fraction.setDenominator(4);
        Fraction fraction2 = new Fraction();
        fraction2.setNumerator(5);
        fraction2.setDenominator(5);
        assertEquals("15/20", FractionsOperations.mul(fraction, fraction2));
    }

    @Test
    void divitionTwoFractions(){
        Fraction fraction = new Fraction();
        fraction.setNumerator(3);
        fraction.setDenominator(4);
        Fraction fraction2 = new Fraction();
        fraction2.setNumerator(5);
        fraction2.setDenominator(5);
        assertEquals("15/20", FractionsOperations.div(fraction, fraction2));
    }


    @Test
    void toFloatingPoint(){
        Fraction fraction = new Fraction();
        fraction.setNumerator(4);
        fraction.setDenominator(2);

        assertEquals(2.0, FractionsOperations.toFloatingPoint(fraction));
    }
}