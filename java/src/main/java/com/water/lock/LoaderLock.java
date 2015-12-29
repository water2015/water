package com.water.lock;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class LoaderLock {
	private final static Logger log = Logger.getLogger(LoaderLock.class);

	private static volatile boolean isReady = true;

	private final static int retryLimit = 5;
	private final static int retryWait = 3;

	public synchronized static void isReady() {
		int retryCount = 0;

		while (!isReady) {
			try {
				log.debug("Initiation Loader is not ready, please wait!");
//				Thread.currentThread().wait(retryWait * 1000);    the root reason caused by static
//				Thread.sleep(retryWait * 1000);
				TimeUnit.SECONDS.sleep(retryWait);
			} catch (InterruptedException e) {
				log.error("There is an exception while waiting lock", e);
			}

			if (retryLimit == ++retryCount) {
				log.error("Server has waited (" + retryWait * retryLimit + "), and has aborted waiting.");
				break;
			}
		}

		lockNunLock(true);
	}

	public static void lockNunLock(boolean lock) {
		if (lock) {
			isReady = false;
			log.debug("Locked Initiation loader.");
		} else {
			isReady = true;
			log.debug("Released Initiation loader.");
		}
	}

	public static void main(String[] args) {

		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					LoaderLock.isReady();
					TimeUnit.SECONDS.sleep(30);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					LoaderLock.lockNunLock(false);
				}
			}
		};

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				try {
					LoaderLock.isReady();
					TimeUnit.SECONDS.sleep(30);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					LoaderLock.lockNunLock(false);
				}
			}
		};

		new Thread(r).start();
		new Thread(r1).start();
	}
}
