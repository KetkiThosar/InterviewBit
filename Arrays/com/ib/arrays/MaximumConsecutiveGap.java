package com.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumConsecutiveGap {

	static public int maximumGap(final List<Integer> a) {
		

		if (null == a || a.size() < 2) {
			return 0;
		}
		Collections.sort(a);
		int maxGap = Integer.MIN_VALUE;
		//int gap = 0;
		for (int i = 0; i < a.size() - 1; i++) {
			maxGap = Math.max((a.get(i + 1) - a.get(i)), maxGap);
		}

		return maxGap;
	}
	static public int maximumGap2(final List<Integer> A) {
	    
	    if (A == null || A.size() < 2)
	        return 0;
	        
	    int max = A.get(0);
	    int min = A.get(0);
	    int n = A.size();
	    
	    for (int i = 0; i < n; i++) {
	        max = Math.max(max, A.get(i));
	        min = Math.min(min, A.get(i));
	    }
	    
	    int buckets = n - 1;
	    int gap = (max - min - 1) / (n - 1)   + 1;
	    int minArray[] = new int[buckets];
	    int maxArray[] = new int[buckets];
	    int bucket;
	    
	    Arrays.fill(minArray, Integer.MAX_VALUE);
	    Arrays.fill(maxArray, Integer.MIN_VALUE);
	    
	    for (int i = 0; i < n; i++) {
	        int num = A.get(i);
	        
	        if (num == max || num == min)
	            continue;
	        
	        bucket = (num - min) / gap;
	        
	        minArray[bucket] = Math.min(minArray[bucket], num);
	        maxArray[bucket] = Math.max(maxArray[bucket], num);
	    }
	    
	    int res = 0;
	    int maxVal = max;
	    
	    for (int i = 0; i < buckets; i++) {
	        max = minArray[i];
	        
	        if (max != Integer.MAX_VALUE)
                res = Math.max(res, max - min);
	        
	        if (maxArray[i] != Integer.MIN_VALUE) {
	            min = maxArray[i];
	        }
	    }
	    
	    res = Math.max(res, maxVal - min);
	    
	    return res;
	    
	}
	public static void main(String[] args) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);
		a1.add(29);
		a1.add(8);
		a1.add(17);
		a1.add(12);
		a1.add(6);
		
		System.out.println(" "+maximumGap2(a1));
		;
		
	}

}
