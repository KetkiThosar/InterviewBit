package com.ib.strings;

import java.util.ArrayList;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 
 * 1, 11, 21, 1211, 111221, ... 1 is read off as one 1 or 11. 11 is read off as
 * two 1s or 21.
 * 
 * 21 is read off as one 2, then one 1 or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * Example:
 * 
 * if n = 2, the sequence is 11.
 * 
 * @author ketki
 *
 */
public class CountAndSay {

	static public String countAndSay(int a) {
		if (a < 1)
			return "";
		ArrayList<ArrayList<Integer>> count = new ArrayList<ArrayList<Integer>>();
		//first row with only one element 1
		count.add(new ArrayList<Integer>());
		count.get(0).add(1);
		int number = 0;
		for (int i = 1; i < a; i++) {
			//add row 
			count.add(i, new ArrayList<Integer>());
			//get the previous sequence 
			for (int k = 0; k < count.get(i - 1).size(); k++) {
				number = count.get(i - 1).get(k);
				//if the number already present in the list then increase its count.
				if (!count.get(i).isEmpty()
						&& number == count.get(i)
								.get((count.get(i).size()) - 1)) {
					count.get(i).set((count.get(i).size() - 2),
							(count.get(i).get(count.get(i).size() - 2)) + 1);
				} else //add number and count as 1 to the row 
				{
					count.get(i).add(1);
					count.get(i).add(number);
				}
			}// end of inner for loop
		}// end of outer for loop
		StringBuilder sb = new StringBuilder();
		//get the last row of count
		for (int l = 0; l < count.get(count.size() - 1).size(); l++) {
			sb.append(count.get(count.size() - 1).get(l));
		}
		return sb.toString();
	}

	static public String countAndSayIBVersion(int A) {
		StringBuilder res = new StringBuilder("1");
		int count;
		char num;
		StringBuilder last = new StringBuilder("1");

		if (A < 1)
			return "";

		for (int i = 1; i < A; i++) {

			int idx = 0;
			int n = last.length();
			res = new StringBuilder();

			while (idx < n) {

				num = last.charAt(idx);
				count = 1;
				idx++;

				while (idx < n && last.charAt(idx) == num) {
					idx++;
					count++;
				}
				res.append(String.valueOf(count));
				res.append(String.valueOf(num));
			}
			last = res;
		}
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ans: " + countAndSayIBVersion(6));
		System.out.println("ans: " + countAndSay(6));
	}

}
