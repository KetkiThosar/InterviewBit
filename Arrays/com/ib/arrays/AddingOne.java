package com.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

 * @author ketki
 *
 */
public class AddingOne {

	static public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		Collections.reverse(a);
		int num, carry = 0;
		int n = a.size() - 1;
		for (int i = 0; i <= n; i++) {
			num = a.get(i);
			num += 1;
			if (num % 10 == 0) {
				carry = 1;
				a.set(i, 0);
				continue;
			} else {
				carry = 0;
				a.set(i, num);
				break;
			}
		}
		if (carry == 1) {
			a.add(1);
		} else {
			int k = a.size() - 1;
			while (a.get(k) == 0&&k>=0) {
				a.remove(k);
				k--;
			}
		}
		Collections.reverse(a);
		return a;

	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(0);
		a.add(1);
		a.add(0);
		a.add(9);
		System.out.println("list " + plusOne(a).toString());

	}

}
