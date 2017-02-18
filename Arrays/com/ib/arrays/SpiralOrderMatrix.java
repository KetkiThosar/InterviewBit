package com.ib.arrays;

import java.util.ArrayList;

/**
 * This class contains method that prints matrix in spiral order.
 * 
 * @author ketki
 *
 */
public class SpiralOrderMatrix {

	/**
	 * takes two dimensional array and prints is spiral order e.g. Given input :
	 * 1 2 3
	 * 4 5 6 
	 * 7 8 9 
	 * expected output 
	   1 2 3 6 9 8 7 4 5
	 * 
	 * @param matrix
	 */

	static void printSpiralOrderMatrix(int[][] matrix) {
		if (null == matrix || matrix.length == 0) {
			System.out.println("Matrix is null or empty.");
			return;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int maxRow = matrix.length - 1;
		int maxCol = matrix[0].length - 1;
		int row = 0;
		int col = 0;


		while (row <= maxRow && col <= maxCol ) {
			// first iterate over columns with row 0
			// move to right
			while (col <= maxCol) {
				// System.out.print(matrix[row][col++]+"\t");
				result.add(matrix[row][col++]);

			}
			// decrement column as it has reached max value
			// go to next row and start printing from there

			col--;
			row++;

			// move down
			// iterate over row with last column
			while (row <= maxRow) {
				// System.out.print(matrix[row++][col]+"\t");
				result.add(matrix[row++][col]);

			}

			col--;
			row--;
			// move to left
			for (int p=col;p>=0;p--) {
				// System.out.print(matrix[row][col--]+"\t");
				result.add(matrix[row][p]);
			}
			col++;
			row--;

			// move up
			for (int x=row;x>0;x++) {
				// System.out.print(matrix[row--][col]+"\t");
				result.add(matrix[x][col]);

			}

			row++;
			col++;
			// outer of the matrix is covered push boundaries to left
			// decerement max values.
			maxCol--;
			maxRow--;

		}
		System.out.println("" + result.toString());
	}

	public static void main(String[] args) {
		// int
		//int [][]arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
		//int [][]arr={{1,2,3,4},{5,6,7,8}};
		//int[][] arr = { { 1 }, { 2 }, { 3 } };
		//int[][] arr = { { 1 ,2 ,3} };
		// int [][]arr={{1,2,3},{4,5,6},{7,8,9}};
		int[][] arr = {
		  {133, 241, 22, 258, 187, 150, 79, 207, 196, 401, 366, 335, 198},
		  {401, 55, 260, 363, 14, 318, 178, 296, 333, 296, 45, 37, 10},
		  {112, 374, 79, 12, 97, 39, 310, 223, 139, 91, 171, 95, 126}
		  };
		printSpiralOrderMatrix(arr);

	}

}
