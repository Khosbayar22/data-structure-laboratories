package laboratories;

import java.util.Scanner;

import dataStructures.ArrayStack;
import dataStructures.BinaryTreeNode;
import dataStructures.LinkedBinaryTree;
/*
The source code is based on the Batsukh code.
About him: https://github.com/Pertpert
I will add some calculate function. Idea: Find parent, find child, find leaving, find removing, swap, remove and text file reader.
*/
public class Lab_5 extends LinkedBinaryTree{
	private int isOperation(char temp) 
    { 
        switch (temp) 
        { 
        	case '+': 
        	case '-': 
        		return 1; 
        	case '*': 
        	case '/': 
        		return 2;
        } 
        
        return -1; 
    } 
	
	public String infixToPostfix(String expression) {
		String result = "";
		ArrayStack stack = new ArrayStack();
	
		for(int i = 0; i < expression.length(); i++) {
			char temp = expression.charAt(i); 
            
            if (Character.isLetterOrDigit(temp)) {
                result += temp; 
            }
            else if (temp == '(') {
                stack.push(temp);
            }
            else if (temp == ')') { 
                while (!stack.empty() && (char)stack.peek() != '(') 
                	result += stack.pop(); 
                  
                stack.pop(); 
            }
            else { 
                while (!stack.empty() && isOperation(temp) <= isOperation((char)stack.peek())) {
                    result += stack.pop(); 
                } 
                
                stack.push(temp); 
            } 
		}
		
		while(!stack.empty()) {
			result += stack.pop();
		}
		
		return result;
	}
	
	public String prefixToPostfix(String expression) {
		String result = "";
		ArrayStack stack = new ArrayStack();
		
        for (int i = expression.length() - 1; i >= 0; i--) 
        {
        	char temp= expression.charAt(i);
        	
            if (0 < isOperation(expression.charAt(i))) 
            {
                String str = (String)stack.pop() + (String)stack.pop() + temp;
                
                stack.push(str);
            }
            else {
                stack.push(temp + "");	
            }
        }
        
        result = (String)stack.peek();
        
        return result;
	}
	
	public LinkedBinaryTree buildTreePrefix(String expression) {
		ArrayStack stack = new ArrayStack();
		
		for(int i = expression.length() - 1; i >= 0; i--) {
			char temp = expression.charAt(i);
			
			if(Character.isLetterOrDigit(temp)) {
				LinkedBinaryTree left = new LinkedBinaryTree();
				LinkedBinaryTree right = new LinkedBinaryTree();
				LinkedBinaryTree node = new LinkedBinaryTree();
				node.makeTree(temp, left, right);
				
				stack.push(node);
			}
			else if(0 < isOperation(temp)) {
				LinkedBinaryTree node = new LinkedBinaryTree();
				LinkedBinaryTree left = (LinkedBinaryTree)stack.pop();
				LinkedBinaryTree right = (LinkedBinaryTree)stack.pop();
				node.makeTree(temp, left, right);
				
				stack.push(node);
			}
		}
		
		return (LinkedBinaryTree)stack.pop();
	}
		
		

	public LinkedBinaryTree buildTree(String expression, int type) {
		switch(type) {
			case 1:
				expression = infixToPostfix(expression);
				break;
			case 2:
				expression = prefixToPostfix(expression);
				break;
				default:
					break;
		}
		
		ArrayStack stack = new ArrayStack();
		
		for(int i = 0; i < expression.length(); i++) {
			char temp = expression.charAt(i);
			
			if(Character.isLetterOrDigit(temp)) {
				LinkedBinaryTree left = new LinkedBinaryTree();
				LinkedBinaryTree right = new LinkedBinaryTree();
				LinkedBinaryTree node = new LinkedBinaryTree();
				node.makeTree(temp, left, right);
				stack.push(node);
			}
			else if (0 < isOperation(temp)){
				LinkedBinaryTree right = (LinkedBinaryTree)stack.pop();
				LinkedBinaryTree left = (LinkedBinaryTree)stack.pop();
				LinkedBinaryTree node = new LinkedBinaryTree();
				node.makeTree(temp, left, right);
				stack.push(node);
			}
		}
		
		return (LinkedBinaryTree)stack.pop();
	}
	
	Scanner scan = new Scanner(System.in);
	
	public double calculate(BinaryTreeNode t) {
		if(t == null)
			return 0;
		
		if(Character.isLetter(t.toString().charAt(0))) {
			System.out.print("???????????? ???????? ???????? ?????????????? ????\n" + t.toString() + ": ");
			Object temp = scan.next();
			t.setElement(temp);
		}
		else if(0 < isOperation(t.toString().charAt(0))) {
			switch(t.toString().charAt(0)) {
				case '+':
					return (calculate(t.getLeftChild()) + calculate(t.getRightChild()));
				case '-':
					return (calculate(t.getLeftChild()) - calculate(t.getRightChild()));
				case '*':
					return (calculate(t.getLeftChild()) * calculate(t.getRightChild()));
				case '/':
					return (calculate(t.getLeftChild()) / calculate(t.getRightChild()));
			}
		}
		
		return Double.parseDouble(t.toString());
	}
	
	public String infix(BinaryTreeNode t) {
		if(t == null)
			return "";
		
		String result = "(";
		result += infix(t.getLeftChild());
		result += t.toString();
		result += infix(t.getRightChild());
		result += ")";
		
		return result;
	}
	
	
	public static void main(String[] args) {
		Lab_5 build = new Lab_5();
		LinkedBinaryTree root = new LinkedBinaryTree();
		Scanner sc = new Scanner(System.in);
		
		boolean exit = false;
		
		while(!exit) {
			System.out.print("\n"
					+ "1: ???????? ?????? ??????????????????\n"
					+ "2: ???????????????????????? ???????????? ?????????????? ??????????\n"
					+ "3: ?????????????????????? ?????????? ???????????????????? infix ?????????????????? ????????????\n"
					+ "4: ?????????? prefix ?????????????????? ??????????\n"
					+ "5: ?????????? postfix ?????????????????? ??????????\n"
					+ "6: ??????????"
					+ "\n");
			
			int n = sc.nextInt();
			
			switch(n) {
				case 1:{
					System.out.print("\n?????????????? ?????????????? ????:\n"
							+ "1: Infix\n"
							+ "2: Prefix\n"
							+ "3: Postfix\n\t");
					int type = sc.nextInt();
					
					System.out.print("?????????????????????? ?????????????? ???? - ");
					String expression = sc.next();
					
					root = build.buildTree(expression, type);	
					System.out.print("postorder: ");
					root.postOrderOutput();
					System.out.print("\npreorder: ");
					root.preOrderOutput();
					System.out.print("\ninorder: ");
					root.inOrderOutput();
					System.out.print("\nlevelorder: ");
					root.levelOrderOutput();
					System.out.println("\n?????? ????????????????????????????");
					break;
				}
				case 2:
					System.out.println("Result: " + build.calculate(root.rootBinaryTreeNode()));
					break;
				case 3:
					System.out.println("infix: " + build.infix(root.rootBinaryTreeNode()));
					break;
				case 4:
					System.out.print("\nprefix: ");
					root.preOrderOutput();
					System.out.println();
					break;
				case 5:
					System.out.print("postfix: ");
					root.postOrderOutput();
					break;
				case 6:
					exit = true;
					break;
				default:
					System.out.println("\n?????????? ???????? ???????????????? ??????????!!");
					break;
			}
		}
		
		sc.close();
	}
}
