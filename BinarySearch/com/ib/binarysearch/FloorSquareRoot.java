package com.ib.binarysearch;

public class FloorSquareRoot {

	public int sqrt(int x){
		if(x==0||x==1){
			return x;
		}
		long start=0, end=x/2, mid=0,ans=0;
		//do binary search 
		while(start<=end){
			mid=(start+end)/2;
			//if mid is square root then return mid
			if(mid*mid==x){
				return (int)mid;
			}
			//we update ans as we need floor . i.e. whenever we move closer to sqrt(x) 
			 if(mid*mid<x){
				start=mid+1;
				ans=mid;
			}
			//if mid*mid is greater than x
			else{
				end=mid-1;
			}
		}//end of while loop
		return (int)ans;
	}

	public static void main(String[] args) {
		FloorSquareRoot fsr=new FloorSquareRoot();
		System.out.println(fsr.sqrt(17));

	}

}
