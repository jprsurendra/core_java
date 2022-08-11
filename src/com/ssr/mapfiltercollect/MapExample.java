package com.ssr.mapfiltercollect;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Source: https://dzone.com/articles/how-to-use-map-filter-collect-of-stream-in-java-8
 *          https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html?fbclid=IwAR0Xgjf57IOaOFXNDFC0WnHDhjg8ZMkcOkWnS1A_rwN45UXmKCdj53UXYMo
 *
 *      The map() function is a method in the Stream class that represents a functional programming concept. In simple
 * words, the map() is used to transform one object into other by applying a function.
 *      That's why the Stream.map(Function mapper) takes a function as an argument.
 *
 *      For example, by using the map() function, you can convert a list of String into a List of Integer by applying
 * the Integer.valueOf() method to each String on the input list.
 *      Problem/Example: I have a list of String: numbers e.g. {"1", "2", "3", "4", "5", "6"}. I want to process this
 * list and need another List of Integer with just even numbers.
 *      List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
 *
 *      1. In order to find the even numbers, I first need to convert a List of String to a List of Integer. For that,
 * I can use the map() method of java.util.Stream class. You can get the stream from any collection, e.g. List or Set,
 * by calling the stream() method, which is defined in the java.util.Collection interface.
 *      numbers.stream()
 *
 *      2. The map(Function mapper) method takes a Function, technically speaking, an object of
 * java.util.function.Function interface. This function is then applied to each element of Stream to convert it into the
 * type you want.
 *      Because we need to convert a String to an Integer, we can pass either the Integer.parseInt() or Integer.valueOf()
 * method to the map() function. I have chosen the valueOf() method because of performance and caching.
 *      numbers.stream().map(s -> Integer.valueOf(s))
 *
 *      3. The map() will then return a Stream of Integer that contains both even and odd numbers. To select just
 * even numbers, we can use the filter() method.
 *      It takes a predicate object which is technically a function to convert an object to boolean. We pass an object
 * and it will return true or false. The filter, then uses that information to include the object in the result stream.
 *      To include only even numbers, we call filter( number -> number%2==0), which means each number will be divided by
 * two, and if there is no remainder, it will be selected.
 *      numbers.stream().map(s -> Integer.valueOf(s)).filter(number -> number % 2 == 0)
 *
 *      4. We are almost done. But, so far, we only have the Stream of even integers — not the List of even Integers and
 * that's why we need to use them. Since we need a List, I called collect(Collectors.toList()), which will accumulate
 * all even numbers into a List and return.
 *      numbers.stream().map(s -> Integer.valueOf(s)).filter(number -> number % 2 == 0).collect(Collectors.toList())
 *
 *      Now, you may be thinking: how does it know to return List of Integer? Well, we need to get that information by
 * Type inference, because we have already specified that information by storing the result into a List<Integer>.
 *
 */
public class MapExample {
    public static void example_01_string_array_to_int_array() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        System.out.println("original list: " + numbers);

        List<Integer> even = numbers.stream()
                .map(s -> Integer.valueOf(s))
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("processed list, only even numbers: " + even);

        List<Integer> odd = numbers.stream()
                .map(s -> Integer.valueOf(s))
                .filter(number -> !(number % 2 == 0))
                .collect(Collectors.toList());

        System.out.println("processed list, only even numbers: " + odd);

    }
    /*
     *      This is an excellent example to demonstrate how you can filter specific objects from Collection and create a subset of elements that satisfy the given criterion.
     * strList.stream() returns a Stream, and then we use the filter() method, which accepts a Predicate (Which is a
     * functional interface, with just one abstract method: boolean test()). we can pass lambda expression instead of an
     * instance of the Predicate interface. Here we can define code to specify a condition.
     *      This code will go to the test() method of Predicate and will be applied to each element during internal
     * iteration. All Strings which are empty are counted by the count() method, which is a terminal operation.
     *
     *      After this line, you can not call any method on this Stream. Remember filter() is a tricky method, it does
     * not filter element from the original collection; instead, it selects item which satisfies criterion and returns
     * them in new Collection.
     *
     */
    public static void example_02_filter( List<String> strList) {
        // Counting Empty String
        long count = strList.stream()
                .filter(x -> x.isEmpty()).count();
        System.out.println("No of empty strings: " + count);

        // Count String whose length is more than three
        count = strList.stream()
                .filter(x -> x.length()> 3).count();
        System.out.println("Count String whose length is more than three: " + count);

        // Count number of String which starts with "a"
        count = strList.stream()
                .filter(x -> x.startsWith("a")).count();
        System.out.println("Count number of String which starts with \"a\": " + count);


    }
    /*  Remove all empty Strings from List:
     *       Now, this example is a little bit different than the previous three. Here we are again using the filter()
     * method to create a subset of all strings, which is non-empty, but instead of counting, we are now calling the
     * static utility method Collectors.toList() to return them as List.
     *      The Collectors class is very similar to the java.util.Collections class, full of static methods, which you
     * can use along with Collection. You can wrap filtered elements into a Set or List by using the Collectors class.
     */
    public static void example_03_collect( List<String> strList) {
        List<String> filtered = strList.stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);

        filtered = strList.stream()
                .filter(x -> x.length()> 2)
                .collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
    }

    /*      So far, we have seen examples of the only the filter() method, in this example, we will learn how to use
     * the map() function.
     *      This is similar to the Map concept of functional programming paradigm, like here we are converting each
     * String to upper case, and then finally, we have joined all String using the Collectors.joining(",") method,
     * another utility method from Java 8, which can join String by using given delimiter.
     *
     */
    public static void example_04_map_functional_example( ) {
        List<String> g7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");

        List<String> filtered = g7.stream()
                .filter(x -> x != null)
                .collect(Collectors.toList());
        System.out.println("g7Countries Filtered List: " + filtered);

        String g7Countries = g7.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println("Convert String to Uppercase and join them using comma: " + g7Countries);

        // Create a List of the square of all distinct numbers
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream()
                                .map( i -> i*i )     // mapping each element to their square
                                .distinct()          // filtering out all duplicate elements by calling the distinct() method.
                                .collect(Collectors.toList());  // Finally, by using the collect() method, we are gathering output into a List.

        System.out.println("List of the square of all distinct numbers: " + distinct);


        /*Statistics Example: Get count, min, max, sum, and the average for numbers
         *      we will learn how to get some statistical data from Collection, e.g. finding the minimum or
         * maximum number from List, calculating the sum of all numbers from a numeric list, or calculating
         * the average of all numbers from List.
         *      Since these statistics operations are numeric in nature, it's essential to call the mapToInt() method.
         *      After this, we call the summaryStatistics(), which returns an instance of an IntSummaryStatistics.
         *      It is this object which provides us utility method like getMin(), getMax(), getSum() or getAverage().
         */
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream() .mapToInt((x) -> x) .summaryStatistics();
        System.out.println("SummaryStatistics: " + stats);
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }
    public static void main(String[] args) {

        example_01_string_array_to_int_array();

        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        example_02_filter(strList);
        example_03_collect(strList);

        example_04_map_functional_example();

    }

}
/*
Output

*/