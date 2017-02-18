package com.ib.strings;


/**
 * Given an input string, reverse the string word by word.
 * 
 * Example:
 * 
 * Given s = "the sky is blue",
 * 
 * return "blue is sky the".
 * 
 * 
 * @author ketki
 *
 */
public class ReverseTheString {

	static public String reverseWords(String a) {
		if (null == a || 0 == a.length()) {
			return a;
		}
		a=a.trim();
		String words[] = a.split("[\t ]");
		String word = "";
		StringBuilder reverseWords = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			word = words[i].trim();
			if (word.length()==0||word.equals(""))
				continue;
			reverseWords.append(word.trim());
			if (i != 0) {
				reverseWords.append(" ");
			}
		}
		return reverseWords.toString();
	}

	public static void main(String[] args) {
		System.out.println("ans:"+reverseWords(" ankrqzzcel  dyaiug y rkicv t")+"xxxxxx");
	}

}
