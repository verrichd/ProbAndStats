package project3.SmoothingAndPlotting;

import java.util.Random;

/**
 * ApacheSalter is an ApachePlotter that will accept an OrderedPair array
 * typically taken from an ApachePlotter using the getter method.
 * Salter has one method that 'salts' the data in the plot by
 * slightly mutating the y value in each OrderedPair in the plot
 * by a random double value between 0 and 1/5.
 * 
 * @author DominicVerrichia
 *
 */
public class ApacheSalter extends ApachePlotter{
	private Random rng;
	
	/**
	 * Calls the alternate constructor from the superclass Plotter 
	 * that accepts an OrderedPair array and string for the file name
	 * @param plot
	 * @param s
	 */
	public ApacheSalter(OrderedPair[] plot) {
		super(plot);
		this.plot = plot;
		rng = new Random();
	}
	/**
	 * Will randomly add or subtract a random number between 0 and 1/5
	 * using the nextDouble and nextInt methods from the Random object
	 * from the Java API.
	 * @return the plot in its altered form
	 */
	public OrderedPair[] salt() {
		for(OrderedPair o : plot) {
			if(rng.nextInt(2) == 0) {
				o.setY(o.getY() + rng.nextDouble()/5);
			}
			if(rng.nextInt(2) == 1) {
				o.setY(o.getY() - rng.nextDouble()/5);
			}
		}
		return plot;
	}
}

