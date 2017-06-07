package com.ib.bitmanipulation;

import java.util.ArrayList;
import java.util.List;
/**
 * Problem: In a given array except one element all other elements are occur twice. 
 * Identify the number which occurs only once.
 * @author ketki
 *
 */
public class SingleNumber {
	/**
	 * The solution basically is to use XOR to find the element that occurs once.
	 * when no is Xored with itself it gives 0 as result.
	 * e.g. 4&4 = 0
	 *  
	 * @param a
	 * @return
	 */
	public int singleNumber(final List<Integer> a) {
		if (a == null) {
			return -1;
		}
		int result = 0;
		for (int i : a) {
			result ^= i;
		}
		return result;
	}

	public static void main(String[] args) {
		SingleNumber sn=new SingleNumber();
		ArrayList<Integer>arr=new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(2);
		arr.add(3);
		arr.add(1);
		int k=sn.singleNumber(arr);
		System.out.println(k);
		
	}

}
