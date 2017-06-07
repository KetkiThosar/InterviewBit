package com.ib.bitmanipulation;
/**
 *Calculate no. of set bits in the number. Return the count, 
 * @author ketki
 *
 */
public class NumberOf1Bits {

	/**
	 * number & number-1 always sets off the last set bit of the number.
	 * 5&4 will give 4 as the last set bit of 5 is set to 0.
	 * If while loop is run till number becomes zero 
	 * and if number is & with its previous number 
	 * Then the count of 1 will equal to the no of times loop is executed.  
	 * This algorithm is known as Brian karnigham algorithm.
	 * @param a
	 * @return
	 */
	public int numSetBits(long a) {
		int count = 0;
		while(a!=0){
			a&=a-1;
			count++;
		}
		System.out.println("count of 1's in no: "+count);
		return count;
	}

	public static void main(String[] args) {
		new NumberOf1Bits().numSetBits(0);
		
	}

}
