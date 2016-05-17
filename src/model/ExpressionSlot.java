package model;

import expr.Environment;
import expr.Expr;

public class ExpressionSlot implements Slot {
	
	private Expr expr;
	
	/**
	 * Constructor
	 * @param expr
	 */
	public ExpressionSlot(Expr expr) {
		this.expr = expr;
	}
	
	/**
	 * Returns the value of the Expression
	 * @param e
	 */
	@Override
	public double getValue(Environment e) {
		return expr.value(e);
	}
	
	/**
	 * Returns a String of the value of the Expression
	 * @param e
	 */
	@Override
	public String stringValue(Environment env) {
		return Double.toString(expr.value(env));
	}

	/**
     * The <code>toString</code> method returns a <code>String</code>
     * representation of this expression without unnecessary parentheses.
     * 
     * @return the <code>String</code> representation of this expression.
     */
	@Override
	public String toString() {
		return expr.toString();
	}

}
