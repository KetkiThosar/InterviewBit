package com.ib.arrays;

import java.util.ArrayList;

/**
 * Problem: You are given an array (zero indexed) of N non-negative integers,
 * A0, A1 ,…, AN-1. Find the minimum sub array Al, Al+1 ,…, Ar so if we
 * sort(in ascending order) that sub array, then the whole array should get
 * sorted. If A is already sorted, output -1.
 * 
 * e.g Input 1:
 * 
 * A = [1, 3, 2, 4, 5]
 * 
 * Return: [1, 2]
 * 
 * Input 2:
 * 
 * A = [1, 2, 3, 4, 5]
 * 
 * Return: [-1]
 * 
 * 
 * 
 * @author ketki
 *
 */
public class UnsortedSubArray {

	static public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {

		// This solutions creates 3 arrays.
		// one for unsorted array and each for before unsorted part and after
		// unsorted part.
		// max(beforeUnsorted)<= min(unsorted) && max(unsorted)<=
		// min(afterSorted)
		ArrayList<Integer> unsortedIndicesList = new ArrayList<Integer>();
		int n = A.size();
		if (null == A || 0 == n) {
			unsortedIndicesList.add(-1);
			return unsortedIndicesList;
		}

		int startIndex = -1, endIndex = -1, current = -1, next = -1;
		int unSortMax = Integer.MIN_VALUE, unSortMin = Integer.MAX_VALUE, sortMax = Integer.MIN_VALUE, sortMin = Integer.MAX_VALUE;
		// iterate from 0 to size-2
		// if next element of array is greater than first one or if it is less
		// than unSortMax it is consider to be unsorted.
		for (int i = 0; i < n - 1; i++) {
			current = A.get(i);
			next = A.get(i + 1);
			if (current > next || (i > 0 && unSortMax > current)) {
				// record max and min of unsorted sub array
				unSortMax = Math.max(unSortMax, current);
				unSortMin = Math.min(unSortMin, current);
				// set start index value only once.
				if (startIndex < 0) {
					startIndex = i;
				}
				endIndex = i;
			}
		}
		// add to unSortList from startIndex to endIndex.
		ArrayList<Integer> unsortList = new ArrayList<Integer>();
		for (int i = startIndex; i < endIndex; i++) {
			unsortList.add(A.get(i));
		}

		// if last element is less than unsorted array add it to unsortedList
		// and update max and min
		if (unSortMax > A.get(n - 1)) {
			unsortList.add(A.get(n - 1));
			unSortMax = Math.max(unSortMax, A.get(n - 1));
			unSortMin = Math.min(unSortMin, A.get(n - 1));
			endIndex = n - 1;
		}
		// create beforeUnsort list and add elements from 0 till
		// startIndex.calculate its max value.
		ArrayList<Integer> beforeUnSortList = new ArrayList<Integer>();
		for (int i = 0; i < startIndex; i++) {
			beforeUnSortList.add(A.get(i));
			sortMax = Math.max(sortMax, A.get(i));
		}
		// create afterUnsort list and add elements from endIndex+1 till size of
		// original array.Calulate its min value.
		ArrayList<Integer> afterUnsortList = new ArrayList<Integer>();
		for (int k = endIndex + 1; k < n; k++) {
			afterUnsortList.add(A.get(k));
			sortMin = Math.min(sortMin, A.get(k));
		}

		// if sortMax is greater than the unSortMin then add elements
		// from beforeSortList to unSortArray till unSortMin is greater.
		// i.e shift start index to left till the elements in left part are
		// smaller than min value of unsorted array.
		if (sortMax > unSortMin) {
			int x = beforeUnSortList.size() - 1;
			while (sortMax > unSortMin && x > 0) {
				unsortList.add(beforeUnSortList.get(x));
				// remove from before unSort list
				beforeUnSortList.remove(x);
				sortMax = beforeUnSortList.get(--x);
			}
			// if first element is smaller than add to unSort array
			if (beforeUnSortList.get(0) > unSortMin) {
				unsortList.add(beforeUnSortList.get(0));
				beforeUnSortList.remove(0);
			}
		}

		//if unSortMax is greater than sortMin then add elements from afterUnsortList .i.e. shift index to right. 
		if (unSortMax > sortMin) {
			int x = unsortList.size();
			while (unSortMax > sortMin && x < afterUnsortList.size() - 1) {
				unsortList.add(afterUnsortList.get(x));
				//remove from after list
				afterUnsortList.remove(x);
				sortMin = afterUnsortList.get(++x);
			}
			//if last element is smaller than unSortMax add to unSort array
			int lastElement = afterUnsortList.size() - 1;
			if (unSortMax > afterUnsortList.get(lastElement)) {
				unsortList.add(afterUnsortList.get(lastElement));
				afterUnsortList.remove(lastElement);
			}
		}
		//start index has value less than 0 , given array is sorted.
		if (startIndex < 0) {
			unsortedIndicesList.add(-1);
			return unsortedIndicesList;
		}
		startIndex = beforeUnSortList.size();
		//if afterUnsortList is empty then endIndex will be n -1 else startIndex+unSortList.size()
		endIndex = afterUnsortList.size() == 0 ? n - 1 : startIndex
				+ unsortList.size();

		unsortedIndicesList.add(startIndex);
		unsortedIndicesList.add(endIndex);

		return unsortedIndicesList;
	}

	public static void main(String[] args) {

		ArrayList<Integer> arrA = new ArrayList<Integer>();

		arrA.add(1);
		arrA.add(3);
		arrA.add(2);
		arrA.add(4);
		arrA.add(5);
		System.out.println("Input	"+arrA.toString()+"	unsorted array: " + subUnsort(arrA));
		System.out.println();
		ArrayList<Integer> arrB = new ArrayList<Integer>();
		int[] arr2 = { 2, 9, 14, 6, 7, 8, 10, 11, 12, 14, 89, 90, 91, 92, 93,
				94, 95, 1 };
		for (int i : arr2) {
			arrB.add(i);
		}
		System.out.println("Input	"+arrB.toString()+"	unsorted array: " + subUnsort(arrB));
		System.out.println();
		ArrayList<Integer> arrC = new ArrayList<Integer>();
		int[] arr = { 1, 1, 1, 1, 0 };
		for (int i : arr) {
			arrC.add(i);
		}

		System.out.println("Input	"+arrC.toString()+"	unsorted array: " + subUnsort(arrC));
		System.out.println();
		ArrayList<Integer> arrD = new ArrayList<Integer>();
		int[] arr3 = { 2, 9, 14, 6, 7, 8, 10, 11, 12, 14, 89, 90, 91, 92, 93,
				94, 95 };
		for (int i : arr3) {
			arrD.add(i);
		}
		System.out.println("Input	"+arrD.toString()+"	unsorted array: " + subUnsort(arrD));
		System.out.println();
		ArrayList<Integer> arrE = new ArrayList<Integer>();
		int[] arr4 = { 1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15 };
		for (int i : arr4) {
			arrE.add(i);
		}
		System.out.println("Input	"+arrE.toString()+"	unsorted array: " + subUnsort(arrE));
		System.out.println();
		ArrayList<Integer> arrF = new ArrayList<Integer>();
		int[] arr5 = { 1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17,
				17, 17, 19, 19 };
		for (int i : arr5) {
			arrF.add(i);
		}
		System.out.println("Input	"+arrF.toString()+"	unsorted array: " + subUnsort(arrF));
		System.out.println();
		ArrayList<Integer> arrG = new ArrayList<Integer>();
		int[] arr6 = { 1, 1, 2, 3, 3, 4, 8, 9, 11, 9, 11, 12, 12, 11, 9, 14,
				19, 20, 20 };
		for (int i : arr6) {
			arrG.add(i);
		}
		System.out.println("Input	"+arrG.toString()+"	unsorted array: " + subUnsort(arrG));
		System.out.println();
		
		ArrayList<Integer> arrH = new ArrayList<Integer>();
		arrH.add(1);
		arrH.add(2);
		arrH.add(3);
		arrH.add(3);
		arrH.add(4);
		System.out.println("Input	"+arrH.toString()+"	unsorted array: " + subUnsort(arrH));
		System.out.println();
		
		
	}

}
