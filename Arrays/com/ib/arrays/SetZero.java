package com.ib.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * {@code} contains method setZero() sets the column and row that contains zero.
 * @author keth0416
 *
 */
public class SetZero {

	/**
	 * 
	 * @param a two dimensional arraylist containing random zero and one.
	 * if 0 1 0
	 *    1 1 0 
	 *    1 1 1 
	 *    
	 *  expected output  0 0 0
	 *                   0 0 0
	 *                   0 1 0
	 */
	static void setZero(ArrayList<ArrayList<Integer>> a) {
		if (null == a || a.isEmpty()) {
			return;
		}

		int maxRow = a.size();
		int maxCol = a.get(0).size();

		//declare hashset for row and column index
		Set<Integer> rowSet = new HashSet<Integer>();
		Set<Integer> columnSet = new HashSet<Integer>();
		//iterate through for loop . add respective row col location of the element = 0
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++) {
				if (a.get(i).get(j) == 0) {
					rowSet.add(i);
					columnSet.add(j);
					continue;
				}
			}

		}// end of outer for loop

		//set all columns of particular row to zero 
		for (int row : rowSet) {
			for (int j = 0; j < maxCol; j++) {
				a.get(row).set(j, 0);
			}

		}
		//set all rows of particular column to zero 
		for (int col : columnSet) {
			for (int i = 0; i < maxRow; i++) {
				a.get(i).set(col, 0);
			}
		}

		System.out.println("set zero "+a.toString());
		
	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> a =new ArrayList<>();
		ArrayList<Integer> a1 =new ArrayList<Integer>();
		a1.add(0);
		a1.add(1);
		a1.add(0);
		a.add(a1);
		ArrayList<Integer> b1 =new ArrayList<Integer>();
		b1.add(1);
		b1.add(1);
		b1.add(0);
		a.add(b1);
		
		ArrayList<Integer> c1 =new ArrayList<Integer>();
		c1.add(1);
		c1.add(1);
		c1.add(1);
		a.add(c1);
		setZero(a);
	}

}
