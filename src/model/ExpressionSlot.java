package model;

import expr.Environment;
import expr.Expr;

public class ExpressionSlot implements Slot {
	
	private Expr expr;
	
	public ExpressionSlot(Expr expr) {
		this.expr = expr;
	}

	@Override
	public double getValue(Environment e) {
		// TODO Auto-generated method stub
		return expr.value(e);
	}
	
	@Override
	public String stringValue(Environment env) {
		// TODO Auto-generated method stub
		return Double.toString(expr.value(env));
	}

	@Override
	public String toString(Environment e) {
		// TODO Auto-generated method stub
		return expr.toString();
	}

}
