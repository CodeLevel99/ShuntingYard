package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	
	//Shunting Yard Algorithm 
	
	static HashMap<String, Integer> prec = new HashMap<String, Integer>();
	

	public static void main(String[] args) {
		
		
		//test case
		String infix = "2+3*9-7";
		String [] infixString = infix.split("(?!^)");
		
		Stack<String> stack= new Stack<String>();
		String postfix = "";
		
		/*
		Operator multiply = new Operator("*", 4);
		Operator divide = new Operator("/", 3);
		Operator add = new Operator("+", 2);
		Operator subtract = new Operator("-", 1);
        
        
		prec.put(multiply, multiply.getPrec());
		prec.put(divide, divide.getPrec());
		prec.put(add, add.getPrec());
		prec.put(subtract, subtract.getPrec());
		
		*/
		prec.put("*", 4);
		prec.put("/", 3);
		prec.put("+", 2);
		prec.put("-", 1);
		
        for (String c : infixString) {
        	
        	System.out.println("Scanned c: " + c);
        	
        	if (prec.containsKey(c) && stack.isEmpty()) {
        		//c is an operator and stack is empty
        		stack.push(c);
        	}
        	else if (prec.containsKey(c) && !stack.isEmpty()) {
        		System.out.println("Second");
        		System.out.println("c: " + c + " peek: " + stack.peek());
        		
        		while (!stack.isEmpty() && isHigher(c, stack.peek())) {
        			postfix = postfix.concat(stack.pop());
        		}
        		stack.push(c);
        	}
        	else {
        		//c is an operand
        		postfix = postfix.concat(c);	
        	}
        	printStack(stack);
        }
        
        while (!stack.isEmpty()) {
        	postfix = postfix.concat(stack.pop()); 
        }
        

        System.out.println("reached end of stack");
        System.out.println("postfix: " + postfix);

	}//main
	
	private static boolean isHigher(String c, String topStack) {
		
		System.out.println("**** IsHigher *****");
		System.out.println(" topStack key: " + topStack + " topStack value: " + prec.get(topStack));
		System.out.println(" c key: " + c + " c value: " + prec.get(c));
				
		return prec.get(topStack) > prec.get(c);
	}
	
	
	public static void printStack(Stack stack) {
		
        int opsSize = stack.size();
        
        for (int i = 0; i  < opsSize; i++) {
        	System.out.print(stack.elementAt(i));	
        }
        System.out.println(" ");
	}
}



