package model;

import expr.Environment;
import util.XLException;

public class RecursionSlot implements Slot {

	/**
	 * Constructor
	 */
	public RecursionSlot() {
		
	}
	
	/**
	 * throws XLException because of the slots property as an error slot.
	 */
	@Override
	public double getValue(Environment e) {
		throw new XLException("Circular Error");
	}
	
	/**
	 * throws XLException because of the slots property as an error slot.
	 */
	@Override
	public String stringValue(Environment e) {
		throw new XLException("Circular Error");
	}
	
	/**
	 * throws XLException because of the slots property as an error slot.
	 */
	@Override
	public String toString(Environment e) {
		throw new XLException("Circular Error");
	}

	

}
