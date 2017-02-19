package com.ib.strings;
/**
 * Problem - locate a substring ( needle ) in a string ( haystack ). 
 *Returns the index of the first occurrence of needle in haystack, 
 *or -1 if needle is not part of haystack. 
 * 
 * @author ketki
 *
 */
public class ImplementStrStr {


	/**
	 * 
	 * @param haystack
	 * @param needle
	 * @return first index of the occurrence of the needle else -1
	 */
	static public int strStr(final String haystack, final String needle) {

		if (null == haystack || ("").equals(haystack) || null == needle
				|| ("").equals(needle)) {
			return 0;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		String trimmedHaystack=haystack.trim();
		String trimmedNeedle=needle.trim();
		for (int i = 0; i <= trimmedHaystack.length()-trimmedNeedle.length(); i++) {
			//int index = 0;
			int j=0;
			//while (index < trimmedNeedle.length()&&i < trimmedHaystack.length()&&trimmedHaystack.charAt(i++) == trimmedNeedle.charAt(index++)) {
			for(j=0;j<trimmedNeedle.length();j++){
				if(trimmedHaystack.charAt(i+j) != trimmedNeedle.charAt(j))
				break;
			}// end of while loop
			if(j==trimmedNeedle.length()){
				return i;
			}
		}// end of for loop

		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(""+strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba","babaaa"));
		
	}
}
