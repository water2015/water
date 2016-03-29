package com.water;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

import com.water.csv.CsvReader;

public class A {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub 

		System.out.println(Arrays.asList("Rates^Basis Spreads","Rates^Inflation","Rates^Delta/Gamma").contains("Rates^Basis Spreads"));
		
		String[] a = StringUtils.splitByWholeSeparatorPreserveAllTokens("adfs^!^^!^Other Credit^!^^Corporate Credit (Emerging Markets)^!^Loans CDS and Single-Name CDS_Down_PL", "^!^");
		String[] b = "^^^^Other Credit^^Corporate Credit (Emerging Markets)^^Loans CDS and Single-Name CDS_Down_PL".split("^^");
		
		System.out.println(a.length);
		System.out.println(b.length);
		
		String c = "CBNA Toronto";
		System.out.println(c == "CBNA Toronto"); 
		
		String water = "";
		System.out.println(water.replaceAll(System.getProperty("line.separator"), ""));
		
		CsvReader csv =new CsvReader("a.txt");
		csv.readHeaders();
		System.out.println(csv.getRawRecord().replaceAll("\\r\\n|\\r|\\n", " "));
	}

}
