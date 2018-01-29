package com.lightah.bp.task1;

/**
 * 
 * @author Lightah
 */
public class BetterProgrammerTask {

	/**
	 * Calculate the optimal {@link Change} to return for a given number of cents.
	 * 
	 * For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
	 * 
	 * @param changeInCents
	 *            The amount of cents.
	 * @return {@link Change} indicating a optimized number of coins to return for
	 *         the given cents. Null if the parameter is negative.
	 */
	public static Change getCorrectChange(int changeInCents) {
		int dollars;
		int quarters;
		int dimes;
		int nickels;
		int cents;

		if (changeInCents < 0) {
			return null;
		}

		dollars = changeInCents / 100;
		changeInCents = changeInCents - (dollars * 100);
		quarters = changeInCents / 25;
		changeInCents = changeInCents % 25;
		dimes = changeInCents / 10;
		changeInCents = changeInCents % 10;
		nickels = (changeInCents / 5);
		changeInCents = changeInCents % 5;
		cents = changeInCents;

		return new Change(dollars, quarters, dimes, nickels, cents);
	}

	// Please do not change this class
	static class Change {
		private final int _dollars;
		private final int _quarters; // 25 cents
		private final int _dimes; // 10 cents
		private final int _nickels; // 5 cents
		private final int _cents; // 1 cent

		public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
			_dollars = dollars;
			_quarters = quarters;
			_dimes = dimes;
			_nickels = nickels;
			_cents = cents;
		}

		public int getDollars() {
			return _dollars;
		}

		public int getQuarters() {
			return _quarters;
		}

		public int getDimes() {
			return _dimes;
		}

		public int getNickels() {
			return _nickels;
		}

		public int getCents() {
			return _cents;
		}
	}

	public static void main(String[] args) {
		Change change;

		change = getCorrectChange(164);
		if (change != null) {
			System.out.println(String.format("164 cents --> dollars[%s] quarters[%s] dimes[%s] nickels[%s] cents[%s]",
					change.getDollars(), change.getQuarters(), change.getDimes(), change.getNickels(),
					change.getCents()));
		}

		change = getCorrectChange(234);
		if (change != null) {
			System.out.println(String.format("234 cents --> dollars[%s] quarters[%s] dimes[%s] nickels[%s] cents[%s]",
					change.getDollars(), change.getQuarters(), change.getDimes(), change.getNickels(),
					change.getCents()));
		}

		change = getCorrectChange(0);
		if (change != null) {
			System.out.println(String.format("0 cents --> dollars[%s] quarters[%s] dimes[%s] nickels[%s] cents[%s]",
					change.getDollars(), change.getQuarters(), change.getDimes(), change.getNickels(),
					change.getCents()));
		}

		change = getCorrectChange(-10);
		System.out.println("-10 cents --> " + (change == null ? "PASS" : "FAIL"));
	}
}
