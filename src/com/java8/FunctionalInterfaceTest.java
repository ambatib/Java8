package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface Interf {
	public void m1();
}

@FunctionalInterface
interface AddFunction {
	public void add(int a, int b);
}

/*class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread");
		}
	}
}*/

public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		
		//Anonymous inner classes can be replaced by lambda expression
		Runnable r = ()->{
			for (int i = 0; i < 10; i++) {
				System.out.println("Child Thread");
			}
		};
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread");
		}
		Interf i = () -> System.out.println("Hello");
		i.m1();

		AddFunction add = (a, b) -> System.out.println(a + b);
		add.add(2, 3);
		
		List<Integer> l = new ArrayList<>();
		l.add(10);
		l.add(5);
		l.add(15);
		l.add(50);
		l.add(35);
		l.add(20);
		System.out.println(l);
		//Comparator<Integer> c = (i1,i2)-> (i1<i2)?-1 : (i1>i2)?1:0;
		
		l.stream().sorted().forEach(System.out::println);
		System.out.println("Even numbers::");
		l.stream().filter(i3 -> i3%2 ==0).collect(Collectors.toList()).forEach(System.out::println);
		
		//Anonymous inner classes
		
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				for (int j = 0; j < 10; j++) {
					System.out.println("Child Thread");
				}
				
			}
			
		};
		
	}

}
