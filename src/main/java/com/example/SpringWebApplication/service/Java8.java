package com.example.SpringWebApplication.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {
    public static void main(String s[]){
        consumer();
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

    private static void fabonacciUsingIterator(){
        int limit = 10;
        List<Integer> list = Stream.iterate(new int[]{0,1}, i -> new int[]{i[1], i[0] + i[1]})
        .limit(limit)
        .map(i-> i[0])
        .collect(Collectors.toList());
        list.forEach(System.out :: println);
    }

    private static void consumer(){
        Consumer<String> printingConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        List<String> strList = Arrays.asList("A", "B", "C");
        strList.forEach(printingConsumer);
    }
}
