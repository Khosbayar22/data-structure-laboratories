package homework;

import dataStructures.Chain;

public class Student {
	public String code;
	public float GPA; 
	public Chain lessons;

	public String learned;
	public int score; 
	public Chain examDatabase;
	
	public Student(Chain examDatabaseP) {
		examDatabase = examDatabaseP; 
	}
	
	public Student(String learnedP, int scoreP) {
		learned = learnedP; 	
		score = scoreP; 
	}
	
	public Student(int scoreP) {
		score = scoreP; 
	}
	
	public Chain getAllPointChain() {
		Chain allPoints = new Chain();
		for(int i = 2; i < examDatabase.size(); i += 3) {
			allPoints.add(allPoints.size(), examDatabase.get(i));
		}
		return allPoints;
	}
	
	public int sumAllPointChain() {
		Chain allPoints = getAllPointChain();
		int sum = 0; 
		for(int i = 0; i < allPoints.size(); i++) {
			sum += Integer.parseInt(allPoints.get(i).toString());
		}
		return sum; 
	}
	
	public float avarageAllPointChain() {
		Chain allPoints = getAllPointChain();
		int sum = sumAllPointChain();
		int len = allPoints.size(); 
		return sum/len;
	}
	
	public float pointToGP(float point) {
		return (point * 4) / 100;
	}
	

	public String sortByCourseId(Chain courseDatabase) {
		Chain examChain = examDatabase;
		int cnt = 0;  
		String content = ""; 
		content += String.format("No | Хичээлийн дугаар | Оюутаны код | Авсан оноо\n"); 
		for(int j = 0; j < courseDatabase.size(); j += 3) {
			content += courseDatabase.get(j) + " - " + courseDatabase.get(j + 1) + "\n" ; 
			for(int i = 0; i < examChain.size(); i += 3 ) {
				if (courseDatabase.get(j).equals(examChain.get(i))) {
					cnt += 1; 
					content += String.format("%d  | %s | %s | %s\n", cnt, examChain.get(i + 1), examChain.get(i), examChain.get(i + 2));
				}
			}
		}
		return content;
	}
	

	public String sortByStudentId(Chain professionDatabase) {
		Chain examChain = examDatabase;
		int cnt = 0;  
		String content = ""; 
		content += String.format("No | Хичээлийн дугаар | Оюутаны код | Авсан оноо\n"); 
		for(int j = 0; j < professionDatabase.size(); j += 2) {
			content += professionDatabase.get(j + 1) + "\n" ; 
			for(int i = 0; i < examChain.size(); i += 3 ) {
				int studentMajorId = Integer.parseInt(examChain.get(i + 1).toString().substring(5, 8));
				int totalStudentMajorId = Integer.parseInt(professionDatabase.get(j).toString());
				if (studentMajorId == totalStudentMajorId) {
					cnt += 1; 
					content += String.format("%d  | %s | %s | %s\n", cnt, examChain.get(i + 1), examChain.get(i), examChain.get(i + 2));
				}
			}
		}
		return content;
	}
	
	public String allExamData() {
		Chain examChain = examDatabase;
		int cnt = 0;  
		String content = ""; 
		content += String.format("No | Хичээлийн дугаар | Оюутаны код | Авсан оноо\n"); 
		for(int i = 0; i < examChain.size(); i += 3) {
			cnt += 1; 
			content += String.format("%d  | %s | %s | %s\n", cnt, examChain.get(i + 1), examChain.get(i), examChain.get(i + 2));
		}
		return content; 
	}
}
