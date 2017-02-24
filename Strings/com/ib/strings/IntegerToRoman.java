package com.ib.strings;
/**
Given an integer, convert it to a roman numeral, 
and return a string corresponding to its roman numeral version

Input is guaranteed to be within the range from 1 to 3999.

Example :

Input : 5
Return : "V"

Input : 14
Return : "XIV"

 * @author ketki
 *
 */
public class IntegerToRoman {

	
	static public String intToRoman2(int n) {
	    int[] A = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] B = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    StringBuilder sb = new StringBuilder();
	    int i=0,k=i;
	    for(i=k; i<A.length; i++) {
	        while(n >= A[i]) {
	            sb.append(B[i]);
	            n -= A[i];
	        }
	        k=i;
	    }
	    return sb.toString();
	}

	public static void main(String[] args) {
		//System.out.println("Ans: " + intToRoman(238));
		System.out.println("Ans: " + intToRoman2(238));
	}
	/*static public String intToRoman(int a) {
		if (a <= 0 ||a>3999) {
			return "";
		}
		StringBuilder output = new StringBuilder();
		int num = a, count = 0;
		if (num >= 1000) {
			while (num >= 1000) {
				output.append("M");
				num -= 1000;
				count++;
			}
			a -= 1000 * count;
		}
		if (a < 1000 && a >= 500) {
			if (a >= 900 && a < 1000) {
				output.append("CM");
				a -= 900;
			} else {
				output.append("D");
				a -= 500;
				num = a;
				count = 0;
				while (num >= 100) {
					output.append("C");
					count++;
					num -= 100;
				}
				a -= 100 * count;
			}
		}
		if (a < 500 && a >= 100) {
			if (a >= 400 && a < 500) {
				output.append("CD");
				a -= 400;
			} else {
				output.append("C");
				a -= 100;
				num = a;
				count = 0;
				while (num >= 100) {
					output.append("C");
					count++;
					num -= 100;
				}
				a -= 100 * count;
			}
		}
		if (a < 100 && a >= 50) {
			if (a >= 90 && a < 100) {
				output.append("XC");
				a -= 90;
			} else {
				output.append("L");
				a -= 50;
				num = a;
				count = 0;
				while (num >= 10) {
					output.append("X");
					count++;
					num -= 10;
				}
				a -= 10 * count;
			}

		}
		if (a < 50 && a >= 10) {
			if (a >= 40 && a < 50) {
				output.append("XL");
				a -= 40;
			} else {
				num = a;
				count = 0;
				while (num >= 10) {
					output.append("X");
					count++;
					num -= 10;
				}
				a -= 10 * count;
			}
		}
		if (a < 10 && a >= 5) {
			if (a >= 9) {
				output.append("IX");
				a -= 9;
			} else {
				output.append("V");
				a -= 5;
				num = a;
				count = 0;
				while (num > 5) {
					output.append("I");
					num -= 1;
					count++;
				}
				a -= 1 * count;
			}

		}
		if (a < 5 && a >= 1) {
			if (a == 4) {
				output.append("IV");
				a -= 4;
			} else {
				num = a;
				count = 0;
				while (num >= 1) {
					output.append("I");
					num -= 1;
					count++;
				}
				a -= 1 * count;
			}
		}

		return output.toString();
	}*/
}
