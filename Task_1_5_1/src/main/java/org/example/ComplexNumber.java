package org.example;

import java.util.Scanner;
import java.util.Stack;

/**
 * ComplexNumber.
 */
public class ComplexNumber {
    private double real;
    private double imag;

    /**
     * ComplexNumber.
     */
    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * getReal.
     */
    public double getReal() {
        return real;
    }

    /**
     * getImag.
     */
    public double getImag() {
        return imag;
    }

    /**
     * add.
     */
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imag + other.imag);
    }

    /**
     * subtract.
     */
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imag - other.imag);
    }

    /**
     * multiply.
     */
    public ComplexNumber multiply(ComplexNumber other) {
        double resultReal = real * other.real - imag * other.imag;
        double resultImag = real * other.imag + imag * other.real;
        return new ComplexNumber(resultReal, resultImag);
    }

    /**
     * divide.
     */
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imag * other.imag;
        if (denominator == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        double resultReal = (real * other.real + imag * other.imag) / denominator;
        double resultImag = (imag * other.real - real * other.imag) / denominator;
        return new ComplexNumber(resultReal, resultImag);
    }

    /**
     * isZero.
     */
    public boolean isZero() {
        return real == 0 && imag == 0;
    }

    /**
     * log.
     */
    public static ComplexNumber log(ComplexNumber z) {
        double magnitude = Math.sqrt(z.real * z.real + z.imag * z.imag);
        double angle = Math.atan2(z.imag, z.real);
        return new ComplexNumber(Math.log(magnitude), angle);
    }

    /**
     * pow.
     */
    public static ComplexNumber pow(ComplexNumber z, double exponent) {
        double magnitude = Math.pow(Math.sqrt(z.real * z.real + z.imag * z.imag), exponent);
        double angle = exponent * Math.atan2(z.imag, z.real);
        return new ComplexNumber(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
    }

    /**
     * sqrt.
     */
    public static ComplexNumber sqrt(ComplexNumber z) {
        double magnitude = Math.sqrt(z.real * z.real + z.imag * z.imag);
        double angle = 0.5 * Math.atan2(z.imag, z.real);
        return new ComplexNumber(Math.sqrt(magnitude) * Math.cos(angle), Math.sqrt(magnitude) * Math.sin(angle));
    }

    /**
     * sin.
     */
    public static ComplexNumber sin(ComplexNumber z) {
        return new ComplexNumber(Math.sin(z.real) * Math.cosh(z.imag), Math.cos(z.real) * Math.sinh(z.imag));
    }

    /**
     * cos.
     */
    public static ComplexNumber cos(ComplexNumber z) {
        return new ComplexNumber(Math.cos(z.real) * Math.cosh(z.imag), -Math.sin(z.real) * Math.sinh(z.imag));
    }

    /**
     * toString.
     */
    @Override
    public String toString() {
        if (isZero()) {
            return "0";
        } else if (imag == 0) {
            return String.format("%.2f", real);
        } else if (real == 0) {
            return String.format("%.2fi", imag);
        } else {
            String sign = (imag > 0) ? "+" : "-";
            return String.format("%.2f %s %.2fi", real, sign, Math.abs(imag));
        }
    }
}
