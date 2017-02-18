package com.ib.arrays;

import java.util.ArrayList;

public class RotateArray {
	public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (B > A.size())
			return A;
		
		if(B==A.size()){
			for(int i = A.size()-1; i >=0; i--){
				ret.add(A.get(i));
			}
			System.out.println(" "+ret.toString());
			return ret;
		}
		for (int i = 0; i < A.size()-B; i++) {
			ret.add(A.get(i + B));
		}
		for(int k=0;k<B;k++){
			ret.add(A.get(k));
		}
		System.out.println(" "+ret.toString());
		return ret;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a =new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		new RotateArray().rotateArray(a, 5);

	}

}
