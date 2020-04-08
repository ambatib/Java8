package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());

		System.out.println(collect); // [6, 7, 8, 9, 10]
		
		Predicate<Integer> noGreaterThan5 =  x -> x > 5;
        
        List<Integer> collect1 = list.stream()
                .filter(noGreaterThan5)
                .collect(Collectors.toList());

        System.out.println(collect1); // [6, 7, 8, 9, 10]
        
       // Predicate<Integer> noGreaterThan5 = x -> x > 5;
        Predicate<Integer> noLessThan8 = x -> x < 8;
        
        List<Integer> collect2 = list.stream()
                .filter(noGreaterThan5.and(noLessThan8))  //Predicate.and()
                .collect(Collectors.toList());

        System.out.println(collect2);
        
        Predicate<String> lengthIs3 = x -> x.length() == 3;
        Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> list3 = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        List<String> collect3 = list3.stream()
                .filter(lengthIs3.or(startWithA)) // Predicate.or()
                .collect(Collectors.toList());

        System.out.println(collect3);
        
        //Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> collect4 = list3.stream()
                .filter(startWithA.negate())
                .collect(Collectors.toList());  //Predicate.negate()

        System.out.println(collect4);
        Predicate<String> startWitha = x -> x.startsWith("a");

        // start with "a" or "m"
        boolean result = startWitha.or(x -> x.startsWith("m")).test("mkyong");
        System.out.println(result);     // true

        // !(start with "a" and length is 3)
        boolean result2 = startWitha.and(x -> x.length() == 3).negate().test("abc");
        System.out.println(result2);    // false

	}
}
