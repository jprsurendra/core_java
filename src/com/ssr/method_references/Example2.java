package com.ssr.method_references;

import java.util.concurrent.TimeUnit;

public class Example2 {
    public static void threadRunStatic(){
        System.out.println("Thread is running... we are using predefined functional interface Runnable to refer static method ... 666");
    }
    public  void threadRunNoneStatic(){
        System.out.println("Thread is running... we are using predefined functional interface Runnable to refer none static method ... 777");
    }

    public static void main_thread_example(String[] args) {
        Runnable task = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }

    public static void main(String[] args) {
        // pre java 8 lambdas
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("In the Thread's run method.....111");
            }
        });
        t1.start();

        Runnable runnable = () -> {
            System.out.println("In the Thread's run method.....222");
        };
        Thread t11 = new Thread(runnable);
        t11.start();



        Thread t3 = new Thread() {
            public void run() {
                System.out.println("In the Thread's run method.....333");
            }
        };
        t3.start();
        //
        Thread t31 = new Thread(() -> {
            System.out.println("Here’s the Java 8 Thread lambda syntax (without a Runnable).....444");
        });
        t31.start();

        /*
        You can also use this lambda approach to create a Thread, without creating a reference (variable) to the thread:
        new Thread(() -> ... your code here ... ).start();
        */
        new Thread(() -> {
            System.out.println("Here’s the Java 8 Thread lambda syntax (without a Runnable).....555");
        }).start();


        Thread t32=new Thread(Example2::threadRunStatic);
        t32.start();

        Thread t33=new Thread(new Example2()::threadRunNoneStatic);
        t33.start();


    }
}
