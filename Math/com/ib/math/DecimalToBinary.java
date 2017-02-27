package com.ib.math;

/**
 * Given a number N >= 0, find its representation in binary.
 * 
 * Example:
 * 
 * if N = 6,
 * 
 * binary form = 110
 * 
 * 
 * @author ketki
 *
 */
public class DecimalToBinary {

	/**
	 * 
	 * @param a
	 * @return
	 */
	static public String findDigitsInBinary(int a) {

		System.out.println("input :" + a);
		StringBuilder sb = new StringBuilder();
		if (a == 0) {
			return sb.append("0").toString();
		}
		int remainder = 0;
		while (a > 0) {
			remainder = a % 2;
			a = a / 2;
			//append remainder to string
			sb.append(remainder);
		}
		sb.reverse();

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("binary :" + findDigitsInBinary(15));

	}

}
