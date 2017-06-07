package com.ib.arrays;

public class MatrixClass {

	public static void printMatrix() {

		int[][] arr = new int[17][17];
		int row, column = 0;
		int number = 0;
		for (row = 0, column = 0; row < arr.length; row++) {
			for (column = 0; column < arr.length; column++) {
				arr[row][column] = number;
			}
		}

		print(arr);

		System.out.println();

		System.out.println();

		printMatrixInADifferentWay(arr, arr.length);

		print(arr);
	}

	private static void print(int arr[][]) {
		for (int k = 0; k < arr.length; k++) {
			for (int l = 0; l < arr.length; l++) {
				System.out.print(arr[k][l] + " ");
			}
			System.out.println();
		}
	}

	private static void printMatrixInADifferentWay(int arr[][], int n) {
		if (n % 2 == 0) {
			System.out.println("Dimensions of matrix needed only in odd number.");
			return;
		}
		int outputNumber = 1;
		int upperBound, lowerBound = 0;

		upperBound = n / 2;
		lowerBound = n / 2;
		arr[upperBound][lowerBound] = outputNumber;
		upperBound--;
		lowerBound++;
		outputNumber++;
		while (upperBound >= 0) {
			for (int i = upperBound; i <= lowerBound; i++) {
				for (int j = upperBound; j <= lowerBound; j++) {
					if (i != upperBound && j != upperBound && i != lowerBound
							&& j != lowerBound) {
						continue;
					}
					arr[i][j] = outputNumber;

				}//end of first for loop

			}//end of second for loop
			outputNumber++;
			upperBound--;
			lowerBound++;
		}//end of while loop

	}

	public static void main(String[] args) {
		//MaximumAbsoluteDifference di=new MaximumAbsoluteDifference();
		printMatrix();
	}

}
