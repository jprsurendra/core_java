package com.ssr.method_references;

interface ConstructorReference<T> {
    T constructor2();
}

interface  MethodReference {
    void anotherMethod(String input);
}

class ConstructorDemoClass {
    String value;

    public ConstructorDemoClass() {
        value = "default";
    }

    public void method(String input) {
        System.out.println(input);
    }

    public void nextMethod(String input) {
        // operations
    }
}


public class MethodReferenceSample {

    public static void main(String... args) {
        // constructor reference
        ConstructorReference reference = ConstructorDemoClass::new;
        ConstructorDemoClass cc = (ConstructorDemoClass) reference.constructor2();

        // static method reference
        MethodReference mr = cc::method;

        // object method reference
        MethodReference mr2 = cc::nextMethod;

        System.out.println(cc.value);
    }
}