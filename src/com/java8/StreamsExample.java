package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

	public static void main(String[] args) {
		List<String> lines = Arrays.asList("spring", "node", "Test");

		List<String> result = lines.stream() // convert list to stream
				.filter(line -> !"Test".equals(line)) // we dont like Test
				.collect(Collectors.toList()); // collect the output and convert streams to a List
	
		result.forEach(System.out::println); // output : spring, node
		List<Person> persons = Arrays.asList(
	                new Person("mkyong", 30),
	                new Person("jack", 20),
	                new Person("lawrence", 40)
	        );
		
		Person multiresult = persons.stream()
                .filter((p) -> "jack".equals(p.getName()) && 20 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println("multiresult :" + multiresult.getName());

	        Person result1 = persons.stream()                        // Convert to steam
	                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
	                .findAny()                                      // If 'findAny' then return found
	                .orElse(null);                                  // If not found, return null

	        System.out.println(result1);
	        
	        Person result2 = persons.stream()
	                .filter(x -> "ahmook".equals(x.getName()))
	                .findAny()
	                .orElse(null);

	        System.out.println(result2);
	        
	        
	        String name = persons.stream()
	                .filter(x -> "jack".equals(x.getName()))
	                .map(Person::getName)                        //convert stream to String
	                .findAny()
	                .orElse("");

	        System.out.println("name : " + name);

	        List<Integer> collect = persons.stream()
	                .map(Person::getAge)
	                .collect(Collectors.toList());

	        collect.forEach(System.out::println);
	}

}
