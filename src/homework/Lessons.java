package homework;

import dataStructures.Chain;

public class Lessons extends Student{
	
	public Lessons(String learnedP, int scoreP) {
		super(learnedP, scoreP);
	}

	public int getScore() {
		return score; 
	}
	
	public String getLearned() {
		return learned;
	}
	
	
	public String toString() {
		return String.format("%s - %d", learned, score);
	}
}
