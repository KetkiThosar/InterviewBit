package com.ib.arrays;

import java.util.ArrayList;
/**
 * Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]

 * 
 * @author ketki
 *
 */
public class AntiDialgonals {
	static public ArrayList<ArrayList<Integer>> diagonal2(ArrayList<ArrayList<Integer>> A) {
	    int l = A.size();
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2 * l - 1; ++i) {
    	    int offset = i < l ? 0 : i - l + 1;
	        ArrayList<Integer> row = new ArrayList<Integer>();
    	    for (int j = offset; j <= i - offset; ++j) {
		        row.add(A.get(j).get(i - j));
    	    }
	        res.add(row);
        }
        return res;
	}
	static public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> diagonals = new ArrayList<ArrayList<Integer>>();
		if (null == a || a.isEmpty()) {
			return diagonals;
		}
		int maxRow = a.size(), maxCol = a.get(0).size();
		if (maxRow == 1 && maxCol == 1) {
			diagonals.add(new ArrayList<Integer>());
			diagonals.get(0).add(0);
			return diagonals;
		}
		if (maxCol < maxRow) {
			for (int k = 0; k < maxRow; k++) {
				for (int i = maxCol; i < maxRow; i++)
					a.get(k).add(0);
			}
			maxCol = maxRow;
		}
		int row = 0,index=0;
		int col = maxCol;
		int [] arr=new int[maxRow*maxCol];
		while (row < maxRow && col > 0) {
			for (int i = 0; i < col; i++) {
				arr[index++]=a.get(row).get(i);
			}
			row++;
			for (int k = row; k < maxRow; k++) {
				arr[index++]=a.get(k).get(col - 1);
			}
			col--;
		}		
		for (int i = 0; i < (maxRow+maxCol-1); i++) {
			diagonals.add(new ArrayList<Integer>());
		}
		int k=0,sI=0,nextRow=0;
		while(k<arr.length){
		for (int i = 0; i < (maxCol+maxRow - 1); i++) {
			diagonals.get(sI++).add(arr[k++]);
		}
		nextRow++;
		sI=nextRow;
		maxRow-- ;maxCol--;
		}
		return diagonals;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		a1.add(4);
		
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(5);
		a2.add(6);
		a2.add(7);
		a2.add(8);

		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(9);
		a3.add(10);
		a3.add(11);
		a3.add(12);
		
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		
		a4.add(13);
		a4.add(14);
		a4.add(15);
		a4.add(16);

		ArrayList<Integer> a5 = new ArrayList<Integer>();
		
		a5.add(17);
		a5.add(18);
		a5.add(19);
		a5.add(20);
		
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		matrix.add(new ArrayList<Integer>());
		matrix.add(a2);
		matrix.add(a3);
		matrix.add(a4);
		matrix.add(a5);
		
		System.out.println("ans:   " + diagonal(matrix));
		System.out.println("***************************");
		System.out.println("ans:   " + diagonal2(matrix));
	}

}
