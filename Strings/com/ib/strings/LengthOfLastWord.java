/**
 * 
 */
package com.ib.strings;

/**
 * @author ketki 
 * 
 * Given a string s consists of upper/lower-case alphabets and
 *         empty space characters ' ', return the length of last word in the
 *         string.
 * 
 *         If the last word does not exist, return 0.
 * 
 *         Note: A word is defined as a character sequence consists of non-space
 *         characters only.
 * 
 *         Example:
 * 
 *         Given s = "Hello World",
 * 
 *         return 5 as length("World") = 5.
 * 
 *         Please make sure you try to solve this problem without using library
 *         functions. Make sure you only traverse the string once.
 */
public class LengthOfLastWord {

	/**
	 * 
	 * @param a
	 * @return
	 */

	static public int lengthOfLastWord(final String a) {

		if (null == a || ("").equals(a.trim())) {
			return 0;
		}
		StringBuilder wordStr = new StringBuilder(a);
		String trimmedStr = wordStr.toString().trim();
		int count = 0;
		for (int i = trimmedStr.length()-1; i >= 0; i--) {
			char c = trimmedStr.charAt(i);
			if (c == ' ' || c == '\t') {
				break;
			}
			count++;
		}//end of for loop

		return count;
	}

	public static void main(String[] args) {
		String str="			";
		System.out.println("len: "+lengthOfLastWord(str));
	}

}
