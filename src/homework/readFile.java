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
	public void addItem(String dbString) {
		try {
			    FileWriter myWriter = new FileWriter(file + "\\" + fileName, true);
			    myWriter.write(dbString + "\n");
			    myWriter.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
}
