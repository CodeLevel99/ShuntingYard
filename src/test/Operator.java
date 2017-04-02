package test;

public class Operator {
	
	private String operator;
	private int precedence;
	
	public Operator(String ops, int prec) {
		operator = ops;
		precedence = prec; 
	}
	
	public int getPrec() {
		return precedence;
	}
	
	public String getOps() {
		return operator; 
	}
}
