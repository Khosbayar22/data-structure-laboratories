package homework;

import java.util.Scanner;

import dataStructures.Chain;

public class TestStudent {
	public static void main(String[] args) {
		Chain examDatabase = new readFile("Exams.txt").toChain();
		Chain subjectDatabase = new readFile("Subjects.txt").toChain();
		Chain professionDatabase = new readFile("Professions.txt").toChain();
		
		Student student = new Student(examDatabase);
		Subject subject = new Subject(subjectDatabase);
		Major major = new Major(professionDatabase);
//		Boolean flag = false;
		Boolean bye = false;
		Boolean isShow = true;
		
		
		Scanner scanner = new Scanner(System.in);
//		System.out.println("\n-----------------------------");
//		System.out.println("Сургуулийн систем");
//		System.out.println("-----------------------------");
//		 
//
//		System.out.println("1. Нийт оюутаны дүнгийн жагсаалт.");
//		System.out.println("2. Нийт хичээлийн жагсаалт.");
//		System.out.println("3. Нийт мэргэжлийн жагсаалт.");
//		System.out.println("0. Гарах");
//		System.out.println("-----------------------------\n");
		
		
		 if(true) {
			 while(true) {
				 try {
					 if (isShow) {
						System.out.println("\n-----------------------------");
						System.out.println("1. Нийт оюутаны дүнгийн жагсаалт.");
						System.out.println("2. Нийт хичээлийн жагсаалт.");
						System.out.println("3. Нийт мэргэжлийн жагсаалт.");
						System.out.println("0. Гарах");
						System.out.println("-----------------------------");

					 } else {						 
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
							System.out.println("1. Нийт оюутаны дүнгийн жагсаалт.");
							System.out.println(student.allExamData());
							System.out.println("Дундаж тоо дүн авах");
							System.out.println("Oюутаны дүн нэмэх");
						     isShow = false;
						     break;
						}
						case 2: {
							System.out.println("2. Нийт хичээлийн жагсаалт.");
							System.out.println(subject.allSubjectData());
							isShow = false;
							break;
						}
						case 3: {
							System.out.println("3. Нийт мэргэжлийн жагсаалт.");
							System.out.println(major.allMajorData());
							isShow = false;
							break;
						}
						case 8: {
						     isShow = true;
						     break;
						}
						default: {
							if (selectedMethodNum < 0 && selectedMethodNum > 3) {
								System.out.println("1-4 -ийн хооронд сонголт хийнэ үү.");
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
