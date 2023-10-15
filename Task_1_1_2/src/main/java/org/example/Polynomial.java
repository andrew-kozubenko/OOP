package org.example;
import java.util.Arrays;

public class Polynomial {
    /**
     * Local array.
     */
    private final int[] coefficients;

    /**
     * Constructor.
     */
    public Polynomial(int[] coefficients) {
        if (coefficients.length == 0) {
            this.coefficients = new int[] {0};
        }
        else {
            this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
        }
    }

    /**
     * Getter
     */
    public int[] getCoefficients() {
        return Arrays.copyOf(coefficients, coefficients.length);
    }

    /**
     * Plus method.
     */
    public Polynomial plus(Polynomial second) {
        int max = Math.max(this.coefficients.length, second.coefficients.length);
        int[] res = new int[max];

        for (int i = 0; i < max; i++) {
            int cof1 = (i < this.coefficients.length) ? this.coefficients[i] : 0;
            int cof2 = (i < second.coefficients.length) ? second.coefficients[i] : 0;
            res[i] = cof1 + cof2;
        }

        return new Polynomial(res);
    }

    /**
     * Minus method.
     */
    public Polynomial minus(Polynomial second) {
        int maxLength = Math.max(this.coefficients.length, second.coefficients.length);
        int[] res = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            int thisCoefficient = (i < this.coefficients.length) ? this.coefficients[i] : 0;
            int secondCoefficient = (i < second.coefficients.length) ? second.coefficients[i] : 0;
            res[i] = thisCoefficient - secondCoefficient;
        }

        return new Polynomial(res);
    }

    /**
     * Times method.
     */
    public Polynomial times(Polynomial second) {
        int[] res = new int[this.coefficients.length + second.coefficients.length - 1];

        for (int i = 0; i < this.coefficients.length; i++) {
            for (int j = 0; j < second.coefficients.length; j++) {
                res[i + j] += this.coefficients[i] * second.coefficients[j];
            }
        }

        return new Polynomial(res);
    }

    /**
     * Evaluate.
     */
    public int evaluate(int x) {
        int result = 0;
        int powerX = 1;

        for (int coefficient : coefficients) {
            result += coefficient * powerX;
            powerX *= x;
        }

        return result;
    }

    /**
     * Part of factorial after division.
     */
    private int partial_factorial(int first, int last) {
        int result = 1;
        for (int i = first; i <= last; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Differentiate.
     */
    public Polynomial differentiate(int degree) {
        if (degree >= coefficients.length) {
            return new Polynomial(new int[] {0});
        }

        int[] res = new int[coefficients.length - degree];

        for (int i = degree; i < coefficients.length; i++) {
            res[i - degree] = coefficients[i] * partial_factorial(i - degree + 1, i);
        }

        return new Polynomial(res);
    }

    /**
     * Overrided equals method.
     */
    @Override
    public boolean equals(Object obj) {
        if (this.coefficients == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Polynomial second = (Polynomial) obj;
        return Arrays.equals(this.coefficients, second.coefficients);
    }

    /**
     * Overrided toString method.
     */
    @Override
    public String toString() {
        var string = new StringBuilder();

        for (int i = coefficients.length - 1; i >= 0; i--) {
            int coefficient = coefficients[i];
            if (coefficient != 0) {
                if (string.length() != 0) {
                    if (coefficient > 0) {
                        string.append(" + ");
                    } else {
                        string.append(" - ");
                    }
                }
                if (coefficient != 1 || i == 0) {
                    if (coefficient == -1) {
                        if (string.length() == 0) {
                            string.append("-");
                        }
                        if (i == 0) {
                            string.append(-(coefficient));
                        }
                    }
                    else if (coefficient < 0 && string.length() != 0) {
                        string.append(-(coefficient));
                    }
                    else {
                        string.append(coefficient);
                    }
                }
                if (i > 0) {
                    string.append("x");
                    if (i > 1) {
                        string.append("^").append(i);
                    }
                }
            }
        }

        if (string.length() == 0) {
            string.append("0");
        }

        return string.toString();
    }
}
