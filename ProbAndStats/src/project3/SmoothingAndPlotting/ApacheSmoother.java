package project3.SmoothingAndPlotting;

import org.apache.commons.math3.analysis.interpolation.LoessInterpolator;

public class ApacheSmoother extends ApachePlotter{

	private LoessInterpolator smoother;
	
	public ApacheSmoother(OrderedPair[] newPlot) {
		super(newPlot);
		smoother = new LoessInterpolator();
	}

	public void smooth() {
		double[] xVal = new double[plot.length];
		double[] yVal = new double[plot.length];
		for(int i = 0; i < plot.length; i++) {
			xVal[i] = plot[i].getX();
			yVal[i] = plot[i].getY();
		}
		double[] resultantSet = smoother.smooth(xVal, yVal);
		for(int i = 0; i < plot.length; i++) {
			plot[i].setY(resultantSet[i]);
		}
	}
}
