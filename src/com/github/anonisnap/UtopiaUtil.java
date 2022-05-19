package com.github.anonisnap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtopiaUtil {
	private static List<Coin> coinList = new ArrayList<>();

	/**
	 * Set the CoinList which are to be used
	 *
	 * @param c Valid Coin in your scenario
	 */
	public static void setCoinList(Coin... c) {
		coinList = new ArrayList<>(Arrays.asList(c));
		coinList.sort(Coin::compareTo);
		Collections.reverse(coinList);
	}

	/**
	 * Get the lowest coin count, adding up to the given value
	 *
	 * @param value Value to add up to
	 * @return Lowest Count of coins needed to get value
	 */
	public static int getCoinCount(int value) {
		int[] counts = {value, value, value, value};

		// Base Case | Coin is the same as the Value
		if (coinList.contains(new Coin(value))) {
			return 1;
		}

		// Recursive Calls on Coins
		for (int i = 0; i < coinList.size(); i++) {
			if (coinList.get(i)
			            .getValue() <= value) {
				counts[i] = getCoinCount(value - coinList.get(i)
				                                         .getValue());
			}
		}
		// return 1 + Minimum of Counts[]
		return 1 + Math.min(Math.min(counts[0], counts[1]), Math.min(counts[2], counts[3])); // This may be faster than using Arrays.sort()
	}
}
