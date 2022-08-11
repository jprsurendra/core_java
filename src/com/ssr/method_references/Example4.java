package com.ssr.method_references;

import java.util.function.BiFunction;

@FunctionalInterface
interface Operation{
    int calculate(int x, int y);
}


public class Example4 {
    public static int result(int x, int y, Operation opt) {
        return opt.calculate(x, y);
    }

    public static void main(String[] args) {
        int a=200;
        int b= 10;
        int num = 0;
        System.out.println("-----------------------------------");

        num = result(a, b, (p, q) -> (p+q));
        System.out.println("Addition: (" + a + ", " + b + ") => " + num);
        System.out.println("-----------------------------------");

        num = result(a, b, (p, q) -> (p-q));
        System.out.println("Substitution: (" + a + ", " + b + ") => " + num);
        System.out.println("-----------------------------------");

        num = result(a, b, (p, q) -> (p*q));
        System.out.println("Multiplication: (" + a + ", " + b + ") => " + num);
        System.out.println("-----------------------------------");

        num = result(a, b, (p, q) -> (p/q));
        System.out.println("Division: (" + a + ", " + b + ") => " + num);
        System.out.println("===================================");
    }
}
