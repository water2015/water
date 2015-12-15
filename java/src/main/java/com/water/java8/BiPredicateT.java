package com.water.java8;

import java.util.function.BiPredicate;

public class BiPredicateT {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
		System.out.println(bi.test(2, 3));

		bi = (x, y) -> x > y;

		BiPredicate<Integer, Integer> eq = (x, y) -> x - 2 > y;

		System.out.println(bi.test(2, 3));
		System.out.println(bi.and(eq).test(2, 3));
		System.out.println(bi.and(eq).test(8, 3));
	}
}
