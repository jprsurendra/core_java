package com.ssr.method_references;

import java.util.function.BiFunction;

/*
@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}
*/

//@FunctionalInterface
class ArithmeticOperation{
    public static int addition(int a, int b){
        return a+b;
    }
    public static int substitution(int a, int b){
        return a-b;
    }
    public static int multiplication(int a, int b){
        return a*b;
    }
    public static int division(int a, int b){
        return a/b;
    }

    /*
    You can also override static methods by referring methods.
    In the following example, we have defined and overloaded three add methods.
     */
    public static float addition(int a, float b){
        return a+b;
    }
    public static float addition(float a, float b){
        return a+b;
    }

}
/*
    Example of MethodReference
 */
public class Example3 {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> objAddition = ArithmeticOperation::addition;
        int result = objAddition.apply(20, 10);
        System.out.println(result);

        BiFunction<Integer, Integer, Integer> objSubstitution = ArithmeticOperation::substitution;
        result = objSubstitution.apply(20, 10);
        System.out.println(result);

        BiFunction<Integer, Integer, Integer> objMultiplication = ArithmeticOperation::multiplication;
        result = objMultiplication.apply(20, 10);
        System.out.println(result);

        BiFunction<Integer, Integer, Integer> objDivision = ArithmeticOperation::division;
        result = objDivision.apply(20, 10);
        System.out.println(result);



        BiFunction<Integer, Float, Float> objAddition2 = ArithmeticOperation::addition;
        float sum = objAddition2.apply(20, 10.0f);
        System.out.println(sum);
        BiFunction<Float, Float, Float> objAddition3 = ArithmeticOperation::addition;
        sum = objAddition3.apply(20.0f, 10.0f);
        System.out.println(sum);
    }
}
