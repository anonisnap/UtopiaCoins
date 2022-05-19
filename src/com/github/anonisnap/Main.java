package com.github.anonisnap;

public class Main {

	public static void main(String[] args) {
		UtopiaUtil.setCoinList(new Coin(1), new Coin(7), new Coin(10), new Coin(22));
		int val = 1000;
		System.out.printf("Coin Count (%d): %d\n", val, UtopiaUtil.getCoinCount(val));
	}
}
