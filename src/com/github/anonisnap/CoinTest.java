package com.github.anonisnap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoinTest {
	static private Coin one;
	static private Coin seven;
	static private Coin ten;
	static private Coin twentyTwo;

	static private int targetValue, coinCount;

	@BeforeAll
	static void setup() {
		one = new Coin(1);
		seven = new Coin(7);
		ten = new Coin(10);
		twentyTwo = new Coin(22);

		UtopiaUtil.setCoinList(one, seven, ten, twentyTwo);
	}

	@BeforeEach
	public void init() {
		targetValue = -1;
		coinCount = -1;
	}

	@Test
	public void testCoinValues() {
		Assertions.assertEquals(1, one.getValue());
		Assertions.assertEquals(7, seven.getValue());
		Assertions.assertEquals(10, ten.getValue());
		Assertions.assertEquals(22, twentyTwo.getValue());
	}

	@Test
	public void testCoinsFourteen() {
		targetValue = 14;
		coinCount = 2;

		Assertions.assertEquals(coinCount, UtopiaUtil.getCoinCount(targetValue));
	}

	@Test
	public void testCoinsIndividualCoins() {
		int targetValueOne = 1;
		int targetValueTwo = 7;
		int targetValueThree = 10;
		int targetValueFour = 22;
		coinCount = 1;

		Assertions.assertEquals(coinCount, UtopiaUtil.getCoinCount(targetValueOne));

		Assertions.assertEquals(coinCount, UtopiaUtil.getCoinCount(targetValueTwo));

		Assertions.assertEquals(coinCount, UtopiaUtil.getCoinCount(targetValueThree));

		Assertions.assertEquals(coinCount, UtopiaUtil.getCoinCount(targetValueFour));
	}

	@Test
	public void testCoinsFifty() {
		targetValue = 50;
		coinCount = 5;

		Assertions.assertEquals(coinCount, UtopiaUtil.getCoinCount(targetValue));
	}

	@Test
	public void testCoinsOneMillion() {
		targetValue = 1000000;
		coinCount = 45457;
		// This works, just very, very slow
		Assertions.assertEquals(coinCount, UtopiaUtil.getCoinCount(targetValue));
	}
}
