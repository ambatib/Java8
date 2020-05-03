package com.java8;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 
 * Functional programming testing
 * 
 * @author ABalu
 *
 */
public class FunctionalProgramming {

	public static void main(String[] args) {
		Function<Person, String> findAgeGroup = p -> {
			int age = p.age;
			String ageGroup = "";
			if (age > 72)
				ageGroup = "Old";
			if (age < 40)
				ageGroup = "Young";
			return ageGroup;
		};
		Person[] persons = { new Person("Rama", 75), new Person("Krishna", 30) };
		Predicate<Person> p = p1 -> p1.age >= 60;
		Consumer<Person> c = p2 -> {
			System.out.println(p2.getName());
			System.out.println(findAgeGroup.apply(p2));
			System.out.println();
		
		};

		for (Person person : persons) {
			if (p.test(person)) {
				System.out.println(person.getName());
				System.out.println(findAgeGroup.apply(person));
				System.out.println();
			}
		}
		for (Person person2 : persons) {
			c.accept(person2);
		}

		Function<Integer, Integer> f1 = i -> 2 * i;
		Function<Integer, Integer> f2 = i -> i * i * i;
		System.out.println(f1.andThen(f2).apply(2)); // first f1 and then f2 applied
		System.out.println(f1.compose(f2).apply(2)); // first f2 and then f1 applied
		
		BiPredicate<Integer, Integer> bipre = (a,b)-> (a+b)%2 ==0;
		System.out.println(bipre.test(10, 21));
		BiFunction<String, Integer, Person> bifun = (a1,b1)-> new Person(a1,b1);
		Person per = bifun.apply("Balu", 38);
		
			
		
		

	}

}
