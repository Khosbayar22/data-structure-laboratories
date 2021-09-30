
/*
Project title: Laboratory 1
Fundemental programming class: ArrayLinearList
Description: Expanded by max, min, avarage, sum, remove odd, sorting list 
Date: Sep 6 2021
Name: Ariunbat Khosbayar
Student Id: B200910056
Student class: Software engineer(2)
*/ 

package laboratories;
import java.util.Scanner;

import dataStructures.*; 

public class Lab_1 extends ArrayLinearList {

		 public int max()
		 {
			 int max = Integer.MIN_VALUE; 
			   for (int i=0; i < size; i++){
				   if (Integer.parseInt(element[i].toString()) > max)
				   {
					   max = Integer.parseInt(element[i].toString());
				   }
			   	}
			   return max;
		 }
	 
		 public int min() 
		 {
			 int min = Integer.MAX_VALUE; 
			   	for (int i=0; i<size; i++)
			   	{
			   		if (Integer.parseInt(element[i].toString()) < min)
			   		{
			   			min = Integer.parseInt(element[i].toString());
			   		}
			   }
			   return min;
		 }
	 
	 
		 public int sum() 
		 {
			 int sum = 0;
			 	for (int i = 0; i < size; i++)
			 	{
			 		sum += Integer.parseInt(element[i].toString());
				}
				return sum;
		 }
	 
		 public String avg()
		 {
			 float avgNum = (float) sum() / (float) size; 
			 return String.format("%.2f", avgNum);
		 }
	 
		 public void removeOdd()
		 {
			 for (int i=0; i<size; i++)
			 {
				 if (Integer.parseInt(element[i].toString()) % 2 != 0)
				 {
					 remove(i);
					 i--;
				 }
			 }
		 }

	   public void sort() 
	   {
		   int t = 0;
		   for (int x = 1; x < size(); x++)
		   {
			   for (int i = 0; i < size() - x; i++)
			   {
				   if (Integer.parseInt(element[i].toString()) > Integer.parseInt(element[i + 1].toString())) 
				   {
					   t = Integer.parseInt(element[i+1].toString());
					   element[i+1] = element[i];
					   element[i] = t;
				   }
			   }
		   }
	   }
	   public int readNumber(Scanner reader) {
		    while (true) {
		        try {
		            int num = Integer.parseInt(reader.nextLine());
		            return num;
		        } catch (Exception e) {
					System.out.println("Та бүхэл тоо оруулна уу.");
		        }
		    }
	   }
	   
	   public void clearConsole() {
		   for (int i = 0; i<10; i++){
		       System.out.print('\n');
		    }
//		   try {
//		        final String os = System.getProperty("os.name");
//		        if (os.contains("Windows")) {
//		            Runtime.getRuntime().exec("cls");
//		        } else {
//		            Runtime.getRuntime().exec("clear");
//		        }
//		    } catch (final Exception e) {
//		        e.printStackTrace();
//		    }
		}
	   
	   public static void main(String [] args)
	 {
		 Boolean flag = false;
		 Boolean bye = false;
		 Boolean isShow = true;
		 
		 Lab_1 arrayLinearList = new Lab_1();
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("\n-----------------------------");
		 System.out.println(" Нэмж тодорхойлсон үйлдэлүүд");
		 System.out.println("-----------------------------");
		 

		 System.out.println("-Эрэмблэх");
		 System.out.println("-Хамгийн ихийг олох");
		 System.out.println("-Хамгийн багыг олох");
		 System.out.println("-Нийлбэрийг олох");
		 System.out.println("-Дундажыг олох");
		 System.out.println("-Сондгой тоог устгах");
		 System.out.println("0.Гарах");
		 System.out.println("-----------------------------\n");
		 
		 System.out.println("Хэдэн тоо оруулах вэ ?");
		 int srcNum = arrayLinearList.readNumber(scanner);
		 if (srcNum != 0) { 
			 System.out.println("ArrayLinearList -нд оруулах "+ srcNum + " тоогоо оруулна уу.");
		 }
		 
		 for (int i = 0; i < srcNum; i++)
			 {
				arrayLinearList.add(0, new Integer(arrayLinearList.readNumber(scanner)));

			 }
		 // test size 
		 if (arrayLinearList.isEmpty()) {
			System.out.println("Баяртай :)");
		 }
		 else {
			 System.out.println(arrayLinearList);
			 System.out.println("ArrayLinearList -ийн хэмжээ: " + arrayLinearList.size());
			 flag = true;
		 }
		 
		 if(flag) {

//			 arrayLinearList.clearConsole();
			 while(true) {
				 try {
					
					 if (isShow) {
						 
						 System.out.println("\n-----------------------------");
						 System.out.println(" Та сонголтоо хийнэ үү.");
						 System.out.println("-----------------------------");
						 
			
						 System.out.println("1. Эрэмблэх");
						 System.out.println("2. Хамгийн ихийг олох");
						 System.out.println("3. Хамгийн багыг олох");
						 System.out.println("4. Нийлбэрийг олох");
						 System.out.println("5. Дундажыг олох");
						 System.out.println("6. Сондгой тоог устгах");
						 System.out.println("7. Бүгд");
						 System.out.println("0. Гарах");
						 System.out.println("-----------------------------");

					 } else {
						 System.out.println(arrayLinearList);
						 System.out.println("0. Гарах");
						 System.out.println("8. Буцах");
					 }
					 int selectedMethodNum = scanner.nextInt();
					 
					 switch (selectedMethodNum) {
					 	case 0: {
					 		System.out.println("Баяртай :)");
					 		bye = true;
					 		break;
					 	}
						case 1: {
						     System.out.println("Эрэмблэх: " + arrayLinearList);
						     arrayLinearList.sort();
						     isShow = false;
						     break;
						}
						case 2: {
							System.out.println("Хамгийн ихийг олох: " + arrayLinearList.max());
							isShow = false;
							break;
						}
						case 3: {
							System.out.println("Хамгийн багыг олох: " + arrayLinearList.min());
							isShow = false;
							break;
						}
						case 4: {
							System.out.println("Нийлбэрийг олох: " + arrayLinearList.sum());
							isShow = false;
							break;
						}
						case 5: {
							System.out.println("Дунджыг олох: " + arrayLinearList.avg());
							isShow = false;
							break;
						}
						case 6: {
						     System.out.println("Сондгой index -тэйнүүдийг устгах: " + arrayLinearList);
						     arrayLinearList.removeOdd();
						     isShow = false;
						     break;
						}
						case 7: {
						     System.out.println("Эрэмблэх: " + arrayLinearList);
						     arrayLinearList.sort();
						     System.out.println("Хамгийн ихийг олох: " + arrayLinearList.max());
						     System.out.println("Хамгийн багыг олох: " + arrayLinearList.min());
						     System.out.println("Нийлбэрийг олох: " + arrayLinearList.sum());
						     System.out.println("Дунджыг олох: " + arrayLinearList.avg());
						     System.out.println("Сондгой тоонуудыг устгах: " + arrayLinearList);
						     arrayLinearList.removeOdd();
						     bye = true;
							System.out.println("-----------------------------");
							System.out.println("\nПрограмаас гарлаа.");
						     break;
						     
						}
						case 8: {
						     isShow = true;
						     break;
						}
						default: {
							if (selectedMethodNum < 0 && selectedMethodNum > 7) {
								System.out.println("1-7 -ийн хооронд сонголт хийнэ үү.");
							}
							else {
								System.out.println("-----------------------------");
								System.out.println("\nПрограмаас гарлаа.");
							}
						}
					 }
					 if (bye) {
				 		break; 
					 }
					 
				 } 
				 catch (Exception e) 
				 {
					System.out.println("1-7 -ийн хооронд сонголт хийнэ үү.");
					System.out.println("-----------------------------");
					System.out.println("\nПрограмаас гарлаа.");
				}
			}
		 }
		 scanner.close();
	 }

}