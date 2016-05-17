package model;

import expr.ExprParser;
import util.XLException;

public class SlotFactory {
	
	
	/**
	 * Constructor
	 */
	public SlotFactory() {
		
	}
	/**
	 * Build the correct slot depending on the String s
	 * @param s
	 * @return slot
	 */
	public Slot buildSlot(String s) {
		ExprParser parser = new ExprParser();
		if(s.length() > 0) {
			if(s.charAt(0) == '#') {
				return new CommentSlot(s);
			}
			else {
				try {
					return new ExpressionSlot(parser.build(s));
				} catch (Exception e) {
					throw new XLException("Input is invalid");
				}
			}
		}
		return null;
	}
	
}
