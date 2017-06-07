package com.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * Example:
 * 
 * Given [1,2,0] return 3,
 * 
 * [3,4,-1,1] return 2,
 * 
 * [-8, -7, -6] returns 1
 * 
 * Your algorithm should run in O(n) time and use constant space.
 * 
 * e.g. [1] return 2
 * else 
 * return 1
 * 
 * @author ketki
 *
 */
public class MissingNumber {

	static int firstMinimumPositiveNumber(ArrayList<Integer> a) {
		if (a == null || a.isEmpty()) {
			return -1;
		}
		if (a.size() == 1) {
			return (a.get(0) == 1) ? 2 : 1;
		}
		int first = 0;
		int second = 0;
		int diff = 0;
		Collections.sort(a);
		boolean foundMin = false;
		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i) < 0) {
				continue;
			}
			if (!foundMin && a.get(i) > 1) {
				return 1;
			}
			foundMin = true;
			first = a.get(i);
			second = a.get(i + 1);
			diff = second - first;
			if (diff > 1) {
				return ++first;
			}
		}// end of for loop
		if (a.get(a.size() - 1) < 0)
			return 1;
		int x = a.get(a.size() - 1);
		return ++x;
	}

	static int m() {
		int x = 1;
		return x++;
	}

	public static void main(String[] args) {
		System.out.println(+m());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// arr.add(1);
		/*
		 * arr.add(-7); arr.add(-6);
		 */

		/*
		 * arr.add(3); arr.add(4); arr.add(-1); arr.add(1);
		 */
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		arr.add(8);

		System.out.println("number found: " + firstMinimumPositiveNumber(arr));

	}

}
