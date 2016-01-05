package com.water.jdk.java8;

import java.util.function.Consumer;

public class ConsumerT {

	public static void main(String[] args) {
		Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
		c.andThen(c).accept("Java2s.com");
	}
}
