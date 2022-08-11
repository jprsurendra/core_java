package com.ssr.interfaces;


/**
 *      Before Java 8, we could only declare abstract methods in an interface. However, Java 8 introduced the concept of
 * default methods.
 *      Default methods are methods that can have a body. The most important use of default methods in interfaces is to
 * provide additional functionality to a given type without breaking down the implementing classes.
 *
 */

interface InterfaceA {
    default void printSomething() {
        System.out.println("I am inside A interface");
    }
}

interface InterfaceB {
    default void printSomething() {
        System.out.println("I am inside B interface");
    }
}

class SingleInterfaceImplementation implements InterfaceA {

    @Override
    public void printSomething() {
        InterfaceA.super.printSomething();
    }

}


class MultiInterfaceImplementation implements InterfaceA, InterfaceB {
    /**
     *      The class (MultiInterfaceImplementation) will not compile because of the Diamond problem in Java,
     *  It will raise the compilation issue
     *      To resolve the compilation issue, we will have to implement the printSomething() method as shown below:
     */
    @Override
    public void printSomething() {
        System.out.println("I am inside MultiInterfaceImplementation, It will call to InterfaceA --> printSomething()  ");
        InterfaceA.super.printSomething();
    }

}


public class DefaultMethodsExample  {

    public static void main(String[] args) {
        SingleInterfaceImplementation a = new SingleInterfaceImplementation();
        a.printSomething();

        MultiInterfaceImplementation m = new MultiInterfaceImplementation();
        m.printSomething();

    }

}
