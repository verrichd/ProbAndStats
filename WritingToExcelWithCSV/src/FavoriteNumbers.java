import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FavoriteNumbers {
	private FileWriter fw;
	private BufferedWriter bw;
	private int[] id;
	private int size;
	
	public FavoriteNumbers(int inputSize) {
		
		size = inputSize;
		try {
			fw = new FileWriter("FavoriteNumbers2.csv");
		}catch(Exception e) {
			System.out.println("Error Occured" + e.toString());

			}
		id = new int[size];
		for(int i = 0; i < inputSize; i++) {
			id[i] = i + 1;
		}
		bw  = new BufferedWriter(fw);
	}
	
	public void outputSingleLine(int id, int currentNum) {
		try {
			bw.write(id + "," + currentNum);
			bw.newLine();
		} catch (Exception e) {
			System.out.println("Writer error (or close error)" + e.toString());
		}
	}
	
	public void assignNumbers() throws IOException {
		
		for(int i = 0; i < size; i++) {
			Random rng = new Random();
			outputSingleLine(id[i], rng.nextInt(1000) + 1);
		
		}
		bw.close();
	}
	
}
