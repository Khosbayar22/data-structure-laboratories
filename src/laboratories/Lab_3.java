package laboratories;

import java.util.Scanner;

import dataStructures.ArrayLinearList;
import dataStructures.LinkedStack;

public class Lab_3 extends LinkedStack {
	
	public LinkedStack rand() {
		LinkedStack MainStack = new LinkedStack();
		LinkedStack newStack = new LinkedStack();
		LinkedStack tempStack = new LinkedStack();
	    Object[] arrayStack = this.toArray();
	    for (int i = 0; i < this.size(); i++) {
	        MainStack.push(arrayStack[i]);
	    }
	    while (!MainStack.empty()) {
	        int r = (int)(Math.random() * MainStack.size());
	        for (int i = 0; i <= r; i++) {
	            if (r == i) {
	                newStack.push(MainStack.pop());
	                break;
	            } else {
	                tempStack.push(MainStack.pop());
	            }
	        }
	        for (int k = 0; k < tempStack.size(); k++) {
	            MainStack.push(tempStack.pop());
	        }
	    }
	    return newStack;
	}
	
	public LinkedStack addRange(Object[] elements) {
	    Scanner sc = new Scanner(System.in); 
	    for (int i = 0; i < elements.length; i++) {
	        char t = sc.next().charAt(0);
	        this.push(t);
	    }
	    sc.close(); 
	    return this;
	}
	
	public boolean exists(Object element) {
		LinkedStack tempStack = new LinkedStack();
        Object[] arrayStack = this.toArray();
        for (int i = 0; i < this.size(); i++) {
            tempStack.push(arrayStack[i]);
        }
        for (int i = 0; i <= this.size(); i++) {
            if (tempStack.peek().equals(element))
                return true;
            else
                tempStack.pop();
        }
       return false;
    }
	
	public LinkedStack unique() {
		LinkedStack tempStack = new LinkedStack();
	    try {
	        Object[] arrayStack = this.toArray();
	        for (int i = 0; i < this.size(); i++) {
	            tempStack.push(arrayStack[i]);
	        }
	        ArrayLinearList linearStack = new ArrayLinearList();
	        int e = tempStack.size();
	        for (int i = 0; i < e; i++) {
	            linearStack.add(0, tempStack.pop());
	        }
	        for (int i = 0; i < linearStack.size(); i++) {
	            for (int j = i + 1; j < linearStack.size(); j++) {
	                if (linearStack.get(i).equals(linearStack.get(j))) {
	                    linearStack.remove(i);
	                    i--;
	                    break;
	                }
	            }
	        }
	        for (int i = 0; i < linearStack.size(); i++) {
	            tempStack.push(linearStack.get(i));
	        }
	    } catch (Exception e) {
	        System.out.println("Error");
	    }
	    return tempStack;
	}
	
	public Object[] toArray() {
        Object[] arrayStack = new Object[this.size()];
        LinkedStack tempStack = new LinkedStack();
        int i = 0;
        while (!empty()) {
            arrayStack[i] = this.peek();
            tempStack.push(this.pop());
            i++;
        }
        while (!tempStack.empty()) {
            this.push(tempStack.pop());
        }
        return arrayStack;
	}
	
	public static void main(String[] args) {
		Lab_3 mainStack = new Lab_3();
		mainStack.push('A');
		mainStack.push('B');
		mainStack.push('C');
		mainStack.push('D');
		mainStack.push('E');

	}
}
