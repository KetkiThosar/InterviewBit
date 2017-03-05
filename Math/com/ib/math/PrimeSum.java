/**
 * 
 */
package com.ib.math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an even number ( greater than 2 ), return two prime numbers whose sum
 * will be equal to given number.
 * 
 * NOTE A solution will always exist. read Goldbach’s conjecture
 * 
 * Example:
 * 
 * 
 * Input : 4 Output: 2 + 2 = 4
 * 
 * If there are more than one solutions possible, return the lexicographically
 * smaller solution.
 * 
 * If [a, b] is one solution with a <= b, and [c,d] is another solution with c
 * <= d, then
 * 
 * [a, b] < [c, d]
 * 
 * If a < c OR a==c AND b < d.
 * 
 * 
 * @author ketki
 *
 */
public class PrimeSum {

	/**
	 * @param args
	 */
	static public ArrayList<Integer> primesum(int a) {

		if (a <= 0) {
			return null;
		}
		ArrayList<Integer> primePair = new ArrayList<>();
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		int sqrRoot = (int) Math.sqrt(a);
		int[] factors = new int[a];
		Arrays.fill(factors, 1);
		factors[0] = 0;
		factors[1] = 0;
		for (int i = 2; i <= sqrRoot; i++) {
			for (int j = 2; j * i < a; j++) {
				if (factors[i * j] == 1) {
					factors[i * j] = 0;
				}
			}
		}
		for (int k = 0; k < factors.length; k++) {
			if (factors[k] == 0)
				continue;
			primeNumbers.add(k);
		}//get all prime factors 
		int diff = 0;
		//loop through prime factors 
		for (int l : primeNumbers) {
			diff = a - l;
			//if difference of (number - prime factor) is also prime factor
			if (isPrime(diff)) {

				if (!primePair.isEmpty()) {
					//ignore if element already present in the list
					if (l == primePair.get(0)) {
						continue;
					}
					//if more than one solution exists choose the lexicographically smaller 
					//one
					if (l < primePair.get(0)
							|| (l <= primePair.get(0) && diff < primePair
									.get(0))) {
						primePair.add(l);
						primePair.add(diff);
					}// end of if
				}// end of if
				else {
					primePair.add(l);
					primePair.add(diff);
				}
				// break;
			}
		}

		primeNumbers.clear();
		for (int k : primePair) {
			primeNumbers.add(k);
		}

		return primeNumbers;
	}

	/**
	 * 
	 * @param n
	 * @return true if prime else false
	 */
	static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		int x = (int) Math.sqrt(n);
		for (int i = 2; i <= x; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("" + primesum(16).toString());
	}

}
