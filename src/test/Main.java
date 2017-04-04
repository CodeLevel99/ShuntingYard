package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	
	//Shunting Yard Algorithm 
	
	static HashMap<String, Integer> prec = new HashMap<String, Integer>();
	
	
	public static void main(String[] args) {
		
		String infix = "2+3*9-7";
		String [] infixString = infix.split("(?!^)");
		
		Stack<String> stack= new Stack<String>();
		String postfix = "";
		
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
        
        System.out.println("postfix: " + postfix);
        
        //postfix evaluator
        
        Stack<String> post = new Stack<String>();
        
        String expression = ""; 
        
        String [] postfixString = postfix.split("(?!^)");
        
        for (String n : postfixString) {
        	if (prec.containsKey(n)) {
        		
        		String topStack = post.peek();
        		post.pop();
        		
        		int retVal = 0;
        		
        		switch(n) { 
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



