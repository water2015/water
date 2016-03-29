package com.water.lock;

public class SyncTest {

	public static void main(String[] args) {
		new LoggingWidget().doSomething();
	}

}
class Widget {
	public synchronized void doSomething() {
		System.out.println("Widget");
	}
}

class LoggingWidget extends Widget {
	public synchronized void doSomething() {
		System.out.println("LoggingWidget");
		super.doSomething();
	}
}
