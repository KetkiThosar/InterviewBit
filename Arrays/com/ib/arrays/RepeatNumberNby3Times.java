/**
 * 
 */
package com.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Problem: A read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times.
 * 
 * 
 * 
 * @author ketki
 *
 */
public class RepeatNumberNby3Times {

	/**
	 * @param args
	 */

	public static int repeatedNumber(final List<Integer> a) {
		if (null == a || 0 == a.size()) {
			return -1;
		}
		int max = a.size() / 3;
		if (a.size() == 1) {
			return a.get(0);
		}
		//sort list
		Collections.sort(a);
		//initialize repeatedNumber with first element of array
		int noOfRepitition = 1;
		int repeatedNumber = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			//repeatedNumber matches with current number 
			if (repeatedNumber == a.get(i)) {
				//increment
				noOfRepitition++;
				//if its greater than n/3 return number
				if (noOfRepitition > max) {
					return a.get(i);
				}
				//else new number is repeatedNumber
			} else {
				repeatedNumber = a.get(i);
				noOfRepitition = 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1000441);
		a1.add(1000441);
		a1.add(1000994);
		System.out.println(" repeated no:" + repeatedNumber(a1));
	}

}
