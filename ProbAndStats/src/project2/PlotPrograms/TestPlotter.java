package project2.PlotPrograms;

import java.io.IOException;

public class TestPlotter {
	public static void main(String[] args) throws IOException {
		Plotter p1 = new Plotter("1", 0, 4, 0.1);
		p1.sendToCSV();
		
		Salter sa = new Salter(p1.getPlot(),"1Salted");
		sa.salt();
		sa.sendToCSV();
		
		Smoother sm = new Smoother(sa.getPlot(), "1Smoothed");
		sm.smooth();
		sm.sendToCSV();
	}
}
