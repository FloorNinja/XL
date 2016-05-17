package model;

import expr.Environment;

public interface Slot {
	
	public double getValue(Environment e);
	
	public String stringValue(Environment e);
	
	@Override
	public String toString(); 
}
