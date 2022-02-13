package project1;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CSVwriter {
	FileWriter fw;
	BufferedWriter bw;
	
	public CSVwriter() {
		try {
		fw = new FileWriter("ExampleOutput.txt");
	}catch(Exception e) {
		System.out.println("Error Occured" + e.toString());

		}
	}
	
	public void outputSingleLine(String userInput) {
		bw  = new BufferedWriter(fw);
		
		try {
			bw.write(userInput);
			bw.close();
		} catch (Exception e) {
			System.out.println("Writer error (or close error)" + e.toString());
		}
	}
	
	public static void main(String[] args) {
		CSVwriter cw = new CSVwriter();
		cw.outputSingleLine("Hello World!");
		
	}
	
}
