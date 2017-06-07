package com.ib.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberII {

	public int singleNumber(final List<Integer> a) {
		{
		    // Initialize result
		    int result = 0;
		 
		    int x=0, sum=0;
		 
		    // Iterate through every bit
		    for (int i = 0; i < Integer.MAX_VALUE; i++)
		    {
		      // Find sum of set bits at ith position in all
		      // array elements
		      sum = 0;
		      x = (1 << i);
		      System.out.println(x);
		      for (int j=0; j< a.size(); j++ )
		      {
		          if ((a.get(j) & x)==1)
		            sum++;
		      }
		 
		      // The bits with sum not multiple of 3, are the
		      // bits of element with single occurrence.
		      if (sum % 3!=0)
		        result |= x;
		    }
		 
		    return result;
		}
	}

	public static void main(String[] args) {
		SingleNumberII sn=new SingleNumberII();
		ArrayList<Integer>arr=new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(4);
		arr.add(3);
		arr.add(3);
		arr.add(2);
		arr.add(2);
		arr.add(3);
		arr.add(1);
		arr.add(1);
		int k=sn.singleNumber(arr);
		System.out.println(k);
	}

}
