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
		
		
		HashMap<String, Integer> prec = new HashMap<String, Integer>();
		
		Operator multiply = new Operator("*", 4);
		Operator divide = new Operator("/", 3);
		Operator add = new Operator("+", 2);
		Operator subtract = new Operator("-", 1);
        
		prec.put(multiply.getOps(), multiply.getPrec());
		prec.put(divide.getOps(), divide.getPrec());
		prec.put(add.getOps(), add.getPrec());
		prec.put(subtract.getOps(), subtract.getPrec());
		
		
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
        
        for (int i = 0; i  < opsSize; i++) {
        	System.out.println(stack.elementAt(i));
        	
        }
        System.out.println("reached end of stack");
        System.out.println("postfix: " + postfix);

	}//main



}



