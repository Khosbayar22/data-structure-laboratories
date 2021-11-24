package homework_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataStructures.LinkedStack;

public class CarParking  {
	
	LinkedStack carStack = new LinkedStack();
	
	public CarParking() {
		super();
	}
	
    public void input() {
    	Scanner scanner = new Scanner(System.in);
        try {
            File myObj = new File("C:/Eclipse Projects/java_labs/src/homework_2/cars.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
            	String str = myReader.nextLine();
            	this.process(str);
            }
            myReader.close();
            
        } catch (FileNotFoundException e) {
        	System.out.print(e);
            e.printStackTrace();
        }
        scanner.close();
    }
    
    public void output(LinkedStack car, int cnt, String targetCar) {
    	if(car.size() <= 10) {
    		if(cnt == 0) {
    			System.out.println(car.peek().toString() + " -> There is room");
    		} else {
    			System.out.println(targetCar + " -> " + cnt + " cars moved out");
    		}
    	} else {
    		System.out.println(car.peek().toString() + " -> Garage full, this car cannot enter");
    	}
    	
    }
    
    public LinkedStack processDaparture(LinkedStack car, String targetCar) {
    	LinkedStack newStack = new LinkedStack();
    	LinkedStack tempStack = new LinkedStack();
    	int tempCnt = 0; 
    	int cnt = 0; 
    	Boolean isFull = false;
    	
		while (!carStack.empty()) {
			if(carStack.peek().equals(targetCar)) {
				carStack.pop();
				tempCnt = cnt;
				isFull = true;
    		} else {
    			tempStack.push(carStack.pop()); 
    			cnt ++; 
    		}
	    }
		while(!tempStack.empty()) { // Reverse stack
			newStack.push(tempStack.pop());
		}
		
		if(!isFull) {
			System.out.println(targetCar + " -> This car not in the garage.");
		} else {
			this.output(newStack, tempCnt, targetCar);
		}
        return newStack;
    }
    
    
    public void process(String request) {
    	if(request.substring(0, 1).equals("A")) {
    		carStack.push(request.substring(2, 9));
    		this.output(carStack, 0, "");
    	} else {
    		carStack = this.processDaparture(carStack, request.substring(2, 9));
    	} 
    }
    
    public static void main(String[] args) {
    	 CarParking carParking = new CarParking();
    	 carParking.input();
    }
}
