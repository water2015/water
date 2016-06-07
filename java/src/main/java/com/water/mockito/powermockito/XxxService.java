package com.water.mockito.powermockito;

public class XxxService {

	private static int threshold = 1000000;

	public int sum() {
		int i = 0;
		while (i < threshold) {
			i++;
		}
		return i;
	}

	private boolean isPositiveNumber(int i) {
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void foreach(int count) {
		for (int i = 0; i < count; i++) {
			isPositiveNumber(i);
		}
	}

	public boolean isAllowBuy(int i) {
		if (XxxUtil.isSafe(i)) {
		}
		return false;
	}

	public boolean handle(int i) {
		if (isNeedHandle(i)) {
			return true;
		}
		return false;
	}

	private boolean isNeedHandle(int i) {
		return true;
	}

	public XxxUtil getUtil() {
		XxxUtil util = new XxxUtil();
		return util;
	}

}
