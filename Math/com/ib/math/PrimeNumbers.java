/**
 * 
 */
package com.ib.math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem : Given a number N, find all prime numbers upto N ( N included ).
 * Example:

  if N = 7,

  all primes till 7 = {2, 3, 5, 7}

 Make sure the returned array is sorted.
 
 for this sum we are using sieve of Eratosthenes technique
 
 Here the approach is to remove all the multiples of the number starting from 2 till the square root of n. whatever remains are the prime 
 numbers. 
 
 e.g number =11 
 1 2 3 4 5 6 7 8 9 10 11
 stating from 2 cancel all multiples of 2
 4 6 8 10 
 cancel all multiples of 3 
 6 9
 remaining numbers are 2 3 5 7 11
 which are the prime numbers till 11.
 Note -1 is not a prime number 
 
 * @author ketki
 *
 */
public class PrimeNumbers {

	public ArrayList<Integer> sieve(int a) {
		if (a <= 0) {
			return null;
		}		
		int squrtA = (int) Math.sqrt(a);
		
		int[] arr = new int[a+1];
		//initialize with 1
		Arrays.fill(arr, 1);
		
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>(a);
		//set 0th and 1st element to 0
		arr[0]=0;arr[1]=0;
		for (int i = 2; i <= squrtA; i++) {
			if (arr[i] == 1) {
				//set all multiples of i to zero
				for (int j = 2; i * j <= a; j++) {
					arr[i * j]= 0;
				}
			}//end of if
		}// end of for loop
		
		//get all elements from array which has value 1. add their indices
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == 0)
				continue;
			primeNumbers.add(k);
		}
		return primeNumbers;
	}

	public static void main(String[] args) {
		PrimeNumbers n=new PrimeNumbers();
		System.out.println(""+n.sieve(11).toString());

	}

}
