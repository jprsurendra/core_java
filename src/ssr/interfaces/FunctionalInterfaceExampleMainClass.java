package com.ssr.interfaces;

interface NormalInterface{
    public int add(int x, int y);
    public int subtract(int x, int y);

}

class NormalImplementation implements NormalInterface{
    @Override
    public int add(int x, int y) {
        return x+y;
    }
    @Override
    public int subtract(int x, int y) {
        return x-y;
    }
}


class FunctionalInterfaceImplementation implements MyFunctionalInterface{
    @Override
    public void execute() {
        System.out.println("Executing... in FunctionalInterfaceImplementation ");
    }
}


public class FunctionalInterfaceExampleMainClass {
    public static void main(String[] args) {
        int a=10, b=15;
        NormalImplementation normal_implementation = new NormalImplementation();
        System.out.println("a: " +  a + ", b: " + b);
        a = normal_implementation.add(a, b);
        System.out.println("a: " +  a + ", b: " + b);
        a = normal_implementation.subtract(a, b);
        System.out.println("a: " +  a + ", b: " + b);

        MyFunctionalInterface implementation = new FunctionalInterfaceImplementation();
        implementation.execute();
        implementation.print("AAAAAAAAA");


        /**
         *      Functional Interfaces Can Be Implemented by a Lambda Expression
         *      A Java lambda expression implements a single method from a Java interface. In order to know what method
         * the lambda expression implements, the interface can only contain a single unimplemented method. In other words,
         * the interface must be a Java functional interface.
         */
        MyFunctionalInterface implementation_by_lambda = () -> {
            System.out.println("Executing...");
        };
        implementation_by_lambda.execute();
        implementation_by_lambda.print("SSSSSSSSS");
    }
}
