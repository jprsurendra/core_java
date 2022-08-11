package com.ssr.streamapis;



import java.util.Arrays;
import java.util.List;

/**
 *      The Java Stream API provides a functional approach to processing collections of objects.
 *      First of all, Java 8 Streams should not be confused with Java I/O streams (ex: FileInputStream etc);
 * these have very little to do with each other. So, the Java Stream API is not related to the Java InputStream and
 * Java OutputStream of Java IO.
 *          The InputStream and OutputStream are related to streams of bytes.
 *          The Java Stream API is for processing streams of objects - not bytes.
 *      Simply put, streams are wrappers around a data source, allowing us to operate with that data source and making
 * bulk processing convenient and fast. A stream does not store data and, in that sense, is not a data structure.
 * It also never modifies the underlying data source.
 */
public class StreamAPITutorial {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,7,8,1,5,9);
        int sum = 0;

        // flow of execution is sequential, It is not a parallel execution
        for(int no: numbers){
            sum=sum+no;
        }
        System.out.println(sum);

        int sum1 = numbers.stream().mapToInt(i->i).sum();
        System.out.println(sum1);
    }

}
