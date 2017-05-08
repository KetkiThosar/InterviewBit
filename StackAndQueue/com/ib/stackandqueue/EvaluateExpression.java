package com.ib.stackandqueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author ketki 
 * Evaluate Expression : 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. 
 * Each operand may be an integer or another expression.
 * Examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/","+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateExpression {

	public static void main(String[] args) {
		String[] srr = { "4", "13", "5", "/", "+" };
		ArrayList<String> a = new ArrayList<String>();
		for (String str : srr) {
			a.add(str);
		}
		int result = evalRPN(a);
		System.out.println(result);
	}

	static public int evalRPN(ArrayList<String> a) {
		if (null == a || a.equals("")) {
			throw new IllegalArgumentException();
		}

		Stack<Integer> numberStack = new Stack<Integer>();
		String val = "";
		int no1, no2 = 0;
		for (int i = 0; i < a.size(); i++) {
			val = a.get(i);
			if (!val.equals("*") && !val.equals("/") && !val.equals("+")
					&& !val.equals("-")) {
				numberStack.push(Integer.parseInt(a.get(i)));
				continue;
			}
			no2 = numberStack.pop();
			no1 = numberStack.pop();

			if (val.equals("*")) {
				no1 *= no2;
			} else if (val.equals("/")) {
				no1 /= no2;
			} else if (val.equals("+")) {
				no1 += no2;
			} else if (val.equals("-")) {
				no1 -= no2;
			}
			numberStack.push(no1);
		}

		return numberStack.pop();
	}

}
