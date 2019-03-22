package com.example.SpringWebApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String s[]){
        convertArrayToListTraditional();
    }

    private static void convertArrayToListTraditional(){
        Integer[] arr = new Integer[]{1,2,3};
        List<Integer> list = Arrays.asList(arr);
        list.forEach(System.out::println);
    }

    /**
     * Using Collections.addAll
     */
    private static void convertArrayToList(){
        Integer[] arr = new Integer[]{1,2,3};
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, arr);
        list.add(4);
        list.forEach(System.out::println);
    }
    /**
     * Using Java 8 Streams
     */
    private static void ConvertArrayToListUsingStreams(){
        Integer[] arr = new Integer[]{1,2,3};
        List<Integer> list = Arrays.stream(arr).collect(Collectors.toList());
        list.add(4);
        list.forEach(System.out::println);
    }
}
