package com.ib.arrays;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal’s triangle.
 * 
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from
 * previous row R - 1.
 * 
 * Example:
 * 
 * Given numRows = 5,
 * 
 * Return
 * 
 * [ 
 * [1], 
 * [1,1], 
 * [1,2,1], 
 * [1,3,3,1], 
 * [1,4,6,4,1]
 * ]
 * 
 * @author ketki
 *
 */
public class PascalTriangle {

	static ArrayList<ArrayList<Integer>> generate(int a) {
		ArrayList<ArrayList<Integer>> pt = new ArrayList<ArrayList<Integer>>(a);

		for (int i = 0; i < a; i++) {
			pt.add(new ArrayList<Integer>());
		}

		pt.get(0).add(0, 1);
		for (int k = 1; k < a; k++) {
			ArrayList<Integer> row = pt.get(k);
			row.add(0, 1);
			ArrayList<Integer> upperRow = pt.get(k - 1);
			for (int j = 1; j < pt.get(k - 1).size(); j++) {
				int sum = upperRow.get(j - 1) + upperRow.get(j);
				row.add(j, sum);
			}
			row.add(k, 1);
			pt.set(k, row);
		}

		return pt;

	}

	public static void main(String[] args) {

		System.out.println("Pascal's triangle " + generate(1));
	}

}
