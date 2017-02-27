/**
 * 
 */
package com.ib.chkpt.problems;

import java.util.ArrayList;

/**
 * @author ketki
 * 
 * 
 *         Print concentric rectangular pattern in a 2d matrix. Let us show you
 *         some examples to clarify what we mean.
 * 
 *         Example 1:
 * 
 *         Input: A = 4. Output:
 * 
 *         4 4 4 4 4 4 4 
 *         4 3 3 3 3 3 4 
 *         4 3 2 2 2 3 4 
 *         4 3 2 1 2 3 4 
 *         4 3 2 2 2 3 4
 *         4 3 3 3 3 3 4 
 *         4 4 4 4 4 4 4 
 *         
 *         Example 2:
 * 
 *         Input: A = 3. Output:
 * 
 *         3 3 3 3 3
 *         3 2 2 2 3 
 *         3 2 1 2 3 
 *         3 2 2 2 3 
 *         3 3 3 3 3 
 *         
 *         The outermost rectangle is formed by A, then the next outermost is formed by A-1
 *         and so on.
 * 
 *         You will be given A as an argument to the function you need to
 *         implement, and you need to return a 2D array.
 *
 *
 */
public class PreetyPrint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PreetyPrint ps = new PreetyPrint();
		System.out.println(ps.prettyPrint(2).toString());

	}

	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {

		int maxCol = (2 * a) - 1, maxRow = maxCol;

		// creates matrix consisting of rows (non initialized) equal to maxRow .
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>(
				maxRow);
		int row = 0, col = 0, number = a;
		// initialize rows
		for (int i = 0; i < maxRow; i++) {
			matrix.add(new ArrayList<Integer>());
			for (int j = 0; j < maxCol; j++) {
				matrix.get(i).add(1);
			}
		}

		while (row < maxRow  -1&& col < maxCol -1) {
			// right
			for (int i = col; i < maxCol; i++) {
				matrix.get(row).set(i, number);
			}
			row++;
			// downwards
			for (int j = row; j < maxRow; j++) {
				matrix.get(j).set(maxCol - 1, number);
			}
			// left
			maxCol--;
			for (int i = maxCol - 1; i >= col; i--) {
				matrix.get(maxRow - 1).set(i, number);

			}
			maxRow--;
			// upwards
			for (int i = maxRow - 1; i >= row; i--) {
				matrix.get(i).set(col, number);
			}
			col++;

			//decrease the number
			number--;

		}
		return matrix;
	}
}
