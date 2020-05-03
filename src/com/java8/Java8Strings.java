package com.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Java8Strings {

	public static void main(String[] args) {
		Function<Integer,Integer> f = i->i*i;
		System.out.println(f.apply(2));
		Function<String, Integer> f1= s->s.length();
		System.out.println(f1.apply("Balu"));
		Predicate<Integer> p= i-> (i&1) ==0 ;
		Predicate<Integer> p1= i-> (i&1) !=0;
		System.out.println(p.test(3));
		System.out.println(p.test(2));
		System.out.println(p.and(p1).test(4));
		System.out.println(p.or(p1).test(4));
		System.out.println(p.negate().test(4));
		System.out.println(new Java8Strings().oddOrNot(2));
		int num_1 = 10;
		int num_2 = 10;
		Integer wrapnum_1 = new Integer(10);
		Integer wrapnum_2 = new Integer(10);
		System.out.println(num_1 == num_2);
		System.out.println(wrapnum_1 == wrapnum_2);
		long startTime = System.currentTimeMillis();
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("EstimatedTime::" + estimatedTime);

		long startNanoTime = System.nanoTime();
		long estimatedNanoTime = System.nanoTime() - startNanoTime;
		System.out.println("Estimated Nano Time::" + estimatedNanoTime); // Measuring relative intervals

		// slow instantiation
		String bad = new String("Yet another string object");

		// fast instantiation
		String good = "Yet another string object";

		System.out.println("H" + "a");
		System.out.println('H' + 'a');
		/**
		 * They convert character operands ( 'H'and 'a') to integer values ​​through the
		 * extension of primitive types – it turns out 169
		 */
		/**
		 * Float vs double -- Float requires only 4 bytes, but it has only 7 significant
		 * digits, while Double is twice as accurate (15 digits)
		 */
		double a = 2.1;

		double square = a * a;
		double result = Math.pow(625, 0.5); // Using library functions are not recommended always. In case of negative
											// or fractional powers

		double cube = a * a * a; // not optimized
		double optimizedcube = a * square; // optimized

		double quad = a * a * a * a; // not optimized
		double optimizedquad = square * square; // optimized

		// 1
		long startTime1 = System.nanoTime();
		int n1 = 0;
		for (int i = 0; i < 10000; i++) {
			n1 += 2 * i * i;

		}
		System.out.println(n1);
		System.out.println(System.nanoTime() - startTime1);

		// 2
		long startTime2 = System.nanoTime();
		int n2 = 0;
		for (int i = 0; i < 10000; i++) {
			n2 += 2 * (i * i);
			/**
			 * The pattern is obvious: grouping variables with parentheses speeds up the
			 * work of the program. This is due to the generation of a more efficient
			 * byte-code when multiplying the same values.
			 */
		}
		System.out.println(n2);
		System.out.println(System.nanoTime() - startTime2);

		/**
		 * Combining two hashes, iterating their values ​​manually, is very inefficient.
		 * Here is an alternative solution to this problem that you will definitely like
		 */

		Map m1 = new HashMap<>();
		Map m2 = new HashMap<>();
		m2.putAll(m1); // adds to m2 all items from m1
		System.out.println(m2);

		// JSON Serialization

		/*
		 * JSONObject obj = new JSONObject(); obj.put("Novel Name", "Godaan");
		 * obj.put("Author", "Munshi Premchand");
		 * 
		 * JSONArray novelDetails = new JSONArray();
		 * novelDetails.add("Language: Hindi");
		 * novelDetails.add("Year of Publication: 1936");
		 * novelDetails.add("Publisher: Lokmanya Press");
		 * 
		 * obj.put("Novel Details", novelDetails); System.out.print(obj);
		 */
	}

	public boolean oddOrNot(int num) {
		return (num & 1) != 0;
	}

}
