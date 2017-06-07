package com.ib.two.pointers;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesII {

	public int removeDuplicates(List<Integer> sortedList) {
		if (sortedList == null) {
			return 0;
		}
		int count = 0;
		int n = sortedList.size();
		for (int i = 0; i < n; i++) {
			if ((i>=n-2) || !sortedList.get(i).equals (sortedList.get(i + 1))
					|| !sortedList.get(i).equals(sortedList.get(i + 2))) {
				sortedList.set(count++, sortedList.get(i));
			}//end of if block
		}//end of for loop
		return count;
	}

	public static void main(String[] args) {
		RemoveDuplicatesII rd = new RemoveDuplicatesII();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int arr2[]={1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010};
		for(int i:arr2){
			arr.add(i);	
		}
		
		int count = rd.removeDuplicates(arr);
		System.out.println("size:  " + count);
		for(int i=0;i<count;i++){
			System.out.print(arr.get(i)+" ");	
		}
		
	}

}
