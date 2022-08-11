package com.ssr.interfaces;

/**
 *  The static methods in interfaces are similar to default methods but the only difference is that you can’t override them.
 */
interface Vehicle {

    static void cleanVehicle(){
        System.out.println("I am cleaning vehicle");
    }
}

class Car implements Vehicle {
    /**
     *  In the following code, we get a compilation error in the Car class because a static method cannot be overridden.
     */
    /* @Override
    public void cleanVehicle() {
        System.out.println("Cleaning the vehicle");
    } */
}


public class StaticMethodsInInterfacesExample implements Vehicle{
    public static void main(String[] args) {
        Vehicle.cleanVehicle(); //This will compile.
        /**
         * since a static method is hidden, we can’t call it from the object of the implementing class. The below code will also not compile.
         */
        /*
            Car car = new Car();
            car.cleanVehicle();
        */
    }
}
