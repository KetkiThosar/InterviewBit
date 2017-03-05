/**
 * 
 */
package com.ib.math;

/**
 * Given a column title as appears in an Excel sheet, return its corresponding
 * column number.
 * 
 * Example:
 * 
 * A -> 1
 * 
 * B -> 2
 * 
 * C -> 3
 * 
 * ...
 * 
 * Z -> 26
 * 
 * AA -> 27
 * 
 * AB -> 28
 * 
 * @author ketki
 *
 */
public class ExcelColumnNumber {

	/**
	 * This solution multiplies each character of string by the power of 26
	 * @param a
	 * @return
	 */

	static public int titleToNumber(String a) {
		
		if (null == a || ("").equals(a.trim())) {
			return 0;
		}
		
		double multiplier = 26, power = 0;
		int number = 0;

		for (int i = a.length() - 1; i >= 0; i--) {
			if ('A' <= a.charAt(i) && a.charAt(i) <= 'Z') {
				number += ((a.charAt(i) - 'A' + 1) * Math.pow(
						multiplier, power));
				power++;
			}

		}

		return number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("o/p:	" + titleToNumber("ZZ"));
	}

}
