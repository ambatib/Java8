package com.java8;

import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<String> c = c1->System.out.println(c1);
		c.accept("Balu");
	}

}
