package model;

import expr.Environment;

public class CommentSlot implements Slot {

	private String comment;
	
	public CommentSlot(String comment) {
		this.comment = comment;
	}
	
	/**
	 * Returns the value of a comment, a comments value is always 0.
	 * @param e
	 */
	@Override
	public double getValue(Environment e) {
		return 0;
	}
	
	/**
	 * Returns a String of the comment.
	 * @param e
	 */
	@Override
	public String stringValue(Environment e) {
		return toString();
	}
	
	/**
     * Returns the comment.
     * @return the comment.
     */
	@Override
	public String toString() {
		return comment;
	}

}
