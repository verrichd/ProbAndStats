package project3.SmoothingAndPlotting;

import java.io.FileWriter;
import java.io.IOException;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.BufferedWriter;

/**
 * ApachePlotter will create a CSV file of OrderedPair objects based on the 
 * included method 'f' that models the common probability function that models
 * a bell curve f(x) = e^-(x-2)^2. A new Plotter will require parameters for 
 * the domain bounds and incremental value 'delX'. There is also a String parameter 
 * to name the resultant CSV file containing the ordered pairs.
 * 
 * @author DominicVerrichia
 * 
 */
public class ApachePlotter {
	protected OrderedPair[] plot;
	private FileWriter fw;
	private BufferedWriter bw;
	
	public ApachePlotter(String fileId, double xMin, double xMax, double delX) {
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
	
	/**
	 * Used in the subclasses Salter and Smoother. Accepts an
	 * OrderedPair array typically referenced from a previously
	 * created Plotter or Salter object.
	 * @param newPlot 
	 */
	public ApachePlotter(OrderedPair[] newPlot) {
		plot = newPlot;
	}
	
	/**
	 * Getter method for the plot used in testing.
	 * 
	 * @return plot
	 */
	public OrderedPair[] getPlot() {
		return plot; 
	}
	
	/**
	 * Example function to represent a typical bell curve in the first quadrant
	 * of the Cartesian coordinate plane. 
	 * @param x
	 * @return f(x) or y in an OrderedPair
	 */
	private double f(double x) {
		return Math.exp(-1*Math.pow((x-2), 2));
	}
	
	/**
	 * Will traverse through the plot and write each ordered pair 
	 * as two comma separated values on its own line. This will 
	 * be recognized by Excel as two columns filled with x and y values.
	 * @throws IOException 
	 */
	public void sendToCSV() throws IOException {
		for(OrderedPair o : plot) {
			bw.write(o.x + "," + o.y);
			bw.newLine();
		}
		bw.close();
	}
	
	/**
	 * Creates an XYDataset from the JFreeCharts library in order to be 
	 * displayed quickly using the XYScatterPlot. This takes current version
	 * of plot global field and adds every OrderedPair inside plot to the 
	 * XYSeries. When finished, the XYSeries is added to an XYSeriesCollection 
	 * which is a subclass of the XYDataSet that is needed for the XYScatterPlot.
	 * @param seriesName is the name for the series (i.e. 'salted', 'smoothed')
	 * @return an XYDataSet containing all data points inside 'plot'
	 */
	public XYDataset createXYDataset(String seriesName) {
		XYSeries seriesFromPlot = new XYSeries(seriesName);
		for(OrderedPair op : plot) {
			seriesFromPlot.add(op.getX(),op.getY());
		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(seriesFromPlot);
		return dataset;		
	}
	
	/**
	 * Data Container for a typical two dimensional ordered pair to 
	 * assist Plotter in writing an array of OrderedPair objects to 
	 * a CSV file.
	 * 
	 * @author DominicVerrichia
	 *
	 */
protected class OrderedPair {
	private double x;
	private double y;
	
	/**
	 * Creates an ordered pair from given x and y values.
	 * @param x
	 * @param y
	 */
		public OrderedPair(double x, double y) {
			this.x = x;
			this.y = y;
		}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
		
	}
}
