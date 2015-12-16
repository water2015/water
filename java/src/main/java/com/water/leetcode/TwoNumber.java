package com.water.leetcode;

public class TwoNumber {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ln = null, temp = null;
		int shift = 0;

		do {
			int sum = l1.val + l2.val;
			if (sum >= 10) {
				shift = 1;
				sum = sum - 10;
			} else {
				shift = 0;
			}

			if (ln == null) {
				ln = temp = new ListNode(sum + shift);
			} else {
				temp.next = new ListNode(sum);
				temp = temp.next;
			}
		} while (l1.next != null);

		return ln;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);

		ListNode l = new TwoNumber().addTwoNumbers(l1, l2);
		System.out.println(l.val);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
