package com.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * @author keth0416
 * {@code} {@link RepeatedNumber} finds out the repeated number in the array;
 * if there are more than one duplicate element , smallest amongst them is returned
 * e.g {1,5,7,9,0,0,6,5}
 * In this case 0 and 5 have duplicates , so 0 will be returned.  If there is only one number -1 will be returned.
 */
public class RepeatedNumber {
	/**
	 * 
	 * @param a list of integers.
	 * @return a duplicate element.
	 */
	static int repeatedNumber(ArrayList<Integer> a) {
		if (null == a || a.isEmpty() || a.size() == 1) {
			return -1;
		}
		Collections.sort(a);
		int element = 0;
		int prevElement = 0;
		for (int i = 0; i < a.size(); i++) {
			element = a.get(i);
			if (i == 0) {
				prevElement = element;
				continue;
			}

			if (element == prevElement) {
				return element;
			}
			prevElement = element;
		}
		return -1;

	}

	public static void main(String[] args) {
		ArrayList<Integer> a1 =new ArrayList<Integer>();
		a1.add(0);
		a1.add(0);
		a1.add(4);
		a1.add(2);
		a1.add(1);
		a1.add(1);
		System.out.println("repeated number  "+repeatedNumber(a1));
	}

}
