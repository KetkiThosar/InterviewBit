/**
 * 
 */
package com.ib.math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * Example :
 * 
 * n = 5 n! = 120 Number of trailing zeros = 1 So, return 1
 * 
 * @author ketki
 *
 */
public class TrailingZerosInFactorial {

	/**
	 * The solution is to calculate total factors (5's multipliers) of number 
	 * e.g 5! =120 
	 * 5 has only one multiple of 5 . So answer is 1.
	 * example 2 
	 * n=20 
	 * 20 has 4 factors of 5 =  5 ,10 ,15 ,20
	 * so answer is 4.
	 * example 3 
	 * 100 has 20 multiples of 5 
	 * 100 has 4 multiples of 25 
	 * so total is 24  
	 * @param args
	 */

	static public int trailingZeroes(int a) {

		if (a <= 0) {
			return 0;
		}
		int trailingZerosCount = 0;double power=1;
		int p=0;
		while((a/(p=(int)Math.pow(5, power)))>0){
			trailingZerosCount+=a/(int) p; 
			power++;			 
		}
		return trailingZerosCount;

	}

	public static void main(String[] args) {
		System.out.println(" "+trailingZeroes(100));

	}

}
