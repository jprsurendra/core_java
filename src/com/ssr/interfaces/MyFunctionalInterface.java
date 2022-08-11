package com.ssr.interfaces;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *      The term Java functional interface was introduced in Java 8. It is implemented using the annotation called
 * @FunctionalInterface. It ensures that the interface should have only one abstract method. The usage of the abstract
 * keyword is optional as the method defined inside interface is by default abstract.
 *      --> A functional interface in Java is an interface that contains only a single abstract (unimplemented) method.
 *      --> A functional interface can contain default and static methods which do have an implementation,
 *  in addition to the single unimplemented method.
 *
 *      An Interface that contains exactly one abstract method is known as functional interface. It can have any number of default, static methods but can contain only one abstract method. It can also declare methods of object class.
 * Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces.
 *
 */

public interface MyFunctionalInterface {
    /**
     * FunctionalInterface should contains only a single non-implemented method.
     */
    public void execute();

    public default void print(String text) {
        System.out.println(text);
    }

    public static void print(String text, PrintWriter writer) throws IOException {
        writer.write(text);
    }

}


