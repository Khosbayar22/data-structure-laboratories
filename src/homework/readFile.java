package homework;

import java.io.*;

import dataStructures.ArrayLinearList;
import dataStructures.Chain;

public class readFile {
	File file = new File("C:\\Eclipse Projects\\java_labs\\src\\homework\\"); 
	public String fileName; 
	ArrayLinearList fileValues = new ArrayLinearList();
	
	public readFile(String fileN) {
		fileName = fileN; 
	}
	public Chain toChain() {
		Chain chainList = new Chain();
 		try {
			FileReader fileReader = new FileReader(file + "\\" + fileName);
			BufferedReader reader = new BufferedReader(fileReader);
			while(reader.ready()) {
				String line = reader.readLine();
				for(int i = 0; i < line.split(",").length; i++) {
					chainList.add(chainList.size(), line.split(",")[i]);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chainList;
	}
	public void addItem() {
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(file + "\\" + fileName, "rw");	
			randomAccessFile.writeBytes("B200910011,CS204,10");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
