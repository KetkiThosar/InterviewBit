package com.ib.strings;

import java.util.ArrayList;
/**
 *  to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.
 *
 * 
 * @author ketki
 *
 */
public class LongestCommonPrefix {

	static public String longestCommonPrefix(ArrayList<String> a) {
		if (null == a || 0 == a.size()) {
			return "";
		}
		if (1 == a.size()) {
			return a.get(0);
		}
		int minLen = getMinSize(a);
		StringBuilder commonPrefix = new StringBuilder();
		int commonChar = 0;
		char c = '0';
		Outer: for (int j = 0; j < minLen; j++) {
			if (a.get(0) == null)
				return commonPrefix.toString();
			commonChar = a.get(0).charAt(j);
			for (int i = 1; i < a.size(); i++) {
				if (null == a.get(i - 1)
						|| null == a.get(i)
						|| (a.get(i - 1).trim().charAt(j) != a.get(i).trim()
								.charAt(j))) {
					break Outer;
				}

			}
			c = (char) commonChar;
			commonPrefix.append(c);
		}

		return commonPrefix.toString();

	}

	static int getMinSize(ArrayList<String> a) {
		int min = Integer.MAX_VALUE;
		for (String str : a) {
			if (null == str)
				continue;
			min = Math.min(min, str.length());
		}
		return min;
	}

	public static void main(String[] args) {
		/*
		 * String[] strArray = {
		 * 
		 * "abcdefgh",
		 * 
		 * "aefghijk",
		 * 
		 * "abcefgh" };
		 */

		String[] strArray = { "geeksforgeeks", "geeks", "geek", "geezer" };

		ArrayList<String> a = new ArrayList<String>();
		for (String str : strArray) {
			a.add(str);
		}
		System.out.println(" len " + longestCommonPrefix(a));

	}

}
