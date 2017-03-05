/**
 * 
 */
package com.ib.math;

/**
 * Reverse digits of an integer.
 * 
 * Example1:
 * 
 * x = 123,
 * 
 * return 321 Example2:
 * 
 * x = -123,
 * 
 * return -321
 * 
 * Return 0 if the result overflows and does not fit in a 32 bit signed integer
 * 
 * @author ketki
 *
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	static public int reverse(int a) {
		if (a >= 0 && a < 10) {
			return a;
		}
		int sign = (a < 0) ? -1 : 1;
		a*=sign;
		String str = String.valueOf(a);
		long power = 1;
		long reversedNo = 0;
		
		for (int i = 0 ; i <str.length(); i++) {
			reversedNo += (str.charAt(i) - '0') * power;
			if(reversedNo>=Integer.MAX_VALUE){
				return 0;
			}
			power *= 10;
		}
		reversedNo*=sign;

		return (int)reversedNo;

	}

	public static void main(String[] args) {
		System.out.println(""+reverse(-Integer.MAX_VALUE));

	}

}
