package com.ib.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal’s triangle.
 * 
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from
 * previous row R - 1.
 * 
 * Example:
 * 
 * Input : k = 3
 * 
 * Return : [1,3,3,1] NOTE : k is 0 based. k = 0, corresponds to the row [1].
 * Note:Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author ketki
 *
 */
public class KthRowPascalTriangle {

	// Given an index k, return the kth row of the Pascal's triangle.
	/*
	 * Input : k = 3 Return : [1,3,3,1]
	 */

	public static ArrayList<Integer> getRow(int a) {
		/*
		 * if(a<0){ return new ArrayList<Integer>(); }
		 */
		// declare list of list
		List<List<Integer>> pt = new ArrayList<List<Integer>>();

		// add first row
		pt.add(new ArrayList<Integer>());
		// add 1 as first element to first row
		pt.get(0).add(0, 1);
		// create rows
		for (int i = 1; i <= a; i++) {
			// add row and add 1 at start of every row.
			pt.add(new ArrayList<Integer>());
			pt.get(i).add(1);
			for (int j = 1; j < i; j++) {
				// add elements of previous row
				int sum = pt.get(i - 1).get(j - 1) + pt.get(i - 1).get(j);
				// add to current row
				pt.get(i).add(sum);
			}
			// add 1 at the end of each row.
			pt.get(i).add(1);
			// pt.pt.get(i).add(row);
		}
		return (ArrayList<Integer>) pt.get(a);

	}

	public static void main(String[] args) {
		System.out.println("row :" + getRow(3).toString());

	}

}
