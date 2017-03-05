/**
 * 
 */
package com.ib.math;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * 
 * Problem: Given a number ,identify all the prime factors of the
 * number. 
 * @author ketki
 *
 */
public class PrimeFactors {

	/**
	 * 
	 * @param a number whose prime factors to be found out
	 * @returns a list of the factors in sorted order
	 */
	
	static public ArrayList<Integer> allFactors(int a) {
		if (a <= 0) {
			return null;
		}
		ArrayList<Integer> factors = new ArrayList<Integer>();
		//iterate from 1 to sqrt(n) . 
		//If a%i==0 add both divisor and quotient 
		//if a is a perfect square then we might get duplicate as the divisor and quotient will be exactly
		//same. Hence check if (i!=a/i) 
		int n=(int) Math.sqrt(a);
		for (int i = 1; i <= n; i++) {
			if(a%i!=0)
				continue;
			if(isPrime(i))
			factors.add(i);
			if (i != (a/i)&&isPrime(a/i)) {
				factors.add(a/i);
			}
		}
		//sort all factors
		Collections.sort(factors);
		return factors;

	}
	
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

	public static void main(String[] args) {
		System.out.println(""+allFactors(125));

	}

}
