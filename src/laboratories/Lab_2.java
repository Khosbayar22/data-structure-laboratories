
/*
Name: Ariunbat Khosbayar
Student Id: B200910056
Student class: Software engineer(2)
Project title: Laboratory 2
Fundemental programming class: Chain
Description: Extended methods toArray, Union, addRange, Intersection
Date: Oct 2 2021
*/ 
package laboratories;

import java.util.*; 

import dataStructures.*;

public class Lab_2 extends Chain{
	
	public Object[] toArray(Chain chain)  {
		Object[] javaObjectArray = new Object[size]; 
		for(int i = 0; i < size; i++) {
			javaObjectArray[i] = chain.get(i);
		}
		return javaObjectArray; 
	}
	
	public Chain removeDuplicateElements(Chain chain) {
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		Chain removeElement = new Chain(); 
		try {
			for (int i = 0; i < chain.size(); i++) {
	            set.add(Integer.parseInt(chain.get(i).toString()));
			}
	        Iterator value = set.iterator();
	        int count = 0; 
			while(value.hasNext()) {
				removeElement.add(count, value.next());
				count++; 
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return removeElement;  
		
	}
	
	
	public void addRange(Chain chain) {
		Scanner scanner = new Scanner(System.in);
		int totalNum = scanner.nextInt();
		chain.add(chain.size(), totalNum);
		System.out.println(chain.toString());
	}
	
	public Chain union(Chain chain) {
		Chain unionChain = new Chain(); 
		Random randomNum = new Random(); 
		for(int i = 0; i < chain.size(); i++) {
			unionChain.add(i, chain.get(i));
		}
		Chain anotherChain = new Chain();
		int totalNum = 10; 
 		for(int i = 0; i < totalNum; i++) {
			int num = randomNum.nextInt(10); 
			anotherChain.add(i, num);
			Boolean flag = true; 
			for(int j = 0; j < unionChain.size(); j++) {
				if(Integer.parseInt(unionChain.get(j).toString()) == Integer.parseInt(anotherChain.get(i).toString())) {
					flag = false; 
				}
			}
			if(flag) {
				unionChain.add(size, anotherChain.get(i));
			}
		}
 		System.out.println("Үндсэн жагсаалт: " + chain.toString());
 		System.out.println("Өгөгдсөн жагсаалт: " + anotherChain.toString());
 		return unionChain; 
	}
	
	public Chain intersection(Chain chain) {
		Chain unionChain = new Chain(); 
		Random randomNum = new Random(); 
		Chain anotherChain = new Chain();
		int totalNum = 10; 
		int count = 0; 
 		for(int i = 0; i < totalNum; i++) {
			int num = randomNum.nextInt(10); 
			anotherChain.add(i, num);
			Boolean flag = false; 
			for(int j = 0; j < chain.size(); j++) {
				if(Integer.parseInt(chain.get(j).toString()) == Integer.parseInt(anotherChain.get(i).toString())) {
					flag = true; 
					break; 
				}
			}
			if(flag) {
				unionChain.add(count, anotherChain.get(i));
				count++; 
			}
		}
 		
 		System.out.println("Үндсэн жагсаалт: " + chain.toString());
 		System.out.println("Өгөгдсөн жагсаалт: " + anotherChain.toString());
 		return unionChain; 
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
	
	public static void main(String[] args) {
		 Boolean flag = false;
		 Boolean bye = false;
		 Boolean isShow = true;
		 
		 Lab_2 chainList = new Lab_2();
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("\n-----------------------------");
		 System.out.println(" Нэмж тодорхойлсон үйлдэлүүд");
		 System.out.println("-----------------------------");
		 

		 System.out.println("1. toArray-Массивруу хөрвүүлэх.");
		 System.out.println("2. addRange-Шинэ элемент нэмэх.");
		 System.out.println("3. union-Нэгдэл жагсаалтыг харах.");
		 System.out.println("4. intersection-Огтлолцол жагсаалтыг харах.");
		 System.out.println("0. Гарах");
		 System.out.println("-----------------------------\n");
		 
		 System.out.println("Хэдэн тоо оруулах вэ ?");
		 int srcNum = chainList.readNumber(scanner);
		 if (srcNum != 0) { 
			 System.out.println("Chain -нд оруулах "+ srcNum + " тоогоо оруулна уу.");
		 }
		 
		 for (int i = 0; i < srcNum; i++)
			 {
			 chainList.add(0, new Integer(chainList.readNumber(scanner)));
			 }
		 // test size 
		 if (chainList.isEmpty()) {
			System.out.println("Баяртай :)");
		 }
		 else {
			 System.out.println(chainList);
			 System.out.println("Chain -ийн хэмжээ: " + chainList.size());
			 flag = true;
		 }
		 
		 if(flag) {
			 while(true) {
				 try {
					
					 if (isShow) {
						 
						 System.out.println("\n-----------------------------");
						 System.out.println(" Та сонголтоо хийнэ үү.");
						 System.out.println("-----------------------------");
						 
			
						 System.out.println("1. toArray-Массивруу хөрвүүлэх.");
						 System.out.println("2. addRange-Шинэ элемент нэмэх.");
						 System.out.println("3. union-Нэгдэл жагсаалтыг харах.");
						 System.out.println("4. intersection-Огтлолцол жагсаалтыг харах.");
						 System.out.println("7. Бүгд");
						 System.out.println("0. Гарах");
						 System.out.println("-----------------------------");

					 } else {
//						 System.out.println(arrayLinearList);
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
							System.out.println("Массивруу хөрвүүлэх.");
							System.out.println(chainList.toArray(chainList));
						     for(int i = 0; i < srcNum; i++) {
						    	 System.out.println(chainList.toArray(chainList)[i]); 
						     }
						     isShow = false;
						     break;
						}
						case 2: {
							System.out.println("Шинэ элемент нэмэх.");
							chainList.addRange(chainList); 
							isShow = false;
							break;
						}
						case 3: {
							System.out.println("Нэгдэл жагсаалтыг харах.");
					 		System.out.println("Нэгдэл жагсаалт: " + 
					 		chainList.removeDuplicateElements(chainList.union(chainList))
					 		);
					 		System.out.println("\n\n");
							isShow = false;
							break;
						}
						case 4: {
							System.out.println("Огтлолцол жагсаалтыг харах.");
					 		System.out.println("Нэгдэл жагсаалт: " +
					 		chainList.removeDuplicateElements(chainList.intersection(chainList))
					 		);
					 		System.out.println("\n\n");
							isShow = false;
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
					 System.out.println(e); 
					System.out.println("1-7 -ийн хооронд сонголт хийнэ үү.");
					System.out.println("-----------------------------");
					System.out.println("\nПрограмаас гарлаа.");
				}
			}
		 }
		 scanner.close();
	}
}
