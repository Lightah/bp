package com.lightah.bp.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Lightah
 */
public class BetterProgrammerTask {

	/**
	 * Returns a {@link List} of integers corresponding to the required reversals.
	 * 
	 * For example, to sort [12,13,11,14], you need to reverse the order of the
	 * first two (2) elements and get [13,12,11,14] and then reverse the order of
	 * the first three (3) elements and get [11,12,13,14]
	 * 
	 * @param a
	 *            the integer array to sort
	 * @return a {@link List} of integers corresponding to the required reversals.
	 */
	public static List<Integer> getReversalsToSort(int[] a) {
		List<Integer> reversals;
		int reverseIndex;
		int[] array;

		print("Input", a);

		reversals = new ArrayList<Integer>();
		if (a == null || a.length == 0) {
			// There is nothing to sort
			return reversals;
		}

		array = new int[a.length];
		System.arraycopy(a, 0, array, 0, a.length);

		reverseIndex = 1;
		while (!checkOrder(array)) {
			print("  Start reverse", array);

			if (reverseIndex > array.length) {
				// This sequence can't be sorted this way
				throw new UnsupportedOperationException();
			}

			reverse(array, reverseIndex);

			print("  End reverse", array);

			// Every iteration reverse more elements
			reverseIndex++;
			// The number of reversed elements is the index + 1
			reversals.add(reverseIndex);
		}

		return reversals;
	}

	/**
	 * Check if the integers array is ordered.
	 */
	private static boolean checkOrder(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}

		return true;
	}

	private static void print(String text, int[] array) {
		System.out.println(String.format("%s: %s", text, Arrays.toString(array)));
	}

	private static void reverse(int[] array, int toIndex) {
		int temp;
		int stop;

		stop = Math.min(toIndex, array.length - 1);

		for (int i = 0; i < stop; i++) {
			temp = array[i];

			array[i] = array[stop - i];
			array[stop - i] = temp;
		}
	}

	public static void main(String[] args) {
		for (int i : getReversalsToSort(null)) {
			System.out.println(i);
		}

		for (int i : getReversalsToSort(new int[] { 12, 13, 11, 14 })) {
			System.out.println(i);
		}

		try {
			for (int i : getReversalsToSort(new int[] { 11, 12, 13, 11, 14 })) {
				System.out.println(i);
			}
		} catch (UnsupportedOperationException e) {
			System.out.println(String.format("Expected exception %s", e));
		}

		try {
			for (int i : getReversalsToSort(new int[] { 19, 18, 19, 11, 12 })) {
				System.out.println(i);
			}
		} catch (UnsupportedOperationException e) {
			System.out.println(String.format("Expected exception %s", e));
		}
	}
}
