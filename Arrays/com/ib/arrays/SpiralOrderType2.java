package com.ib.arrays;

import java.util.ArrayList;

public class SpiralOrderType2 {

	public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		ArrayList<ArrayList<Integer>> spiralMatrix = new ArrayList<>(a);

		if (a <= 0) {
			return spiralMatrix;
		}
		int number = 1;
		int row = 0, col = 0;
		int maxRow = a, maxCol = a;

		for (int i = 0; i < a; i++) {
			spiralMatrix.add(new ArrayList<Integer>());
			for (int k = 0; k < a; k++) {
				spiralMatrix.get(i).add(0);
			}
			
		}

		while (row < maxRow && col < maxCol) {
			for (int i = col; i < maxCol; i++) {
				spiralMatrix.get(row).set(i, number++);
			}
			row++;
			for (int k = row; k < maxRow; k++) {
				spiralMatrix.get(k).set((maxCol - 1), number++);
			}
			maxCol--;

			if (row < maxRow) {
				for (int j = maxCol - 1; j >= col; j--) {
					spiralMatrix.get(maxRow - 1).set(j, number++);
				}
				maxRow--;
			}
			if (col < maxCol) {
				for (int k = maxRow - 1; k >= row; k--) {
					spiralMatrix.get(k).set(col, number++);
				}
				col++;
			}

		}// end of while loop

		return spiralMatrix;
	}

	public static void main(String[] args) {

		System.out.println("" + generateMatrix(3).toString());

	}

}
