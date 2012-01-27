package com.pattrtn.observer3;

import java.util.Observable;
import java.util.Observer;

public class EvenObserver implements Observer {
	public void update(Observable o, Object arg) {
		if (arg == NumsObservable.EVEN) {
			NumsObservable myObserable = (NumsObservable) o;
			System.out.println("EvenObserver:Data has changed to "
					+ myObserable.getData());
		}
	}
}
