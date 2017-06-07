
package com.ib.arrays;

import java.util.ArrayList;
/**
 * 
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximized. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes: 
- Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].
 * 
 * @author ketki
 *
 */
public class Flip {

	public ArrayList<Integer> flip(String A) {

		ArrayList<Integer> positions = new ArrayList<Integer>(2);
		int [] maxCount=new int[1];
		// string is blank or empty return empty arraylist
		if (null == positions || positions.equals("")) {
			return positions;
		}
		int input1Count = count1s(new StringBuilder(A));
		if (input1Count == A.length()) {
			return positions;
		}
		int maxCountSoFar = 0;
		int max1Count = 0;
		for (int i = 0; i < A.length(); i++) {
			StringBuilder sb = new StringBuilder(A);
			for (int j = i; j < sb.length(); j++) {
				sb = flipBit(j, sb);
				max1Count = count1s(sb);
				if (max1Count > maxCountSoFar) {
					maxCountSoFar = max1Count;
					if (positions.isEmpty()) {
						positions.add(i+1);
						positions.add(j+1);
						maxCount[0]=max1Count;
					} else {
						if (max1Count>maxCount[0]||i+1 < positions.get(0) || j+1 < positions.get(1)) {
							positions.set(0,i+1);
							positions.set(1,j+1);
							maxCount[0]=max1Count;
						}
					}
				}
			}

		}
		return positions;
	}

	private int count1s(StringBuilder A) {
		int count = 0;
		for (int k = 0; k < A.length(); k++) {
			if (A.charAt(k) == '1') {
				count++;
			}
		}
		return count;
	}

	StringBuilder flipBit(int pos, StringBuilder sb) {
		// StringBuilder sb = new StringBuilder(A);
		if (sb.charAt(pos) == '0') {
			sb.setCharAt(pos, '1');
		} else {
			sb.setCharAt(pos, '0');
		}
		return sb;
	}

	public static void main(String[] args) {
		String A = "1101";
		Flip f = new Flip();
		System.out.println("ans: " + f.flip(A).toString());

	}

}
