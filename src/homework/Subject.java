package homework;

import dataStructures.Chain;

public class Subject {
	public String code;
	public String name; 
	public float credit; 
	public Chain subjectDatabase;
	
	
	public Subject(Chain subjectDatabaseP) {
		subjectDatabase = subjectDatabaseP;
	}
	
	public String allSubjectData() {
		Chain subjectChain = subjectDatabase;
		int cnt = 0;  
		String content = ""; 
		content += String.format("No | Хичээлийн дугаар | Хичээлийн нэр | Кредит\n"); 
		for(int i = 0; i < subjectChain.size(); i += 3) {
			cnt += 1; 
			content += String.format("%d  | %s | %s | %s\n", cnt, subjectChain.get(i + 1), subjectChain.get(i), subjectChain.get(i + 2));
		}
		return content; 
	}
	
}
// code/name/credit 