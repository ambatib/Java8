package com.java8;

import java.util.stream.IntStream;

public class ParallelStream {
	public static void main(String[] args) {
		System.out.println("Normal...");
	      
		IntStream range = IntStream.rangeClosed(1, 10);
		System.out.println(range.isParallel());    
        range.forEach(System.out::println);

        System.out.println("Parallel...");

        IntStream range2 = IntStream.rangeClosed(1, 10);
        IntStream range2Parallel = range2.parallel();
        System.out.println(range2Parallel.isParallel());  
        range2.forEach(System.out::println);
	}

}
