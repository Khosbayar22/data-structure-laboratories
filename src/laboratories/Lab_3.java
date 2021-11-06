package laboratories;

import java.util.Random;
import java.util.Scanner;

import dataStructures.ArrayLinearList;
import dataStructures.LinkedStack;

public class Lab_3 extends LinkedStack {
	
	
	public LinkedStack rand() {
		LinkedStack newStack = new LinkedStack();
        Random getRandom = new Random();
		ArrayLinearList arrayLinearList = new ArrayLinearList();
		int len = this.size();
		for(int i = 0; i < len; i++) {
			arrayLinearList.add(i, this.pop());
		}
		System.out.println(arrayLinearList);
	    while (!arrayLinearList.isEmpty()) {
	        int randomNum = getRandom.nextInt(arrayLinearList.size());
	        newStack.push(arrayLinearList.get(randomNum));
	        arrayLinearList.remove(randomNum);
	    }
	    return newStack;
	}
	
	public LinkedStack addRange(Object[] elements) {
	    Scanner scanner = new Scanner(System.in); 
	    for (int i = 0; i < elements.length; i++) {
	        int newElement = scanner.nextInt();
	        this.push(newElement);
	    }
	    scanner.close(); 
	    return this;
	}
	
	public boolean exists(Object[] element) {
		System.out.println("==================================================================");
        for (int i = 0; i <= this.size(); i++) {
        	for(int j = 0; j < element.length; j++) {
        		if (this.peek() == element[j])
                    return true;
        	}
        	this.pop();
        }
       return false;
    }
	
	public LinkedStack unique() {
        int len = this.size();
	    try {
	        ArrayLinearList ArrayLinearList = new ArrayLinearList();
	        for (int i = 0; i < len; i++) {
	        	ArrayLinearList.add(0, this.pop());
	        }
	        for (int i = 0; i < ArrayLinearList.size(); i++) {
	            for (int j = i + 1; j < ArrayLinearList.size(); j++) {
	                if (ArrayLinearList.get(i).equals(ArrayLinearList.get(j))) {
	                	ArrayLinearList.remove(i);
	                    i--;
	                    break;
	                }
	            }
	        }
	        for (int i = 0; i < ArrayLinearList.size(); i++) {
	            this.push(ArrayLinearList.get(i));
	        }
	    } catch (Exception e) {
	        System.out.println("Ямар ч байсан алдаа гарсан байна. Дахин оролдож үзнэ үү.");
	    }
	    return this;
	}
	
	public Object[] toArray() {
        Object[] tempArray = new Object[this.size()];
        int i = 0;
        while (!empty()) {
        	tempArray[i] = this.peek();
        	System.out.println(tempArray[i]);
        	this.pop();
            i++;
        }
        return tempArray;
	}
	
	public static void main(String[] args) {
		Lab_3 mainStack = new Lab_3();
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Системд оруулах тоогоо оруулна уу ?");
		int num = scanner.nextInt(); 
		for(int i = 0; i < num; i++) {
			mainStack.push(scanner.nextInt());
		}
		System.out.println("1-5 ын хооронд тоогоо оруулна уу ?");
		System.out.println("1. Rand - Санамсаргүйгээр элементүүдийг холих.");
		System.out.println("2. Unique - Давхардлыг арилгаж буцаах.");
		System.out.println("3. AddRange - Элемент нэмэх.");
		System.out.println("4. ToArray - Array хөрвүүлэлт хийх.");
		System.out.println("5. Exists - Ижил элемент байгаа эсэхийг шалгах.");
		
		try {
			int selectMethod = scanner.nextInt();
			switch(selectMethod) {
				case 1: {
					System.out.println("1. Rand - Санамсаргүйгээр элементүүдийг холих.");
					System.out.println(mainStack.rand().toString());
					break;
				}
				case 2: {
					System.out.println("2. Unique - Давхардлыг арилгаж буцаах.");
					System.out.println(mainStack.unique().toString());
					break;
				}
				case 3: {
					System.out.println("3. AddRange - Элемент нэмэх.");
					System.out.println("Оруулах элементийн уртыг оруулах ?");
					int addNumLen = scanner.nextInt();
					Object[] elements = new Object[addNumLen];
					System.out.println(mainStack.addRange(elements).toString());
					break;
				}
				case 4: {
					System.out.println("4. ToArray - Array хөрвүүлэлт хийх.");
					mainStack.toArray();
					break; 
				}
				case 5: {
					System.out.println("5. Exists - Ижил элемент байгаа эсэхийг шалгах.");
					System.out.println("Харьцуулах элементийн уртыг оруулах ?");
					int addNumLen = scanner.nextInt();
					Object[] elements = new Object[addNumLen];
					for(int i = 0; i < addNumLen; i++) {
						elements[i] = scanner.nextInt();
					}
					if(mainStack.exists(elements)) {
						System.out.println("Элемент давхцаж байна."); 
					} else {
						System.out.println("Элемент давхцахгүй байна."); 
					}
					break; 
				}
				default: {
					System.out.println("1-5 ын хооронд оруулна уу !");
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
			scanner.close();
		}
		scanner.close();
	}
}
