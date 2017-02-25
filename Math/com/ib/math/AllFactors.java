/**
 * 
 */
package com.ib.math;

import java.util.ArrayList;
import java.util.Collections;

/**
 *find all factors of a given number
 * @author ketki
 *
 */
public class AllFactors {

	/**
	 * This methods all unique factors of a given number in a sorted order.
	 * @param args number
	 */
	static public ArrayList<Integer> allFactors(int a) {
		if (a <= 0) {
			return null;
		}
		ArrayList<Integer> factors = new ArrayList<Integer>();
		//iterate from 1 to sqrt(n) . If a%i==0 add both divisor and quotient 
		//if a is a perfect square then we might get duplicate as the divisor and quotient will be exactly
		//same. Hence check if (i!=a/i) 
		int n=(int) Math.sqrt(a);
		for (int i = 1; i <= n; i++) {
			if(a%i!=0)
				continue;
			factors.add(i);
			if (i != a/i) {
				factors.add(a/i);
			}
		}
		Collections.sort(factors);
		System.out.println(""+factors.toString());
		return factors;

	}

	public static void main(String[] args) {
	allFactors(38808);

	}

}
