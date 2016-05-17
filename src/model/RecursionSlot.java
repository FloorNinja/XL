package model;

import expr.Environment;
import util.XLException;

public class RecursionSlot implements Slot {

	public RecursionSlot() {
		
	}
	
	@Override
	public double getValue(Environment e) {
		throw new XLException("Circular Error");
	}
	
	@Override
	public String stringValue(Environment e) {
		throw new XLException("Circular Error");
	}

	@Override
	public String toString(Environment e) {
		throw new XLException("Circular Error Slot");
	}

	

}
