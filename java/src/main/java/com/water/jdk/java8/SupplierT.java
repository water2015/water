package com.water.jdk.java8;

import java.util.function.Supplier;

public class SupplierT {

	public static void main(String[] args) {
		Supplier<String> i = () -> "java2s.com";

		System.out.println(i.get());
	}

}
