package com.pattrtn.observer3;

import java.util.Observable;
import java.util.Observer;

public class OddObserver implements Observer {
	public void update(Observable o, Object arg) {
		if (arg == NumsObservable.ODD) {
			NumsObservable myObserable = (NumsObservable) o;
			System.out.println("OddObserver:Data has changed to "
					+ myObserable.getData());
		}
	}
}
