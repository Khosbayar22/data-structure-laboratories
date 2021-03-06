package laboratories;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dataStructures.ArrayLinearList;
import dataStructures.HashTable;

public class Lab_4 extends HashTable {

    public Lab_4(int theDivisor) {
        super(theDivisor);
    }

    public void delete(Object theKey) {
    	try {
            int i = search(theKey);
            table[i] = null;
            
		} catch (Exception e) {
			System.out.println("Not found.");
		}
    }

    public Object updateElement(Object theKey, Object newElement) {
        int i = search(theKey);
        try {
            table[i].element = newElement;
		} catch (Exception e) {
			System.out.println("Not found.");
		}
        return table[i];
    }

    public Object updateKey(Object theKey, Object theNewKey) {
        int i = search(theKey);
        
    	try {
            this.delete(theKey);
            this.put(theNewKey, table[i].element);
            
		} catch (Exception e) {
			System.out.println("Not found.");
		}
        
        return table[i];
    }


    public static void main(String[] args) {
        Lab_4 hashtable = new Lab_4(1000);
        Lab_1 arrayLinearList = new Lab_1();
        boolean exit = false;
        
        Scanner scanner = new Scanner(System.in);
        try {
            File myObj = new File("C:/Eclipse Projects/java_labs/src/laboratories_testing_value/Lab_4.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                arrayLinearList.add(0, myReader.next());
            }
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 0; i < arrayLinearList.length(); i+=2) {
            Object hashKey = arrayLinearList.get(i + 1);
            Object hashElement = arrayLinearList.get(i);
            try {
                hashtable.put(hashKey, hashElement);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        while(!exit) {
	        System.out.println("==================================================================");
	
	        System.out.println("1-5 ???? ?????????????? ???????????? ?????????????? ???? ?");
	        System.out.println("1. ??????????");
	        System.out.println("2. ??????????");
	        System.out.println("3. ????????");
	        System.out.println("4. ?????????????? [element]");
	        System.out.println("5. ?????????????? [key]");
	
	        System.out.println("==================================================================");
	
	        System.out.println("???????????????????? ???????????? ???????????????????? ??????: " + hashtable.size());
	//        hashtable.output();
	        try {
	            int selectMethod = scanner.nextInt();
	            switch (selectMethod) {
	                case 1:
	                    {
	                        System.out.println("1. ??????????");
	                    	try {
		                        Object newKey = scanner.next();
		                        Object newElement = scanner.next();
		                        hashtable.delete(newKey);
		                        hashtable.put(newKey, newElement);
		                        hashtable.output();
	                    	} catch(Exception e) {
	                    		System.out.println("Found error");
	                    	}
	                        break;
	                    }
	                case 2:
	                    {
	                        System.out.println("2. ??????????");
	                        Object deleteKey = scanner.nextLine();
	                        hashtable.delete(deleteKey);
	                        hashtable.output();
	                        break;
	                    }
	                case 3:
	                    {
	                        System.out.println("3. ????????");
	                        Object searchKey = scanner.nextLine();
	                        System.out.println(hashtable.search(searchKey));
	                        break;
	                    }
	                case 4:
	                    {
	                        System.out.println("4. Element ??????????????");
	                        int newKey = scanner.nextInt();
	                        int newElement = scanner.nextInt();
	                        hashtable.updateElement(new Integer(newKey), new Integer(newElement));
	                        hashtable.output();
	                        break;
	                    }
	                case 5:
	                    {
	                        System.out.println("5. Key ??????????????");
	                        int newKey = scanner.nextInt();
	                        int newElement = scanner.nextInt();
	                        hashtable.updateKey(new Integer(newKey), new Integer(newElement));
	                        hashtable.output();
	                        break;
	                    }
	                default:
	                    {
	                        System.out.println("1-5 ???? ?????????????? ?????????????? ???? !");
	                    }
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	            scanner.close();
	        	break;
	        }
        }
        scanner.close();
    }
}