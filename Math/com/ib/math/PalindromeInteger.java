/**
 * 
 */
package com.ib.math;

/**
 * Problem:Determine whether an integer is a palindrome. Do this without extra
 * space.
 * 
 * A palindrome integer is an integer x for which reverse(x) = x where
 * reverse(x) is x with its digit reversed. Negative numbers are not
 * palindromic.
 * 
 * Example :
 * 
 * Input : 12121 Output : True
 * 
 * Input : 123 Output : False
 * 
 * @author ketki
 *
 */
public class PalindromeInteger {

	/**
	 * @param args
	 *            number
	 */
	static public boolean isPalindrome(int a) {
		// negative numbers are not palindrome
		if (a < 0) {
			return false;
		}
		int number = a;
		StringBuilder sb = new StringBuilder();
		//convert into string builder
		while (number > 0) {
			sb.append(number % 10);
			number /= 10;
		}
		int end = sb.length() - 1;
		int start = 0;

		while (start < end) {
			if (sb.charAt(start) != sb.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(1221));
	}

}
