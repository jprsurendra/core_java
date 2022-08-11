package com.ssr.lambdas;

/**
 *      Lambda expression is a new and important feature of Java which was included in Java SE 8.
 *      A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions
 * are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
 *      Syntax:  (argument-list) -> {body}
 *      () -> expression
 *      parameter -> expression
 *      (parameter1, parameter2, ... ) -> expression
 *      (parameter1, parameter2, ... ) -> { code block }
 *
 *      Java lambda expression is treated as a function, so compiler does not create .class file.
 */
public class LambdaExpressionExamples {
    public static void main(String[] args) {
        //by default implements abstractFun()
        FuncInterface fobj = (int x)->System.out.println(2*x);

        // This calls above lambda expression and prints 10.
        fobj.abstractFun(5);

    }
}



// A sample functional interface (An interface with single abstract method
interface FuncInterface{
    // An abstract function
    void abstractFun(int x);

    // A non-abstract (or default) function
    default void normalFun(){
        System.out.println("Hello");
    }
}
