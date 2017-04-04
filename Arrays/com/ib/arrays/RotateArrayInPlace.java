package com.ib.arrays;

import java.util.ArrayList;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * You need to do this in place.
 * 
 * Note that if you end up using an additional array, you will only receive
 * partial score.
 * 
 * Example:
 * 
 * If the array is
 * 
 * [ 
 * [1, 2], 
 * [3, 4] 
 * ] 
 * Then the rotated array becomes:
 * 
 * [ 
 * [3, 1], 
 * [4, 2] 
 * ]
 * 
 * @author ketki
 *
 */
public class RotateArrayInPlace {

	static void rotate(ArrayList<ArrayList<Integer>> a) {
		if (null == a || a.size() == 0) {
			return;
		}
		if (a.size() != a.get(0).size()) {
			return;
		}
		int n = a.size() - 1;

		int upperLeft, bottomRight, upperRight, bottomLeft = 0;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i; j++) {
				upperLeft = a.get(i).get(j);
				upperRight = a.get(j).get(n - i);
				bottomRight = a.get(n - i).get(n - j);
				bottomLeft = a.get(n - j).get(i);

				a.get(j).set((n - i), upperLeft);
				a.get(n - i).set((n - j), upperRight);
				a.get(n - j).set(i, bottomRight);
				a.get(i).set(j, bottomLeft);

			}
		}
		System.out.println(a.toString());
	}

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(4);
		a2.add(5);
		a2.add(6);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(7);
		a3.add(8);
		a3.add(9);

		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		matrix.add(a1);
		matrix.add(a2);
		matrix.add(a3);

		rotate(matrix);
	}

}
