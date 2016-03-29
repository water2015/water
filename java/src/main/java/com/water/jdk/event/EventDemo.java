package com.water.jdk.event;

import java.util.EventListener;
import java.util.EventObject;

import javax.swing.event.EventListenerList;

public class EventDemo {
	public static void main(String[] argv) throws Exception {
		MyClass c = new MyClass();
		c.addMyEventListener(new MyEventListener() {
			public void eventOccurred(MyEvent evt) {
				System.out.println("fired 1");
			}
		});
		
		c.addMyEventListener(new MyEventListener() {
			public void eventOccurred(MyEvent evt) {
				System.out.println("fired 2");
			}
		});

		c.fireMyEvent(new MyEvent("Water"));
	}
}

class MyEvent extends EventObject {
	private static final long serialVersionUID = 1L;

	public MyEvent(Object source) {
		super(source);
	}
}

interface MyEventListener extends EventListener {
	public void eventOccurred(MyEvent evt);
}

class MyClass {
	protected EventListenerList listenerList = new EventListenerList();

	public void addMyEventListener(MyEventListener listener) {
		listenerList.add(MyEventListener.class, listener);
	}

	public void removeMyEventListener(MyEventListener listener) {
		listenerList.remove(MyEventListener.class, listener);
	}

	void fireMyEvent(MyEvent evt) {
		Object[] listeners = listenerList.getListenerList();
		for (int i = 0; i < listeners.length; i = i + 2) {
			if (listeners[i] == MyEventListener.class) {
				((MyEventListener) listeners[i + 1]).eventOccurred(evt);
			}
		}
	}
}
