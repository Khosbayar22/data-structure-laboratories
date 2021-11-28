package laboratories;

import java.util.Scanner;

import dataStructures.ArrayStack;
import dataStructures.LinkedBinaryTree;

public class Lab_5 extends LinkedBinaryTree{
	
	public LinkedBinaryTree buildTree(String expression) {
		char[] symbols = expression.toCharArray();
		ArrayStack stack = new ArrayStack();
		char symbol; 
		for(int i = 0; i < symbols.length; i++) {
			symbol = symbols[i];
			if(symbol >= 'a' && symbol <= 'z' || symbol >= '0' && symbol <= '9') {
				LinkedBinaryTree l = new LinkedBinaryTree();
				LinkedBinaryTree r = new LinkedBinaryTree();
				LinkedBinaryTree node = new LinkedBinaryTree();
				node.makeTree(node, l, r);
				stack.push(node);
			} else if(symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
				LinkedBinaryTree l = new LinkedBinaryTree();
				LinkedBinaryTree r = new LinkedBinaryTree();
				LinkedBinaryTree node = new LinkedBinaryTree();
				r = (LinkedBinaryTree) stack.pop();
				l = (LinkedBinaryTree) stack.pop();
				node.makeTree(node, l, r);
				stack.push(node);
			} else {
				System.out.println("Symbol not correct.");
			}
		} 
		return (LinkedBinaryTree) stack.pop();
	}
	public static void main(String[] args) {
		System.out.println("Илэрхийлэлээ оруулна уу ?");
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		Lab_5 build = new Lab_5();
		LinkedBinaryTree root = build.buildTree(expression);
		root.inOrderOutput();
		System.out.println();
//		root.preOrderOutput();
//		System.out.println();
//		root.levelOrderOutput();
//		System.out.println();
		scanner.close();
	}
}
