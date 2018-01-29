package com.lightah.bp.task2;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * @author Lightah
 */
public class BetterProgrammerTask {

	/**
	 * Removes duplicate values from the given integer array. The order of elements
	 * is and only the first occurrence of a duplicate is retained.
	 * 
	 * For example, parameter: {2,1,2,3} result: {2,1,3}
	 * 
	 * @param a
	 *            integer array
	 * @return integer array without any duplicate values.
	 */
	public static int[] removeDuplicates(int[] a) {
		Set<Integer> set;
		int[] uniquesArray;
		int count;

		if (a == null || a.length < 2) {
			return a;
		}

		set = new LinkedHashSet<Integer>();
		for (int i : a) {
			set.add(i);
		}

		uniquesArray = new int[set.size()];
		count = 0;

		for (Integer i : set) {
			uniquesArray[count] = i;
			count++;
		}

		return uniquesArray;
	}

	public static void main(String[] args) {
		for (int i : removeDuplicates(new int[] { 2, 1, 2, 3 })) {
			System.out.println(i);
		}
	}
}
