package com.ib.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Problem : return the min XOR of pair of elements in array.
 * 
 * @author ketki
 *
 */
public class MinXORValue {

	public int findMinXor(ArrayList<Integer> A) {
		if (null == A) {
			return -1;
		}
		//sort array
		Collections.sort(A);
		int min = Integer.MAX_VALUE;
		int xOR = 0;
		//calculate XOR and compare with previous minimum value
		for (int i = 1; i < A.size(); i++) {
			xOR = A.get(i - 1) ^ A.get(i);
			min = Math.min(xOR, min);
			//if min is zero then return
			if (min == 0) {
				break;
			}
		}
		System.out.println("min xor "+min);
		return min;
	}

	public static void main(String[] args) {
		ArrayList<Integer>arr=new ArrayList<Integer>();
		arr.add(0);
		arr.add(4);
		arr.add(7);
		arr.add(9);
		arr.add(16);
		int k=new MinXORValue().findMinXor(arr);
		System.out.println(k);

	}
	

}
