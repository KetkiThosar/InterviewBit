package com.ib.strings;
import java.util.HashMap;

/**
 * Problem:Given a roman numeral, convert it to an integer.

	Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Input : "XIV"
   Return : 14
 * 
 * 
 * @author ketki
 *
 */
public class RomanToInteger {

	/**
	 * converts string representing roman digits  into integer
	 * range is 1 to 3999
	 * @param a
	 * @return
	 */
	static public int romanToInt(String a) {
		if (null == a||("").equals(a.trim())) {
			return -1;
		}
		HashMap<Character, Integer> romanSymbolVal = new HashMap<Character, Integer>();
		romanSymbolVal.put('I', 1);
		romanSymbolVal.put('V', 5);
		romanSymbolVal.put('X', 10);
		romanSymbolVal.put('L', 50);
		romanSymbolVal.put('C', 100);
		romanSymbolVal.put('D', 500);
		romanSymbolVal.put('M', 1000);
		a = a.trim();
		int number = 0;
		Integer first = 0, second = 0;
		for (int i = 1; i < a.length()
				&& (a.charAt(i) != ' ' || a.charAt(i) != '\t'); i++) {
			first = romanSymbolVal.get(a.charAt(i - 1));
			second = romanSymbolVal.get(a.charAt(i));
			if (null == first || null == second) {
				number = -1;
				break;
			}
			if (first < second) {
				number -= first;//if small number precedes large number then subtract value
			} else {
				number += first; // else add
			}
		}//end of for loop
		number+=romanSymbolVal.get(a.charAt(a.length()-1));
		return number;
	}
	/**
	 * Interview bit version
	 * @param A
	 * @return
	 */
	static public int romanToIntIBVersion(String A) {
	    int i=0;
        int ret=0;
        String codes[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int val[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        while(A.length()>0)
        {
            while(A.startsWith(codes[i]))
            {
                ret+=val[i];
                A=A.substring(codes[i].length());
            }
            i++;
        }
        return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ans:MCMLIV "+romanToInt("MCMLIV"));
		System.out.println("ans:MCMXC "+romanToInt("MCMXC"));
		System.out.println("ans:MMXIV "+romanToInt("MMXIV"));
		System.out.println("ans:CD "+romanToInt("CD"));
		System.out.println("ans:MLXVI "+romanToInt("MLXVI"));
		System.out.println("ans:CCVII "+romanToIntIBVersion("CCVII"));
		System.out.println("ans:XCIX "+romanToIntIBVersion("XI"));
	}

}
