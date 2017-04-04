/**
 * 
 */
package com.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of integers, sort the array into a wave like array and return
 * it, In other words, arrange the elements into a sequence such that a1 >= a2
 * <= a3 >= a4 <= a5.....
 * 
 * Example
 * 
 * Given [1, 2, 3, 4]
 * 
 * One possible answer : [2, 1, 4, 3] Another possible answer : [4, 1, 3, 2]
 * 
 * NOTE : If there are multiple answers possible, return the one thats
 * lexicographically smallest. In above example you will return first answer.
 * 
 * @author keth0416
 *
 */
public class WaveArray {

	/**
	 * @param args
	 */
	static public ArrayList<Integer> wave(ArrayList<Integer> a) {
		if (null == a || 0 == a.size()) {
			return a;
		}
		Collections.sort(a);

		for (int i = 0; i < a.size() - 1; i += 2) {

			int temp = a.get(i);
			int a1 = a.get(i + 1);
			a.set(i + 1, temp);
			a.set(i, a1);

		}

		return a;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(15);
		/*
		 * a1.add(1); a1.add(0); a1.add(0); a1.add(-1); a1.add(2); a1.add(4);
		 */
		System.out.println("" + wave(a1));
	}

}
