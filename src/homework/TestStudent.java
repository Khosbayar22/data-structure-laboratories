package homework;

import java.util.Scanner;

import dataStructures.Chain;
public class TestStudent {

	public static void clearConsole() {
//		try {	
//			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
//		} catch(Exception E)
//			{
//				System.out.println(E);
//			}
//		ClearOutputAction 
		
	}

	public static void main(String[] args) {
		Chain examDatabase = new readFile("Exams.txt").toChain();
		Chain subjectDatabase = new readFile("Subjects.txt").toChain();
		Chain professionDatabase = new readFile("Professions.txt").toChain();
		
		Student student = new Student(examDatabase);
		Subject subject = new Subject(subjectDatabase);
		Major major = new Major(professionDatabase);
//		readFile hello = new readFile("Exams.txt");
//		hello.addItem();
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
							System.out.println("-----------------------------");
							System.out.println("Үйлдэл");
							System.out.println("-----------------------------");
							System.out.println("a. Бүх хичээлийн дундаж дүн");
							System.out.println("b. Oюутаны дүн нэмэх");
							System.out.println("\n-----------------------------");
							String selectedMethodKey = scanner.next();
							switch (selectedMethodKey) {
							case "a":
							case "A": {
								System.out.println(student.avarageAllPointChain());
							}
							case "b": 
							case "B": {
								String content = ""; 
								String[] questions = new String[] {"Хичээлийн код", "Оюутаны код", "Оюутаны оноо"}; 
								for(int i = 0; i < 3; i++) {
									System.out.println(questions[i]);
									String dbItem = scanner.nextLine();
									content += dbItem + ","; 
								}
								readFile rdFile = new readFile("Exams.txt");
								rdFile.addItem(content);
								Student resetStudentChain = new Student(rdFile.toChain());
								System.out.println("\n-----------------------------\n");
								System.out.println(resetStudentChain.allExamData());
							}
							default:
								
							}
							
						     isShow = false;
						     break;
						}
						case 2: {
							System.out.println("2. Нийт хичээлийн жагсаалт.");
							System.out.println(subject.allSubjectData());
							System.out.println("-----------------------------");
							System.out.println("Үйлдэл");
							System.out.println("-----------------------------");
							System.out.println("a. Хичээл нэмэх");
							System.out.println("\n-----------------------------");
							String selectedMethodKey = scanner.next();
							switch (selectedMethodKey) {
							case "а": 
							case "А": {
								String content = ""; 
								String[] questions = new String[] {"Хичээлийн код", "Хичээлийн нэр", "Хичээлийн нэр"}; 
								for(int i = 0; i < 3; i++) {
									System.out.println(questions[i]);
									String dbItem = scanner.nextLine();
									content += dbItem + ","; 
								}
								readFile rdFile = new readFile("Subjects.txt");
								rdFile.addItem(content);
								Subject resetProfessionsChain = new Subject(rdFile.toChain());
								System.out.println("\n-----------------------------\n");
								System.out.println(resetProfessionsChain.allSubjectData());
							}
							default:
								
							}
							isShow = false;
							break;
						}
						case 3: {
							System.out.println("3. Нийт мэргэжлийн жагсаалт.");
							System.out.println(major.allMajorData());
							System.out.println("-----------------------------");
							System.out.println("Үйлдэл");
							System.out.println("-----------------------------");
							System.out.println("a. Хичээл нэмэх");
							System.out.println("\n-----------------------------");
							String selectedMethodKey = scanner.next();
							switch (selectedMethodKey) {
							case "а": 
							case "А": {
								String content = ""; 
								String[] questions = new String[] {"Мэргэжлийн код", "Мэргэжлийн нэр"}; 
								for(int i = 0; i < 2; i++) {
									System.out.println(questions[i]);
									String dbItem = scanner.nextLine();
									content += dbItem + ","; 
								}
								readFile rdFile = new readFile("Professions.txt");
								rdFile.addItem(content);
								Major resetProfessionsChain = new Major(rdFile.toChain());
								System.out.println("\n-----------------------------\n");
								System.out.println(resetProfessionsChain.allMajorData());
							}
							default:
								
							}
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
