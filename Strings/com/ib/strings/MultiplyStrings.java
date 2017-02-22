/**
 * 
 */
package com.ib.strings;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problems: Given two numbers represented as strings, return multiplication of
 * the numbers as a string. For example, given strings "12", "10", your answer
 * should be “120”.
 * 
 * @author ketki
 *
 */
public class MultiplyStrings {

/**
 * 
 * @param  string a
 * @param  string b
 * @return the product of a and b
 */

	static public String multiply(String a, String b) {
		if (null == a || null == b || ("").equals(a) || ("").equals(b)) {
			return "";
		}
		//get the small number 
		String minLen = b, maxLen = a;
		if (a.length() <= b.length()) {
			minLen = a;
			maxLen = b;
		}
		int multiplier = 0, number = 0, sum = 0, carry = 0;
		//initialize matrix
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		//start from the end of the short string/number
		for (int i = minLen.length() - 1; i >= 0; i--) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			//subtract '0' to get the numeric value of the character
			carry = 0; multiplier = minLen.charAt(i) - '0';
			//start multiplying from the end of the large number  
			for (int j = maxLen.length() - 1; j >= 0; j--) {
				number = maxLen.charAt(j) - '0'; 
				sum = multiplier * number;
				sum += carry;
				//check if there is carry
				carry = sum / 10;		
				sum %= 10;
				//add sum to array list
				row.add(sum);
			}// end of inner for loop
			//add carry to array if there is any
			if(carry>0){
				row.add(carry);
			}
			int k = i;
			//add padding zero after every multiplication 
			while (k < minLen.length() - 1) {
				row.add(0, 0);
				k++;
			}
			//reverse the row and add to matrix
			Collections.reverse(row);
			matrix.add(row);
		}// end of outer loop

		carry = 0;
		//add the rows to get the final result
		for (int k = 0; k < matrix.size() - 1; k++) {
			//add two rows each time ..start adding from the end of each row
			int x = matrix.get(k).size() - 1, y = matrix.get(k + 1)
					.size() - 1;
			while (x >= 0 && y >= 0) {
				sum = matrix.get(k).get(x)
						+ matrix.get(k + 1).get(y) + carry;
				carry = sum / 10;
				sum %= 10;
				//update second row
				matrix.get(k + 1).set(y, sum);
				x--;y--;
			}
			//add carry if any to remaining columns 
			while (y >= 0) {
				sum = matrix.get(k + 1).get(y) + carry;
				carry = sum / 10;
				sum %= 10;
				matrix.get(k + 1).set(y, sum);
				y--;
			}// end of while loop
			//add carry in the beginning 
			if (carry > 0) {
				matrix.get(k + 1).add(0, carry);
			}
			carry = 0;
		}

		//get the last row of the matrix and convert in into string
		StringBuilder sb = new StringBuilder();
		int sumOfNos = 0, lastRow = matrix.size() - 1;
		for (int k = 0; k < matrix.get(lastRow).size(); k++) {
			sumOfNos += matrix.get(lastRow).get(k);
			//skip zeros added for padding
			if(sumOfNos==0)continue;
			sb.append(matrix.get(lastRow).get(k));
			
		}
		//if result of multiplication is zero return zero else return product
		String result = (sumOfNos == 0) ? "0" : sb.toString();
		return result;

	}

	public static void main(String[] args) {
		System.out.println("ans: " + multiply("99999", "99999"));

	}

}
