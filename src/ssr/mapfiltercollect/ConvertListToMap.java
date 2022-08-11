package com.ssr.mapfiltercollect;

import com.ssr.dto.Book;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListToMap {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("0061964360", "Pride and Prejudice (Teen Classics)", 2009, 9.82F, "Softcover", "HarperTeen"));
        books.add(new Book("0143105426", "Pride and Prejudice (Teen Classics)", 2009, 12.58F, "Softcover", "Penguin Classics"));
        books.add(new Book("0199535566", "Pride and Prejudice (Oxford World's Classics)", 2008, 47.8F, "Softcover", "Oxford University Press"));

        /*
         *  1. Here is how you can convert a List to Map in Java 5, 6 or 7:
         */
        final Map hashMap = new HashMap();
        for (final Book book : books) {
            hashMap.put(book.getISBN(), book);
        }
        System.out.println("Method 1: " + hashMap);

        /*
        *   2. Now, let's see how we can do the same in Java 8 by using lambda expression and Stream API, here is my first attempt:
        *       books.stream()  -->  returns a stream of Book object from the list
        *       and then I have used collect() method of Stream class to collect all elements.
        *
        *       I have passed the method Collectors.toMap(), which means elements will be collected in a Map, where the key will be ISBN code and value will be the object itself. We have used a lambda expression to simplify the code.
        */
        Map<String, Book> result1 = books.stream()
                                        .collect(Collectors.toMap(book -> book.getISBN(), book -> book));
        System.out.println("Method 2: " + result1);

        /*
        *   3. Using Java 8 method reference: You can further simplify the code in Java 8 by using method reference, as shown below:
        * Here we have called the getISBN() method using method reference instead of using a lambda expression.
        */
        Map<String, Book> result2 =  books.stream()
                                            .collect(Collectors.toMap(Book::getISBN, b -> b));
        System.out.println("Method 3: " + result2);

        /*
         *   4. You can further remove the last remaining lambda expression from this code, where we are passing the
         * object itself by using Function.identify() method in Java 8 when the value of the Map is the object itself,
         * as shown below:
         */
        Map<String, Book> result3 = books.stream()
                                        .collect(Collectors.toMap(Book::getISBN, Function.identity()));
        System.out.println("Method 4: " + result3);
        /*
        *Note: identity syntax
        *       static <T> Function<T, T> identity() {
        *               return t -> t;
        *       }
        */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //this will compile fine
        int[] arrayOK = list.stream().mapToInt(i -> i).toArray();
        /* but if you try to compile: you will get compilation error since mapToInt expects ToIntFunction,
        *  which is not related to Function. Also ToIntFunction doesn't have identity() method.
        int[] arrayProblem = list.stream().mapToInt(Function.identity()).toArray();
        */


        /*


        List cards = Arrays.asList("Visa", "MasterCard", "American Express", "Visa");
        System.out.println("list: " + cards);
        Map cards2Length = cards.stream().collect(Collectors.toMap(Function.identity(), String::length));
        Map cards2Length = cards.stream().collect(Collectors.toMap(Function.identity(), String::length, (e1, e2) -> e1));
        System.out.println("map: " + cards2Length);

         */

    }
    //Here is how you can convert a List to Map in Java 5, 6 or 7:
    public static  Map<String, Book> toMap(List<Book> books) {
        final Map hashMap = new HashMap();
        for (final Book book : books) {
            hashMap.put(book.getISBN(), book);
        }
        return hashMap;
    }
}
