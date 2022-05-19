package com.github.anonisnap;

public class Coin implements Comparable<Coin> {
	private final int value;

	public Coin(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Coin o) {
		return value - o.getValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coin) {
			return ((Coin) obj).getValue() == value;
		}
		return false;
	}
}
