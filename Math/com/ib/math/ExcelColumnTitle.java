/**
 * 
 */
package com.ib.math;

/**
 * Given a number returns its corresponding column name as appears in an Excel sheet. 
 * Example:
 * 
 * A -> 1
 * 
 * B -> 2
 * 
 * C -> 3
 * 
 * @author ketki
 *
 */
public class ExcelColumnTitle {

	/**
	 * @param args
	 */

	static public String convertToTitle(int a) {
		String s = "";

		while (a > 0) {

			char c = getChar(a % 26);

			s = c + s;

			// Focus on this condition

			if (a % 26 == 0)

				a = a / 26 - 1;

			else

				a = a / 26;

		}

		return s;

	}

	static public char getChar(int a) {

		if (a == 0)

			return 'Z';

		a = a - 1;
		

		int i = 'A' + a;

		char c = (char) i; //converts integer(ASCII) into char

		return c;

	}

	public static void main(String[] args) {
		System.out.println("" + convertToTitle(980089));

	}

}
