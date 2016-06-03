package com.water;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

	private final static LoaderLock lock1 = new LoaderLock();
	private final static LoaderLock lock2 = new LoaderLock();
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock1.isReady();
					System.out.println("Thread 1 is processing...");
					TimeUnit.SECONDS.sleep(7);
					System.out.println("Thread 1 is done...");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock1.lockNunLock(false);
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock1.isReady();
					System.out.println("Thread 2 is processing...");
					TimeUnit.SECONDS.sleep(7);
					System.out.println("Thread 2 is done...");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock1.lockNunLock(false);
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock2.isReady();
					System.out.println("Thread 3 is processing...");
					TimeUnit.SECONDS.sleep(7);
					System.out.println("Thread 3 is done...");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock2.lockNunLock(false);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock2.isReady();
					System.out.println("Thread 4 is processing...");
					TimeUnit.SECONDS.sleep(7);
					System.out.println("Thread 4 is done...");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock2.lockNunLock(false);
				}
			}
		}).start();
	}

	public void test() {
		AtomicInteger ai = new AtomicInteger();
		ai.incrementAndGet();
	}
}
