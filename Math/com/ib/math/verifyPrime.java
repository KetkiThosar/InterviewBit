package com.ib.math;

/**
 * 
 * Problem: Given a number identify if it's a prime number.
 * @author ketki
 *
 */
public class verifyPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPrime(113));

	}
	/**
	 * 
	 * @param n
	 * @returns true if prime else false
	 */
	static boolean isPrime(int n) {
		if(n<=1)
		return false;
		int x = (int) Math.sqrt(n);
		for (int i = 2; i <= x; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
