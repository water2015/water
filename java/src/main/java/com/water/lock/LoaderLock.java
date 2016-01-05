package com.water.lock;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class LoaderLock {
	private final static Logger log = Logger.getLogger(LoaderLock.class);

	private static volatile boolean isReady = true;

	private final static int retryLimit = 55;
	private final static int retryWait = 3;

	public synchronized void isReady(String name) {
		int retryCount = 0;

		while (!isReady) {
			try {
				log.debug("Initiation Loader is not ready, please wait : " + name);
				wait(retryWait * 1000);
				//Thread.sleep(retryWait * 1000);
//				 TimeUnit.SECONDS.sleep(retryWait);
			} catch (InterruptedException e) {
				log.error("There is an exception while waiting lock", e);
			}

			if (retryLimit == ++retryCount) {
				log.error("Server has waited (" + retryWait * retryLimit + "), and has aborted waiting.");
				break;
			}
		}

		lockNunLock(true, name);
	}

	public synchronized void lockNunLock(boolean lock, String name) {
		if (lock) {
			isReady = false;
			log.debug("Locked Initiation loader   : " + name);
		} else {
			isReady = true;
			log.debug("Released Initiation loader : " + name);
			notify();
		}
	}

	private final static LoaderLock lock = new LoaderLock();

	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.isReady("Thread 1");
					System.out.println("Thread 1 is processing...");
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.lockNunLock(false, "Thread 1");
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.isReady("Thread 2");
					System.out.println("Thread 2 is processing...");
					TimeUnit.SECONDS.sleep(15);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.lockNunLock(false, "Thread 2");
				}
			}
		}).start();
		;

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.isReady("Thread 3");
					System.out.println("Thread 3 is processing...");
					TimeUnit.SECONDS.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.lockNunLock(false, "Thread 3");
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.isReady("Thread 4");
					System.out.println("Thread 4 is processing...");
					TimeUnit.SECONDS.sleep(7);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.lockNunLock(false, "Thread 4");
				}
			}
		}).start();
	}
}
