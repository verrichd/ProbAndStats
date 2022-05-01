package project3.SmoothingAndPlotting;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class ScatterPlotter extends JFrame{
	private static final long serialVersionUID = 1L;

	public ScatterPlotter(String title, ApachePlotter plot){
		JFreeChart standardPlot = ChartFactory.createScatterPlot(title, "X", "Y", plot.createXYDataset(title));
		ChartPanel cp = new ChartPanel(standardPlot);
		setContentPane(cp);
		setSize(600,400);
		setVisible(true);
	}
}
