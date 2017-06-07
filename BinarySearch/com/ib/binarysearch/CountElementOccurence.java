package com.ib.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array of integers, find the number of occurrences of a given
 * target value. Your algorithm’s runtime complexity must be in the order of
 * O(log n). If the target is not found in the array, return 0
 * 
 ** Example : ** Given [5, 7, 7, 8, 8, 10] and target value 8, return 2.
 * 
 * PROBLEM APPROACH :
 * 
 * 
 * @author ketki
 *
 */
public class CountElementOccurence {

	public static void main(String[] args) {
		// len 15
		int[] arr = {2};
		
		List<Integer> l = new ArrayList<Integer>();
		for (int i : arr) {
			l.add(i);
		}
		int x = CountElementOccurence.findCount(l, 2);
		System.out.println(x);

	}

	static public int findCount(final List<Integer> a, int b) {
		if (a == null) {
			return -1;
		}
		
		int sp = searchFirst(a, 0, a.size()-1, b);
		if (sp == -1) {
			return 0;
		}
		int ep = searchLast(a, sp , a.size() - 1, b, a.size());		
		return (ep - sp )+ 1;
	}

	static public int searchFirst(List<Integer> arr, int low, int high, int key) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if ((mid == 0 || key > arr.get(mid - 1)) && arr.get(mid) == key) {
			return mid;
		}
		if (arr.get(mid) < key) {
			return searchFirst(arr, mid + 1, high, key);
		}
		return searchFirst(arr, low, mid - 1, key);
	}

	static public int searchLast(List<Integer> arr, int low, int high, int key,
			int limit) {
		
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if ((mid == limit - 1 || key < arr.get(mid + 1)) && arr.get(mid) == key) {
			return mid;
		}
		if (arr.get(mid) > key) {
			return searchLast(arr, low, mid-1, key, limit);

		}
		return searchLast(arr, mid + 1, high, key, limit);

	}

}
