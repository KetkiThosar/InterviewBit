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

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	

	/**
	 * 
	 * more correct way of calculating gcd . Interview bit version
	 * using euclid's algorithm which uses division algorithm
	 * gcd of two numbers also divides their difference.
	 * @param A
	 * @param B
	 * @return
	 */
	static public int gcd(int A, int B) {
		System.out.println("  A  " + A + "  B  " + B);
		if (A == 0)
			return B;
		return gcd(B % A, A);
	}

	// one more algorithm for calculating gcd
	/*
	 * Input: a, b 
	 * positive integers Output: g and d 
	 * such that g is odd and
	 * gcd(a, b) = g×2d
	 *  d := 0 
	 * while a and b are both even do
	 *  a := a/2 
	 *  b := b/2
	 * d := d + 1 
	 * while a ≠ b 
	 * do if a is even 
	 * then a := a/2 
	 * else if b is even
	 * then b := b/2
	 * else if a > b then 
	 * a := (a – b)/2 
	 * else b := (b – a)/2 
	 * g :=
	 * a output g, d
	 */

	public static void main(String[] args) {
		System.out.println("" + gcd(5, 12));
		System.out.println("" + gcd(45, 78));
	}

}
