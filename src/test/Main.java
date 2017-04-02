package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	
	//Shunting Yard Algorithm 
	
	
	static HashMap<String, Integer> prec = new HashMap<String, Integer>();
	
	
	
	private static boolean isHigher(String c, String topStack) {
		
		System.out.println("**** IsHigher *****");
		System.out.println(" topStack key: " + topStack + " topStack value: " + prec.get(topStack));
		System.out.println(" c key: " + c + " c value: " + prec.get(c));
				
		return prec.get(c) > prec.get(topStack);
	}
	
	public static void main(String[] args) {
		
		
		//test case
		String infix = "2+3*9";
		String [] infixString = infix.split("(?!^)");
		
		Stack<String> stack= new Stack<String>();
		String postfix = "";
		
		
		HashMap<Operator, Integer> prec = new HashMap<Operator, Integer>();
		
		Operator multiply = new Operator("*", 2);
		Operator divide = new Operator("/", 2);
		Operator add = new Operator("+", 2);
		Operator subtract = new Operator("-", 2);
        
		prec.put(multiply, )
		
        for (String c : infixString) {
        	
        	System.out.println("Scanned c: " + c);
        	
        	if (prec.containsKey(c) && stack.isEmpty()) {
        		//c is an operator and stack is empty
        		stack.push(c);
        	}
        	else if (prec.containsKey(c) && !stack.isEmpty()) {
        		System.out.println("Second");
        		System.out.println("c: " + c + " peek: " + stack.peek());
        	
        		/*
        		while (isHigher(c, stack.peek())) {
        			System.out.println("Checked:" + stack.peek());
        			postfix = postfix.concat(stack.pop());
        		}
        		*/
        	}
        	else {
        		//c is an operand
        		postfix = postfix.concat(c);	
        	}
        }
        
        while (!stack.isEmpty()) {
        	postfix = postfix.concat(stack.pop()); 
        }
        
        int opsSize = stack.size();
        
        prec.get("*");
        
        
        //System.out.println(prec.getOrDefault("*", 0));
        
   
        
        
        
        
        //check size of numerator stack
        /*
             for (int i = 0; i < numSize; i++) {
        	System.out.println(numbers.elementAt(i));
        }
        */

        for (int i = 0; i  < opsSize; i++) {
        	System.out.println(stack.elementAt(i));
        	
        }
        System.out.println("reached end of stack");
        System.out.println("postfix: " + postfix);

	}//main


	class Operator {
		
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
		
		public int hashCode() {
			return (int) precedence; 
		}
	}

}



