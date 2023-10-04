package org.example;

public class Main {
    public static void main(String[] args) {
        var p1 = new Polynomial(new int[] {4, 3, 6, 7});
        var p2 = new Polynomial(new int[] {3, 2, 8});

        System.out.println(p1.plus(p2.differentiate(1)).toString());
        System.out.println(p1.times(p2).evaluate(2));
    }
}
