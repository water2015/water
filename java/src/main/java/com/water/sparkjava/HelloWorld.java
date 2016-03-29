package com.water.sparkjava;

import spark.Spark;

class HelloWorld {
	public static void main(String[] args) {
		Spark.port(9001);
		Spark.externalStaticFileLocation("C:\\Mine");
		Spark.get("/gsst", (req, res) -> "GSST Said : \"Hello World!!!\"");

		System.out.println("=====================");
		System.out.println("=====================");
		System.out.println("=====================");
	}
}