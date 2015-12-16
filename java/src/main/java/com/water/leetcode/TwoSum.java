package com.water.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

		int[] two = null;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[i] + nums[j] == target) {
					two = new int[] { i + 1, j + 1 };
					break;
				}
			}
			if (two != null) {
				break;
			}
		}

		return two;
	}

	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] defaultResult = { 0, 0 };
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				int[] result = { map.get(target - nums[i]) + 1, i + 1 };
				return result;
			}
			map.put(nums[i], i);
		}
		return defaultResult;
	}
}
