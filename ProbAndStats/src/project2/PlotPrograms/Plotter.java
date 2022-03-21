package project2.PlotPrograms;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Plotter {
	protected OrderedPair[] plot;
	private FileWriter fw;
	private BufferedWriter bw;
	
	public Plotter(String fileId, double xMin, double xMax, double delX) {
		try {
			fw = new FileWriter("Plot" + fileId + ".csv");
		}catch(Exception e) {
			System.out.println("Error Occured" + e.toString());
			}
		int points = (int) ((xMax - xMin)/delX);
		plot = new OrderedPair[points];
		for(int i = 0; i < points; i++) {
			double x = xMin + i*delX;
			plot[i] = new OrderedPair(x,f(x));
			
		}
		bw  = new BufferedWriter(fw);
	}
	
	public Plotter(OrderedPair[] newPlot, String fileId) {
		plot = newPlot;
		try {
			fw = new FileWriter("Plot" + fileId + ".csv");
		}catch(Exception e) {
			System.out.println("Error Occured" + e.toString());
			}
		bw  = new BufferedWriter(fw);
	}
	
	public OrderedPair[] getPlot() {
		return plot;
	}
	
	private double f(double x) {
		return Math.exp(-1*Math.pow((x-2), 2));
	}
	
	public void sendToCSV() throws IOException {
		for(OrderedPair o : plot) {
			bw.write(o.x + "," + o.y);
			bw.newLine();
		}
		bw.close();
	}
	
protected class OrderedPair {
	private double x;
	private double y;
	
		public OrderedPair(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double getY() {
			return y;
		}

		public void setY(double d) {
			y = d;			
		}

		public double getX() {
			return x;
		}
	}
}
