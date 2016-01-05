package com.water.jdk.java8;

import java.util.function.BiFunction;

public class BiFunctionT {

	public static void main(String[] args) {
		BiFunction<String, String, String> bi = (x, y) -> {
			return x + y;
		};

		System.out.println(bi.apply("java2s.com", " tutorial"));

		Calculator calculator = new Calculator();
		String result = calculator.calc((a, b) -> " : " + (a * b), 3, 5);

		System.out.println(result);
	}
}

class Calculator {
	public String calc(BiFunction<Integer, Integer, String> bi, Integer i1, Integer i2) {
		return bi.apply(i1, i2);
	}
}
