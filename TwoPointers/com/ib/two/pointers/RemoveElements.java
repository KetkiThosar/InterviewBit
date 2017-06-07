package com.ib.two.pointers;

import java.util.ArrayList;

public class RemoveElements {

	public int removeElement(ArrayList<Integer> a, int b) {
		if (a == null) {
			return -1;
		}
		int count = 0;
		int n = a.size();
		for (int i = 0; i < n; i++) {
			if (a.get(i).intValue() != b) {
				a.set(count++, a.get(i));
			}
		}
		return count;

	}

	public static void main(String[] args) {
		RemoveElements rd = new RemoveElements();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int arr2[]={1001, 1001, 1004, 1007, 1001, 1004, 1001, 1002, 1005, 1001};
		for(int i:arr2){
			arr.add(i);	
		}	
		int count = rd.removeElement(arr,1011);
		System.out.println("size:  " + count);
		for(int i=0;i<count;i++){
			System.out.print(arr.get(i)+" ");	
		}
	}
	

}
