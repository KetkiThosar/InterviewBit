package com.ib.binarysearch;

public class BinarySearch {

	public int search(int[] arr, int low, int high, int key) {
		if (low >high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (arr[mid] == key) {
			return mid;
		}
		if (arr[mid] < key) {
			return search(arr, mid + 1, high, key);
		}
		return search(arr, low, mid - 1, key);
	}

	public static void main(String[] args) {
		int []arr={5, 7, 7, 8, 8, 10};
		System.out.println(new BinarySearch().search(arr, 0, arr.length, 8));

	}

}
