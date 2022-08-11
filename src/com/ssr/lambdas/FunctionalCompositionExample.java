package com.ssr.lambdas;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 *      Link:  http://tutorials.jenkov.com/java-functional-programming/functional-composition.html
 *
 *      Functional composition is a technique to combine multiple functions into a single function which uses the combined functions internally. You can compose individual functions (typically one or more Java Lambda Expressions) into a single function yourself, but Java also comes with built-in support for functional composition to make the job easier for you. In this Java functional composition tutorial I will explain both how to compose functions from smaller functions yourself, and via Java's built-in features.
 *
 *      Several of the functional interfaces in Java already has support for functional composition built into them. The functional composition support comes in the shape of default and static methods in the functional interfaces.
 */

public class FunctionalCompositionExample {
    /**
     * This functional composition example first creates two Predicate implementations in the form of two lambda expressions. The first Predicate returns true if the String you pass to it as parameter starts with an uppercase a (A). The second Predicate returns true if the String passed to it ends with a lowercase x . Note, that the Predicate interface contains a single unimplemented method named test() which returns a boolean. It is this method the lambda expressions implement.
     *
     * After creating the two basic functions, a third Predicate is composed, which calls the test() methods of the two first functions. This third function returns true if both of the basic functions return true, and false otherwise.
     *
     * Finally, this example calls the composed function and prints out the result. Since the text both starts with an uppercase a (A) and ends with a lowercase x, the composed function will return true when called with the String "A hardworking person must relax".
     */
    public static void customFunctionalComposition() {
        Predicate<String> startsWithA = (text) -> text.startsWith("A");
        Predicate<String> endsWithX   = (text) -> text.endsWith("x");

        Predicate<String> startsWithAAndEndsWithX = (text) -> startsWithA.test(text) && endsWithX.test(text);

        String  input  = "A hardworking person must relax";
        boolean result = startsWithAAndEndsWithX.test(input);
        System.out.println(result);

    }

    /**
     * The Predicate and() method is a default method. The and() method is used to combine two other Predicate functions in the same way I showed in the beginning of this Java functional composition tutorial.
     */
    public static void javaBuiltInPredicateAndComposition() {
        Predicate<String> startsWithA = (text) -> text.startsWith("A");
        Predicate<String> endsWithX   = (text) -> text.endsWith("x");

        Predicate<String> composed = startsWithA.and(endsWithX);

        String input = "A hardworking person must relax";
        boolean result = composed.test(input);
        System.out.println(result);
    }
    public static void javaBuiltInPredicateOrComposition() {
        Predicate<String> startsWithA = (text) -> text.startsWith("A");
        Predicate<String> endsWithX   = (text) -> text.endsWith("x");

        Predicate<String> composed = startsWithA.or(endsWithX);

        String input = "A hardworking person must relax sometimes";
        boolean result = composed.test(input);
        System.out.println(result);

    }

    /**
     *      The Java Function interface (java.util.function.Function) also contains a few methods that can be used to
     * compose new Function instances from existing ones.
     *      The Function returned by compose() will first call the Function passed as parameter to compose(), and
     * then it will call the Function which compose() was called on. This is easier to understand with an example
     *      When called with the value 3, the composed Function will first call the add Function and then the multiply
     * Function. The resulting calculation will be (3 + 3) * 2 and the result will be 12.
     */
    public static void javaBuiltInFunctionComposeComposition() {
        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);

        Integer result1 = addThenMultiply.apply(3);
        System.out.println(result1);
    }

    /**
     *      The Java Function andThen() method works opposite of the compose() method. A Function composed with
     *  andThen() will first call the Function that andThen() was called on, and then it will call the Function passed
     *  as parameter to the andThen() method.
     *      Calling the Function composed by andThen() with the value 3 will result in the following calculation 3 * 2 + 3 and the result will be 9.
     */
    public static void javaBuiltInFunctionAndThenComposition() {
        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);

        Integer result2 = multiplyThenAdd.apply(3);
        System.out.println(result2);
    }

    public static void main(String[] args) {
        customFunctionalComposition();
        javaBuiltInPredicateAndComposition();

        javaBuiltInPredicateOrComposition();
        javaBuiltInFunctionComposeComposition();

        javaBuiltInFunctionComposeComposition();
        javaBuiltInFunctionAndThenComposition();

    }
}
