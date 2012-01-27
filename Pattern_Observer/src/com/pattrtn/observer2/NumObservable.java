package com.pattrtn.observer2;

import java.util.Observable;

public class NumObservable extends Observable {
	private int data = 0;

	public int getData() {
		return data;
	}

	public void setData(int i) {
		data = i;
		setChanged();
		notifyObservers();
	}
}
