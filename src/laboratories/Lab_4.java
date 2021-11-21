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
        Lab_4 hashtable = new Lab_4(11);
        Lab_1 arrayLinearList = new Lab_1();
        
        Scanner scanner = new Scanner(System.in);
        try {
            File myObj = new File("C:/Eclipse Projects/java_labs/src/laboratories_testing_value/Lab_4.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                arrayLinearList.add(0, new Integer(myReader.nextInt()));
            }
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < arrayLinearList.length(); i+=2) {
            int hashKey = (int) arrayLinearList.get(i);
            int hashElement = (int) arrayLinearList.get(i + 1);
            try {
                hashtable.put(new Integer(hashKey), new Integer(hashElement));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("==================================================================");

        System.out.println("1-5 ын хооронд тоогоо оруулна уу ?");
        System.out.println("1. Нэмэх");
        System.out.println("2. Хасах");
        System.out.println("3. Хайх");
        System.out.println("4. Өөрчлөх [element]");
        System.out.println("5. Өөрчлөх [key]");

        System.out.println("==================================================================");

        try {
            int selectMethod = scanner.nextInt();
            switch (selectMethod) {
                case 1:
                    {
                        System.out.println("1. Нэмэх");
                        int newKey = scanner.nextInt();
                        int newElement = scanner.nextInt();
                        hashtable.delete(new Integer(newKey));
                        hashtable.put(new Integer(newKey), new Integer(newElement));
                        hashtable.output();
                        break;
                    }
                case 2:
                    {
                        System.out.println("2. Хасах");
                        int deleteKey = scanner.nextInt();
                        hashtable.delete(new Integer(deleteKey));
                        hashtable.output();
                        break;
                    }
                case 3:
                    {
                        System.out.println("3. Хайх");
                        int searchKey = scanner.nextInt();
                        System.out.println(hashtable.search(new Integer(searchKey)));
                        break;
                    }
                case 4:
                    {
                        System.out.println("4. Element өөрчлөх");
                        int newKey = scanner.nextInt();
                        int newElement = scanner.nextInt();
                        hashtable.updateElement(new Integer(newKey), new Integer(newElement));
                        hashtable.output();
                        break;
                    }
                case 5:
                    {
                        System.out.println("5. Key өөрчлөх");
                        int newKey = scanner.nextInt();
                        int newElement = scanner.nextInt();
                        hashtable.updateKey(new Integer(newKey), new Integer(newElement));
                        hashtable.output();
                        break;
                    }
                default:
                    {
                        System.out.println("1-5 ын хооронд оруулна уу !");
                    }
            }
        } catch (Exception e) {
            System.out.println(e);
            scanner.close();
        }

        scanner.close();
    }
}