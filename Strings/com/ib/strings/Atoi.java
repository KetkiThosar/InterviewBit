/**
 * 
 */
package com.ib.strings;



/**
 * Problem:Implement atoi to convert a string to an integer. Example : Input :
 * "9 2704" Output : 9
 * If integer overflows
 * Return INT_MAX if the number is positive, INT_MIN otherwise
 * 
 * @author ketki
 *
 */
public class Atoi {

	/**
	 * 
	 * @param a
	 * @return
	 */
	// && (trimmedA.charAt(i) != ' ' || trimmedA.charAt(i) != '\t'||)
	static public int atoi(final String a) {
		if (null == a || ("").equals(a.trim())) {
			return 0;
		}
		// remove trailing or leading spaces if any
		String trimmedA = a.trim();
		long number = 0;
		StringBuilder numSb = new StringBuilder();
		// record the sign
		int sign = trimmedA.startsWith("-") ? -1 : 1;
		char c = ' ';
		// get the number string till the tap stop or space
		for (int i = 0; i < trimmedA.length(); i++) {
			c = trimmedA.charAt(i);
			if (c == '+' || c == '-') {
				continue;
			}
			// if character is in the range of 0 to 9 append it else break
			if (c >= '0' && c <= '9') {
				numSb.append(c);
				continue;
			}// end of if
			break;
		}// end of for loop
		if (numSb.length() != 0) {
			long power = 1;
			long digit=0;
			// start from the end of the string
			for (int j = numSb.length() - 1; j >= 0; j--) {
				// subtract '0' character to get the value of the digit from 0
				// to 9
				c = (char) (numSb.charAt(j) - '0');
				// multiply by power
				digit += c * power;
				if (digit >= Integer.MAX_VALUE) {
					number = -1;
					break;
				}
				number += c * power;
				if (number < 0)
					break;
				// increment power by *10
				power *= 10;
				// digit++;
			}
			// System.out.println("digit " + digit);

			if (number < 0) {
				number = sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			} else {
				number *= sign;
			}
		}// end of if block
			// multiply by sign.

		return (int)number;
	}

	public static void main(String[] args) {

		System.out
				.println("number:"
						+ atoi("5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3  5 14703818 776366059B9O43393"));
		/*
		 * System.out.println("min : " + Integer.MIN_VALUE + " max: " +
		 * Integer.MAX_VALUE)
		 */;
	}

}
