package com.ssr.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/*
https://www.youtube.com/watch?v=95up68d3TAw

http://tutorials.jenkov.com/java-functional-programming/functional-interfaces.html
 */

@FunctionalInterface  //It is optional
interface Square {
    int calculate(int x);
}

/**
 *  Java contains a set of functional interfaces designed for commonly occurring use cases,
 * so you don't have to create your own functional interfaces for every little use case. In the following sections
 * I will be describing some of these built-in functional interfaces in Java.
 */
public class FunctionalInterfaceExample {

    public static void lambda_expression_examples(int num ){
        System.out.println("----- lambda_expression_examples -----");
        int x1, x2, x3;

        // without lambda, Square implementation using anonymous class
        Square d1 = new Square(){
            public int calculate(int n){
                return n * n;
            }
        };

        x1 = d1.calculate(num);
        System.out.printf("Square of %s is: %s", num, x1);
        System.out.println("");
        num=num+10;

        // with lambda
        Square d2=(n)->{
                        return n * n;
                      };
        x2 = d2.calculate(num);
        System.out.printf("Square of %s is: %s", num, x2);
        System.out.println("");
        num=num+10;

        Square d3= n -> n * n;
        x3 = d3.calculate(num);
        System.out.printf("Square of %s is: %s", num, x3);
        System.out.println("");
        num=num+10;

    }

    /**
     *   The Java Consumer interface is a functional interface that represents an function that consumes a value without
     * returning any value.
     *  A Java Consumer implementation could be printing out a value, or writing it to a file, or over the network etc.
     *      Here is an example implementation of the Java Consumer & BiConsumer interface:
     *  Consumer<T>     ----> void accept(T parameter);
     *  BiConsumer<T>   ----> void accept(T parameter1, U parameter2);
     */
    public static void consumerFunctionalInterfaceExample() {
        System.out.println("----- consumerFunctionalInterfaceExample -----");
        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer>> modify = list -> {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        // Consumer to display a list of numbers
        BiConsumer<String, List<Integer> > printList = (msg, list) -> {
            System.out.print(msg);
            list.stream().forEach(a -> System.out.print(a + " "));
            System.out.println(".");
        };

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        printList.accept("List before modify: ", list);

        // Implement modify using accept()
        modify.accept(list);

        printList.accept("List after  modify: ", list);
    }

    /**
     *  The Function interface represents a method (called 'apply') that takes a single parameter (<T>) and returns a
     *  single value (<R>).
     *  Function   ----> <R> apply(T parameter);
     *  BiFunction ----> <R> apply(T parameter1, U parameter2);
     */
    public static void functionFunctionalInterfaceExample(){
        System.out.println("----- functionFunctionalInterfaceExample -----");

        Function<Integer, Boolean> isEvenNum = num -> num % 2 == 0;
        System.out.println(isEvenNum.apply(15));  // false
        System.out.println(isEvenNum.apply(22));  // true

        BiFunction<Integer, Integer, Integer> addNums = (num1, num2) -> num1+num2;
        System.out.println(addNums.apply(15, 5));  // 20
        System.out.println(addNums.apply(22, 6));  // 28
    }

    /**
     *      The Predicate interface, represents a simple function (called 'test') that takes a single value as parameter,
     * and returns true or false. Here is how the Predicate functional interface definition looks:
     *  Predicate<T>     ----> boolean test(T parameter);
     *  BiFunction<T, U> ----> boolean test(T parameter1, U parameter2);
     */
    public static void predicateFunctionalInterfaceExample(){
        System.out.println("----- predicateFunctionalInterfaceExample -----");

        Predicate<Integer> p = x -> x>50;
        System.out.println(p.test(15));  // false
        System.out.println(p.test(150)); // true

        BiPredicate<Integer, Integer> is_greater_than = (x, y) ->  x>y;
        System.out.println(is_greater_than.test(15, 10));  // true
        System.out.println(is_greater_than.test(150, 200)); // false
    }

    /**
     *      The Java UnaryOperator & BinaryOperator are functional interface that represents an operation which takes
     * (in case of UnaryOperator) a single parameter OR (in case of BinaryOperator) two same type of parameter
     * and returns a parameter of the same type. Here is an example of a Java UnaryOperator/BinaryOperator implementation:
     *      interface UnaryOperator<T> extends Function<T, T>
     *      interface BinaryOperator<T> extends BiFunction<T, T, T>
     *
     */
    public static void unaryAndBinaryFunctionalInterfaceExample(){
        System.out.println("----- unaryAndBinaryFunctionalInterfaceExample ----- ");
        UnaryOperator<Integer> nextEvenNumber = (num) -> {
            if (num % 2 == 0){
                return num+2;
            }else{
                return num+1;
            }
        };

        System.out.println("nextEvenNumber(" + 5 + ") = " + nextEvenNumber.apply(5));
        System.out.println("nextEvenNumber(" + 20 + ") = " + nextEvenNumber.apply(20) );

        BinaryOperator<Integer> sum = (num1, num2) ->  num1 + num2;
        System.out.println("sum("+ 5 +", " + 6 + ") = " + sum.apply(5, 6));
    }

    /**
     *      The Java Supplier interface is a functional interface that represents an function/method (without any parameter)
     * that supplies a value of some sorts. The Supplier interface can also be thought of as a factory interface.
     *      Here is an example implementation of the Java Supplier interface:
     *
     */
    public static void supplierFunctionalInterfaceExample(){
        System.out.println("----- supplierFunctionalInterfaceExample ----- ");
        // returns a new Integer instance with a random value between 0 and 1000.
        Supplier<Integer> randomNum = () -> new Integer((int) (Math.random() * 1000D));
        System.out.println("supplier: " + randomNum.get());
    }


    public static void main(String[] args) {
        lambda_expression_examples(10);

        predicateFunctionalInterfaceExample();
        consumerFunctionalInterfaceExample();
        functionFunctionalInterfaceExample();
        unaryAndBinaryFunctionalInterfaceExample();
        supplierFunctionalInterfaceExample();

    }


}
