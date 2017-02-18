package com.ib.strings;

/**
 * 
 * @author ketki
 *Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class PalindromeString {
	/**
	 * 
	 * @param a
	 * @return  0 / 1 ( 0 for false, 1 for true ) 
	 */
	static public int isPalindrome(String a) {
		if (null == a || a.length() == 0) {
			return 0;
		}
		a = a.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(""+a);
		StringBuilder sb = new StringBuilder(a);
		String reversedString = sb.reverse().toString();
		if (a.equals(reversedString)) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		//String str = "A man, a plan, a canal: Panama";
		String str1 = "Was it a car or a cat I saw?";
		//String str2 = "race a car";
		System.out.println("isPalindrome :"+isPalindrome(str1));

	}

}
