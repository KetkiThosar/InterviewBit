/**
 * 
 */
package com.ib.strings;

/**
 * Problem: Compare two version numbers version1 and version2.
 * 
 * If version1 > version2 return 1, If version1 < version2 return -1, otherwise
 * return 0.
 * 
 * @author ketki
 *
 */
public class CompareVersionNumbers {
	static public int compareVersion(String A, String B) {
		
	    int l1 = A.length();
        int l2 = B.length();
        int l = l2;
        if (l2 > l1) {
            l = l1;
        }
        for (int i = 0; i < l; i++) {
            if (A.charAt(i) == '.' && B.charAt(i) == '.') {
                continue;
            }
            if (A.charAt(i) == '.' && B.charAt(i) != '.') {
                return -1;
            }
            if (A.charAt(i) != '.' && B.charAt(i) == '.') {
                return 1;
            }
            if (A.charAt(i) > B.charAt(i)) {
                return 1;
            }
            if (B.charAt(i) > A.charAt(i)) {
                return -1;
            }
        }
        if (l1 > l2) {
        	
            return 1;
        }
        if (l2 > l1) {
            return -1;
        }
        return 0;
	}


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ans :"
				+ compareVersion("01",
						"1"));
	}

}
