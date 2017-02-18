package com.ib.arrays;

import java.util.ArrayList;

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
