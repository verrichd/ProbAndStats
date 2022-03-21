package project2.PlotPrograms;

import java.util.Random;

public class Salter extends Plotter{
	private OrderedPair[] plot;
	private Random rng;
	
	public Salter(OrderedPair[] plot, String s) {
		super(plot, s);
		this.plot = plot;
		rng = new Random();
	}

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

