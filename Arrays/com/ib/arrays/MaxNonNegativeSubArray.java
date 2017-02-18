package com.ib.arrays;

import java.util.ArrayList;
/**
 * 
 * @author keth0416
 * {@code} maxSet -Finds out the maximum sub-array(continuous) of non negative numbers from an array.
    That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
    Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
    
    Example 
    A : [1, 2, 5, -7, 2, 3]
    The two sub-arrays are [1, 2, 5] [2, 3].
    The answer is [1, 2, 5] as its sum is larger than [2, 3]
    
    NOTE 1: If there is a tie, then compare with segment's length and return segment which has maximum length
    NOTE 2: If there is still a tie, then return the segment with minimum starting index
    
    
 */
public class MaxNonNegativeSubArray {

	/**
	 * 
	 * @param arraylist from which max sub-array to be found out
	 * @returns no negative sub array
	 */
	static public ArrayList<Integer> maxset(ArrayList<Integer> a) {
		//initialize max sub array
		ArrayList<Integer> maxSubArray = new ArrayList<Integer>();
		
		//in case of invalid input, return empty list
		if (null == a || 0 == a.size()) {
			return maxSubArray;
		}
		//initialize maxSum to the lowest value.
		long maxSumTill = 0, maxSum = Integer.MIN_VALUE;
		//initialize array to hold maxSum of sub-array
		long[] sum = new long[1];
		for (int i = 0; i < a.size(); i++) {
			int k = i;
			//initialize for every sub array
			maxSumTill=0;
			//iterate till negative number is encountered 
			while (i < a.size() && a.get(i) >= 0) {
				//add all non negative elements.
				maxSumTill += a.get(i);
				//if current sum is maximum
				if (maxSumTill >= maxSum) {
					//update maxSum value
					maxSum = maxSumTill;
					//add the start and end point of the sub-array
					if (maxSubArray.isEmpty()) {
						maxSubArray.add(k);
						maxSubArray.add(i);
						//if array is not empty
					} else {
						//if sum is the maximum sum so far OR length of sub-array is greater that previous one OR 
						//starting index is minimum
						if (maxSum > sum[0]
								|| (i - k) > (maxSubArray.get(1) - maxSubArray
										.get(0)) || k < maxSubArray.get(0)) {
							//update the values
							maxSubArray.set(0, k);
							maxSubArray.set(1, i);
						}
					}
					//store the maxSum
					sum[0] = maxSum;
				}
				i++;
			}// while loop

		}// for loop
		//using start and end index of sub-array , add elements to array list.
		if (maxSubArray.size() > 1) {
			int start = maxSubArray.get(0);
			int end = maxSubArray.get(1);
			maxSubArray.clear();
			for (; start <= end; start++) {
				maxSubArray.add(a.get(start));
			}
		}
		return maxSubArray;
	}

	public static void main(String[] args) {
		ArrayList<Integer> m1 = new ArrayList<Integer>();
		m1.add(-5);
		m1.add(-6);
		m1.add(7);
		m1.add(8);
		m1.add(0);
		m1.add(-3);
		m1.add(-5);
		m1.add(4);
		m1.add(9);
		m1.add(1);
		m1.add(1);	
		System.out.println("arr: " + maxset(m1));
	}

}
