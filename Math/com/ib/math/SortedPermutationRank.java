/**
 * 
 */
package com.ib.math;


/**
 * problem: Given a string, find the rank of the string amongst its permutations
 * sorted lexicographically. Assume that no characters are repeated.
 * 
 * Example :
 * 
 * Input : 'acb' Output : 2
 * 
 * The order permutations with letters 'a', 'c', and 'b' :
 *  abc 
 *  acb 
 *  bac 
 *  bca 
 *  cab
 *  cba 
 *  
 * The answer might not fit in an integer, so return your answer % 1000003
 * 
 * @author ketki
 *
 */
public class SortedPermutationRank {

	/**
	 * This is interview bit version . more efficient way.
	 * 
	 * @param a
	 * @return
	 */
	static public int findRank2(String a) {
		System.out.print(a + "\t\t");
		if (null == a || ("").equals(a.trim())) {
			return 0;
		}
		a = a.trim();
		long permutation = 0;
		for (int i = 0; i < a.length(); i++) {
			permutation += lessCharNumber(i, a) * fact(a.length() - i - 1);
			permutation %= 1000003;
		}
		permutation += 1;

		return (int) (permutation);
	}

	/**
	 * @param args
	 */
	
	static long fact(int n) {
		if (n == 0)
			return 1;
		return n * fact(n - 1) % 1000003;

	}

	static int lessCharNumber(int i, String a) {
		int lessCount = 0;
		for (int j = i + 1; j < a.length(); j++) {
			if (a.charAt(i) > a.charAt(j)) {
				lessCount++;
			}
		}
		return lessCount;
	}

	public static void main(String[] args) {
		// System.out.println(fact(11));
		System.out.println(findRank2("edca"));
		System.out.println(findRank2("acb"));
		System.out.println(findRank2("view"));
		System.out.println(findRank2("viwe"));
		System.out.println(findRank2("bca"));
		System.out.println(findRank2("ba"));
		System.out.println(findRank2("cba"));
		System.out.println(findRank2("znmdvqrst"));
		System.out.println(findRank2("nerajdoki"));
		System.out.println(findRank2("DTNGJPURFHYEW"));
		System.out.println(findRank2("ZCSFLVHXRYJQKWABGT"));
		System.out.println(findRank2("qwertyuioplkjhgfdsazxcvbnm0987654321"));
		System.out.println(findRank2("q"));
		System.out.println(findRank2("qwertyuioplkjhgfdsazxcvbnm0987654321"));
	}
}
