package com.water;

import org.apache.log4j.Logger;

public class LoaderLock {
	private final static Logger log = Logger.getLogger(LoaderLock.class);
	private final static int retryLimit = 400;
	private final static int retryWait = 60;

	private volatile boolean isReady = true;

	public synchronized void isReady() {
		int retryCount = 0;

		while (!isReady) {
			try {
				log.debug("Initiation Loader is not ready, please wait!");
				wait(retryWait * 1000);
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

	public synchronized void lockNunLock(boolean lock) {
		if (lock) {
			isReady = false;
			log.debug("Locked Initiation loader.");
		} else {
			isReady = true;
			log.debug("Released Initiation loader.");
			notify();
		}
	}
}
