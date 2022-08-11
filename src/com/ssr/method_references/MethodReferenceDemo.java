package com.ssr.method_references;


/*
Java Method References
----------------------
    Java provides a new feature called method reference in Java 8. Method reference is used to refer method of
functional-interface. It is compact and easy form of lambda expression. Each time when you are using lambda expression
to just referring a method, you can replace your lambda expression with method reference. In this tutorial, we are
explaining method reference concept in detail.

Types of Method References: There are following types of method references in java:
1. Reference to a static method.
2. Reference to an instance method.
3. Reference to a constructor.


1. Reference to a static method.
=================================
 */

@FunctionalInterface
interface Sayable{
    void say();
}
public class MethodReferenceDemo {
    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }
    public static void main(String[] args) {
        // Referring static method
        Sayable sayable = MethodReferenceDemo::saySomething;
        // Calling interface method
        sayable.say();
    }
}
