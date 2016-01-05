package com.water.patterns;

public class SingleObjDemo {
	private static SingleObjDemo obj1 = new SingleObjDemo();

	private SingleObjDemo obj2;

	public SingleObjDemo getInstance1() {
		return obj1;
	}

	public SingleObjDemo getInstance2() {

		if (obj2 == null) {
			synchronized (SingleObjDemo.class) {
				if (obj2 == null) {
					obj2 = new SingleObjDemo();
				}
			}
		}

		return obj2;
	}
}

enum SingleObj2 {
	INSTANCE;

	public SingleObj2 getInstance() {
		return INSTANCE;
	}
}
