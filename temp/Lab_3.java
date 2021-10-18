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
		Scanner sc = new Scanner(System.in); 
		System.out.println("Systemd oruulah toogoo oruulna uu");
		int num = sc.nextInt(); 
		for(int i = 0; i < num; i++) {
			mainStack.push(sc.nextInt());
		}
		System.out.println("1-5 iin hoorond uildelee songono uu ?");
		System.out.println("1. Rand - Sanamsarguigeer elementuudiig holih");
		System.out.println("2. Unique - Davhardliig arilgaj butsaah");
		System.out.println("3. AddRange - Massiveiin element nemeh");
		System.out.println("4. ToArray - Arrayluu hurvuulne");
		System.out.println("5. Exists - Ijil element baigaa esehiig shalgah");
		
		try {
			int chmethod = sc.nextInt();
			switch(chmethod) {
				case 1: {
					System.out.println("1. Rand - Sanamsarguigeer elementuudiig holih");
					System.out.println(mainStack.rand().toString());
					break;
				}
				case 2: {
					System.out.println("2. Unique - Davhardliig arilgaj butsaah");
					System.out.println(mainStack.unique().toString());
					break;
				}
				case 3: {
					System.out.println("3. AddRange - Massiveiin element nemeh");
					System.out.println("Oruulah elementiin urtaa oruulna uu ?");
					int addNumLen = sc.nextInt();
					Object[] elements = new Object[addNumLen];
					for(int i = 0; i < addNumLen; i++) {
						elements[i] = sc.nextInt();
					}
					System.out.println(mainStack.addRange(elements).toString());
					break;
				}
				case 4: {
					System.out.println("4. ToArray - Arrayluu hurvuulne");
					for(int i = 0; i < mainStack.toArray().length; i++) {
						System.out.println(mainStack.toArray()[i]);
					}
					break; 
				}
				case 5: {
					System.out.println("5. Exists - Ijil element baigaa esehiig shalgah");
					System.out.println("Oruulah elementiin urtaa oruulna uu ?");
					int addNumLen = sc.nextInt();
					Object[] elements = new Object[addNumLen];
					for(int i = 0; i < addNumLen; i++) {
						elements[i] = sc.nextInt();
					}
					System.out.println(mainStack.exists(elements));
					break; 
				}
				default: {
					System.out.println("1-5 iin dotor uildel hiine uu");
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
