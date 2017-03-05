/**
 * 
 */
package com.ib.math;

import java.util.ArrayList;

/**
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra
 * space.
 * 
 * Example:
 * 
 * Input : [1, 0] Return : [0, 1] Lets say N = size of the array. Then,
 * following holds true : All elements in the array are in the range [0, N-1] N*N 
 * does not overflow for a signed integer
 * e.g
 * consider arr[4, 0, 2, 1, 3] where N=5
 * arr[i] is represented as arr[arr[i]]
 * So, arr[0] becomes arr[arr[0]] i.e. arr[4]
 * i.e. arr[4]  will be on 0th position.
 * arr[0] will be on 1st position and so on........
 * 
 * @author ketki
 *
 */
public class RearrangeArray {

	/** This is a beautiful problem. Here we have to store two elements at one position
	 *  This can be achieved using following fact
	    if B ,C < N 
	    then A= B +C * N and A/N =C ,A%N=B
	 *  
	 * 
	 * @param a
	 */
	
	static public void arrange(ArrayList<Integer> a) {

		if (null == a || 0 == a.size()) {
			return;
		}
		System.out.println(""+a.toString());
		int size = a.size(), x = -1, y = -1;
		for (int i = 0; i < size; i++) {
			//get the element for current index i
			x = a.get(i);
			//then increment the number by (arr[arr[x]] % N)*N
			y = x + ((a.get(x) % size) * size);
			a.set(i, y);
		}
		for (int i = 0; i < size; i++) {
			x = a.get(i);
			a.set(i, x / size);
		}
		System.out.println(""+a.toString());
		

	}

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(4);
		a1.add(0);
		a1.add(2);
		a1.add(1);
		a1.add(3);
		arrange(a1);
	}

}
