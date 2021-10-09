package homework;

import dataStructures.Chain;

public class Major {
	public String code; 
	public String name; 
	public Chain professionDatabase;
	
	public Major(Chain professionDatabaseP) {
		professionDatabase = professionDatabaseP;
	}
	
	public String allMajorData() {
		Chain professionChain = professionDatabase;
		int cnt = 0;  
		String content = ""; 
		content += String.format("No | Мэргэжлийн код | Мэргэжлийн нэр\n"); 
		for(int i = 0; i < professionChain.size(); i += 2) {
			cnt += 1; 
			content += String.format("%d  | %s | %s \n", 
					cnt, professionChain.get(i), professionChain.get(i + 1));
		}
		return content; 
	}
	
}
// code/name - > SW/Program hangamj