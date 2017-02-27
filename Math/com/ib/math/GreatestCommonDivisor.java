/**
 * 
 */
package com.ib.math;

/**
 * @author ketki
 *
 */
public class GreatestCommonDivisor {

	/**
	 * 
	 * Given 2 non negative integers m and n, find gcd(m, n)
	 * 
	 * GCD of 2 integers m and n is defined as the greatest integer g such that
	 * g is a divisor of both m and n. Both m and n fit in a 32 bit signed
	 * integer.
	 * 
	 * Example
	 * 
	 * m : 6 n : 9
	 * 
	 * GCD(m, n) : 3
	 * 
	 * @param args
	 */

	static public int gcd(int a, int b) {
		int smallNumber = a, largeNumber = b;
		if (a <= b) {
			smallNumber = b;
			largeNumber = a;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= smallNumber; i++) {
			if (smallNumber % i == 0 && largeNumber % i == 0) {
				max = Math.max(max, i);
			}
		}
		return max;
	

	}

	public static void main(String[] args) {
		System.out.println("" + gcd(475, 125));

	}

}
