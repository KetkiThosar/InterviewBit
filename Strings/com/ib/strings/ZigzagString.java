package com.ib.strings;

import java.util.ArrayList;

/**
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P.......A........H.......N ..A..P....L....S....I...I....G
 * ....Y.........I........R And then read line by line: PAHNAPLSIIGYIR Write the
 * code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR" Example 2 : ** ABCD, 2 can be written as
 * 
 * A....C ...B....D and hence the answer would be ACBD.
 * 
 * 
 * 
 * 
 * 
 * 
 * @author ketki
 *
 */
public class ZigzagString {

	static public String convert(String a, int b) {
		if (null == a || ("").equals(a.trim())) {
			return "";
		}
		StringBuilder inputSb = new StringBuilder();
		a = a.trim();
		//get the string till space or tab 
		for (int i = 0; i < a.length()
				&& (a.charAt(i) != ' ' || a.charAt(i) != '\t'); i++) {
			inputSb.append(a.charAt(i));
		}
		//if rows column or b is greater than length of string or if its zero 
		//return the string
		if (b == 0||b>=inputSb.length()) {
			inputSb.toString();
		}
		//initialize array list
		ArrayList<StringBuilder> zigzag = new ArrayList<StringBuilder>(b);
		//add rows
		for (int x = 0;x < b;x++) {
			zigzag.add(new StringBuilder());
		}
		
		for (int i = 0, row = 0; i < inputSb.length();) {
			//add to each row go downwards
			for (row = 0; row < b && i < inputSb.length(); row++) {
				zigzag.get(row).append(inputSb.charAt(i++));
			}
			//start adding from second last row till first row. not 0th row 
			for (row = b - 2; row > 0 && i < inputSb.length(); row--) {
				zigzag.get(row).append(inputSb.charAt(i++));
			}
		}// end of for loop
		
		//append all strings from array ..  
		StringBuilder outputSb = new StringBuilder();
		for (int j = 0; j < zigzag.size(); j++) {
				outputSb.append(zigzag.get(j).toString());
			
		}// end of for loop

		return outputSb.toString();
	}

	public static void main(String[] args) {
		System.out.println(":" + convert("Ketki898", 5));
	}

}
