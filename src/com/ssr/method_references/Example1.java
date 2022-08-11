package com.ssr.method_references;

import java.util.function.BiFunction;

@FunctionalInterface
interface DoubleColon{
    void show();
}



class DoubleColonImplementation{
    public static void staticMethodRefrence() {
        System.out.println("Line 01. This is implementation of static method refrence");
        System.out.println("Line 02. This is implementation of static method refrence");
        System.out.println("Line 03. This is implementation of static method refrence");
    }

    public void noneStaticMethodRefrence() {
        System.out.println("Line 001. This is implementation of none-static method refrence");
        System.out.println("Line 002. This is implementation of none-static method refrence");
        System.out.println("Line 003. This is implementation of none-static method refrence");
    }

}

public class Example1 {

    public static void main(String[] args) {
        DoubleColon dc = ()-> {
                System.out.println("Line 1. This is implementation of lambda expression");
                System.out.println("Line 2. This is implementation of lambda expression");
                System.out.println("Line 3. This is implementation of lambda expression");
            };
        dc.show();
        System.out.println("-----------------------------------");

        DoubleColon dc2 = DoubleColonImplementation::staticMethodRefrence;
        dc2.show();
        System.out.println("-----------------------------------");

        DoubleColonImplementation double_colon = new DoubleColonImplementation();
        DoubleColon dc3 = new DoubleColonImplementation()::noneStaticMethodRefrence;
        dc3.show();
        System.out.println("--  --  --  --  --  --  --  --  --  --");
        DoubleColon dc4 = double_colon::noneStaticMethodRefrence;
        dc4.show();
        System.out.println("-----------------------------------");



    }
}
