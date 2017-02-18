package com.ib.arrays;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {

	static public int maxArray(ArrayList<Integer> a) {

		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
				currentSum = Math.abs((a.get(i) - a.get(j)))
						+ Math.abs((i - j));
				currentSum = Math.max(currentSum, maxSum);
				maxSum = currentSum;
			}
		}

		return currentSum;

	}

	static public int maxArray2(ArrayList<Integer> A) {
		int ans = 0, n = A.size();

		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			max1 = Math.max(max1, A.get(i) + i);
			max2 = Math.max(max2, A.get(i) - i);
			min1 = Math.min(min1, A.get(i) + i);
			min2 = Math.min(min2, A.get(i) - i);
		}
		ans = Math.max(ans, max2 - min2);
		ans = Math.max(ans, max1 - min1);
		return ans;
	}

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(3);
		arr.add(1);

		System.out.println("Max:  " + maxArray2(arr));
		
			
				
	}

}
