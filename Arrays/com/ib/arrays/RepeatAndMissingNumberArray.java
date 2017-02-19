package com.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepeatAndMissingNumberArray {


	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
		ArrayList<Integer> repeatedNums = new ArrayList<Integer>(2);
		repeatedNums.set(0, 0);
		repeatedNums.set(1, 0);
		if (null == a || 0 == a.size()) {
			System.out.println("array is empty...");
			return repeatedNums;
		}
		Collections.sort(a);
		int first = 0;
		int second = 0;
		int diff = 0;
		boolean foundMin = false;
		for (int i = 0; i < a.size() - 1; i++) {
			if (a.get(i) < 0) {
				continue;
			}
			if (!foundMin && a.get(i) > 1) {
				repeatedNums.set(0, 1);
			}
			foundMin = true;
			first = a.get(i);
			second = a.get(i + 1);
			diff = second - first;
			if (diff > 1) {
				repeatedNums.set(1, ++first);
			}
		}// end of for loop
		if (a.get(a.size() - 1) < 0) {
			repeatedNums.set(0, 1);
		}
		int lastNo = a.get(a.size() - 1);
		repeatedNums.set(0, ++lastNo);

		return repeatedNums;

	}

	static public ArrayList<Integer> repeatedNumber1(final List<Integer> A) {
		ArrayList<Integer> res = new ArrayList<>();

		Collections.sort(A);
		int n = A.size();
		int rep = -1;
		int miss = -1;
		long sum = A.get(0);

		for (int i = 1; i < n; i++) {
			if (A.get(i).intValue() == A.get(i - 1).intValue()) {
				rep = A.get(i);
			}
			sum += A.get(i);
		}

		miss = (int) ((1L * n * (1L * n + 1)) / 2 - sum + rep);

		res.add(rep);
		res.add(miss);

		return res;

	}
	public static void main(String[] args) {
	 ArrayList<Integer>arr=new ArrayList<Integer>();
	 arr.add(100000);
	 arr.add(1000);
	 arr.add(10000);
	 arr.add(5);
	 arr.add(1000);
	 arr.add(100000);
	 repeatedNumber1(arr);
	}
	
}
