package com.example.SpringWebApplication.service;

import java.util.stream.Stream;

public class Java8 {
    public static void main(String s[]){
        fabonacciUsingSupplier();
    }

    private static void fabonacciUsingSupplier(){
        int[] i  = {0,1};
        Stream<Integer> fabonacciSeries = Stream.generate(() -> {
            int result = i[1];
            int temp = i[1];
            i[1] = i[0] + i[1];
            i[0] = temp;
            return result;
        });
        fabonacciSeries.limit(5).forEach( num -> System.out.println(num));
    }
}
