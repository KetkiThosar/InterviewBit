/**
 * 
 */
package com.ib.arrays;

import java.util.ArrayList;


/**
 * 
 * The following code is supposed to rotate the array A by B positions.

So, for example,


A : [1 2 3 4 5 6]
B : 1

The output :

[2 3 4 5 6 1]
 * 
 * 
 * @author ketki
 *
 */
public class RotateArrayAtPointA {

	
	ArrayList<Integer>rotateArray(ArrayList<Integer> A, int B) {
		
		ArrayList<Integer> ret=new ArrayList<Integer>(); 
		
	    for (int i = 0; i < A.size(); i++) {
	        ret.add(A.get((i + B) % A.size()));
	        //0+Index /size
	    }
	    return ret; 
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arrC = new ArrayList<Integer>();
		int[] arr = { 44, 41, 12, 42, 71, 45, 28, 65, 75, 93, 66, 66, 37, 6, 24, 59};
		for (int i : arr) {
			arrC.add(i);
		}
		System.out.println("" +new RotateArrayAtPointA().rotateArray(arrC, 18));

	}

}
