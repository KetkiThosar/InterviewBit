package com.ib.strings;

/**
 * 
 * 
 Given two binary strings, return their sum (also a binary string).
 * 
 * Example:
 * 
 * a = "100"
 * 
 * b = "11" Return a + b = “111”.
 * 
 * 
 * @author ketki
 *
 */
public class AddBinaryStrings {

	static public String addBinary(String s1, String s2) {
		if (s1 == null || s2 == null)
			return "";
		int first = s1.length() - 1;
		int second = s2.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (first >= 0 || second >= 0) {
			int sum = carry;
			if (first >= 0) {
				sum += s1.charAt(first) - '0';
				first--;
			}
			if (second >= 0) {
				sum += s2.charAt(second) - '0';
				second--;
			}
			carry = sum >> 1;
			sum = sum & 1;
			sb.append(sum == 0 ? '0' : '1');
		}
		if (carry > 0)
			sb.append('1');

		return sb.reverse().toString();

	}

	public static void main(String[] args) {

		System.out.println("" + addBinary("101", "111"));
		StringBuilder result = new StringBuilder("harami");
		result.append("bhukkad", 0, 7);
		System.out.println("" + result.toString());
	}

}