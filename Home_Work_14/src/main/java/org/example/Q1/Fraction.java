package org.example.Q1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class Fraction {
    private int numerator;

    private int denominator;

    public String toString() {
        return numerator + "/" + denominator;
    }
}
