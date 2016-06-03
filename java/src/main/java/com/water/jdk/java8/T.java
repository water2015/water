package com.water.jdk.java8;

import java.util.Arrays;
import java.util.function.Function;

public class T {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Integer> times2 = e -> e * 2;

		Function<Integer, Integer> squared = e -> e * e;

		System.out.println(times2.compose(squared).apply(4));
		// Returns 32

		System.out.println(times2.andThen(squared).apply(4));
		// Returns 64

		System.out.println(Arrays.asList("B2_AFS~B2_SEC~B2NCR~CPBAFS".split("~")).get(3));
	}
}
