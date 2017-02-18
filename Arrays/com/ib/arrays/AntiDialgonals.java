package com.ib.arrays;

import java.util.ArrayList;

public class AntiDialgonals {

	static public ArrayList<ArrayList<Integer>> diagonal(
			ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> diagonals = new ArrayList<ArrayList<Integer>>();
		if (null == a || a.isEmpty()) {
			return diagonals;
		}
		int maxRow = a.size(), maxCol = a.get(0).size();
		int row = 0, col = 0;
      
		for (int i = 0; i < (2 * maxRow - 1); i++) {
			diagonals.add(new ArrayList<Integer>());
		}
		if (maxRow == 1 && maxCol == 1) {
			diagonals.get(0).add(0);
			return diagonals;
		}

		if (maxCol < maxRow) {

			for (int k = 0; k < maxRow; k++) {
				for (int i = maxCol; i < maxRow; i++)
					a.get(k).add(0);
				
			}
			maxCol=maxRow;
		}
		int jump=0;
		while (row < maxCol) {
			int i = 0;
			for (; i < maxCol; i++) {

				diagonals.get(i + row).add(a.get(row).get(i));
			}
			row++;
			
			for (int k = row; k < maxRow; k++) {

				diagonals.get(i+jump-1).add(a.get(k).get(maxCol - 1));
				i++;
			}
			maxCol--;
			jump++;
		}
		return diagonals;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);
		a1.add(3);

		ArrayList<Integer> a2 = new ArrayList<Integer>();

		a2.add(5);
		a2.add(6);
		a2.add(7);

		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(9);
		a3.add(10);
		a3.add(11);

		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(12);
		a4.add(13);
		a4.add(14);

		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		matrix.add(a1);
		matrix.add(a2);
		matrix.add(a3);
		matrix.add(a4);

		System.out.println("ans:   " + diagonal(matrix));
	}

}
