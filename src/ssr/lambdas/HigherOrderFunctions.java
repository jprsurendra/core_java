package com.ssr.lambdas;


import java.util.*;

/**
 * A higher order function is a function that either takes a function (method) as parameter, or returns a function after its execution. In this higher order tutorial I will show a few examples of higher order functions in Java.
 */
public class HigherOrderFunctions {
    public static void main(String[] args) {
        /**
         *      The first example of a higher order function is the Collections.sort() method which takes a Comparator as parameter.
         *      The Collection.sort() takes two parameters. The first parameter is a List and second parameter is a lambda (function). The lambda parameter is what makes Collections.sort() a higher order function.
         */

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Abc");
        list.add("BCD");

        Collections.sort(list, (String a, String b) -> {
            return a.compareTo(b);
        });

        System.out.println(list);


        /**
         *      Here is another example of a higher order function. This time it is a function that returns another function as result.
         *
         *      This example first creates a Java lambda expression that implements the Comparator interface.
         *
         *      Second, the example calls the reversed() method on the Comparator lambda. The reversed() method returns a new Comparator lambda, which reverse the result returned by the first Comparator implementation. By "reversing" I mean that it simply returns -1 * comparator.compare(a,b)
         *
         *      Because the reversed() method returns a lambda (function), the reversed() method is considered a higher order function.
         *
         *      Third, the example sorts the List of Strings using the Collections.sort() method.
         */

        Comparator<String> comparator = (String a, String b) -> {
            return a.compareTo(b);
        };

        Comparator<String> comparatorReversed = comparator.reversed();

        Collections.sort(list, comparatorReversed);

        System.out.println(list);
    }
}
