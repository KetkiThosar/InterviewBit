/**
 * 
 */
package com.ib.math;

/**
 * 
 * You are given two positive numbers A and B. You need to find the maximum
 * valued integer X such that:
 * 
 * X divides A i.e. A % X = 0 X and B are co-prime i.e. gcd(X, B) = 1 For
 * example,
 * 
 * A = 30 B = 12 We return X = 5
 * 
 * @author ketki
 *
 */
public class LargestCoprimeDivisor {
	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	static public int cpFact(int A, int B) {
		int gcd = 0;
		while ((gcd = gcd(A, B)) != 1) {
			A = A / gcd;
		}

		return A;
	}

	static public int gcd(int a, int b) {
		if (a == 0 || b == 0) {
			return Math.abs(b - a);
		}
		int smallNumber = a, largeNumber = b;
		if (a >= b) {
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
		System.out.println(cpFact(30, 12));
		System.out.println(cpFact(78, 45));

	}

}
