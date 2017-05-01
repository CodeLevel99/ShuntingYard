package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.math.*;


public class Main {
	
	//Shunting Yard Algorithm 
	
	static HashMap<String, Integer> prec = new HashMap<String, Integer>();
	
	
	public static void main(String[] args) {
		
		String infix = "-2";
		String [] infixString = infix.split("(?!^)");
		
		Stack<String> stack= new Stack<String>();
		ArrayList<String> postfix = new ArrayList<String>();
		
		prec.put("^", 5);
		prec.put("*", 4);
		prec.put("/", 3);
		prec.put("+", 2);
		prec.put("-", 1);
		
		String curString = "";
		
        for (String c : infixString) {
        	
        	System.out.println("Scanned c: " + c);
        	
        	if (prec.containsKey(c)) {
        		//c is an operator and stack is empty
        		postfix.add(curString);
        		curString = ""; 
        		
        		while (!stack.isEmpty() && isHigher(c, stack.peek())) {
        			//if new operator is higher than the current operator at top of stack
        			
        			postfix.add(stack.pop());
        		}
        		stack.push(c);
        	}
        	else {
        		//c is an operand
        		//postfix = postfix.concat(c);	
        		curString = curString.concat(c);
        	}
        	printStack(stack);
        }
        
        if (curString != null && !curString.isEmpty()) {
        	postfix.add(curString);
        }
        
        while (!stack.isEmpty()) {
        	postfix.add(stack.pop()); 
        }
        
        System.out.println("postfix: " + postfix);
        
        //postfix evaluator
        
        Stack<String> post = new Stack<String>();

        //String [] postfixString = postfix.split("(?!^)");
        
        for (String n : postfix) {
        	
        	if (prec.containsKey(n)) {
        		
        		String topStack = post.peek();
        		post.pop();
        		
        		int retVal = 0;
        		
        		switch(n) { 
        			case "^":
        				retVal = (int) Math.pow(Integer.parseInt(post.pop()), Integer.parseInt(topStack));
        				break;
        			case "*":
        				retVal = Integer.parseInt(post.pop()) * Integer.parseInt(topStack);
        				break;
        			case "+":
        				retVal = Integer.parseInt(post.pop()) + Integer.parseInt(topStack);
        				break;
        			case "-":
        				retVal = Integer.parseInt(post.pop()) - Integer.parseInt(topStack);
        				break;
        			case "/": 
        				retVal = Integer.parseInt(post.pop()) / Integer.parseInt(topStack);
        				break;
        			default:
        				break;
        		}
        		
        		post.push(Integer.toString(retVal)); 
        		
        		System.out.print("Current stack" + Arrays.toString(post.toArray()));
        		System.out.println(" ");
        		
        	}
        	else {
        		//operand
        		post.push(n);
        	}
        }
        
        System.out.println("evaluated: " + post.peek());
        
        
        	
	}//main
	
	private static boolean isHigher(String c, String topStack) {
		
		//if the operator on top of stack is higher than operator scanned, return true
		return prec.get(topStack) > prec.get(c);
	}
	
	public static void printStack(Stack stack) {
		
        int opsSize = stack.size();
        
        System.out.println("Printed stack: ");
        
        for (int i = 0; i  < opsSize; i++) {
        	System.out.print(stack.elementAt(i));	
        }
        System.out.println(" ");
	}
}



