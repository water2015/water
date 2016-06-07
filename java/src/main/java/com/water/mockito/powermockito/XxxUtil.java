package com.water.mockito.powermockito;

import java.io.File;

public class XxxUtil {

	public static boolean isSafe(int i) {
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	private String name = "XxxUtil";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void sleep(long time) throws Exception {
		Thread.sleep(time);
	}

	public static void readFile(String filename) throws Exception {
		File file = new File(filename);
		System.out.println(file.getAbsolutePath());
	}
}
