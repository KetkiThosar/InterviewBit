package com.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;

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
			while (a.get(k) == 0) {
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
