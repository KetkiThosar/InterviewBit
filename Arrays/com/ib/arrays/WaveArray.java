/**
 * 
 */
package com.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
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

		for (int i = 0; i < a.size()-1; i+=2) {

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
		/*		a1.add(1);
		a1.add(0);
		a1.add(0);
		a1.add(-1);
		a1.add(2);
		a1.add(4);*/
		System.out.println(""+wave(a1) );
	}

}
