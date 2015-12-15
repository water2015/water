package com.water.java8;

import java.util.function.Predicate;

public class PredicateT {

	public static void main(String[] args) {
		Predicate<String> i = (s) -> s.length() > 5;
		Predicate<String> j = (s) -> s.length() < 3;
		System.out.println(i.or(j).and(j).test("java2s.com "));

		Predicate<String> t = Predicate.isEqual("asdf");
		System.out.println(t.test("java2s.com "));
	}

}
