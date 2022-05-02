package project3.SmoothingAndPlotting;



public class TestApachePlotting  {

	public static void main(String[] args)
	{
		ApachePlotter orig = new ApachePlotter("OriginalPlot",0 , 4, 0.1);
		ScatterPlotter sp1 = new ScatterPlotter("OriginalPlot",orig);
		ApacheSalter salt = new ApacheSalter(orig.getPlot());
		ApacheSmoother smooth = new ApacheSmoother(salt.salt());
		ScatterPlotter sp2 = new ScatterPlotter("SaltedPlot",salt);
		smooth.smooth();
		ScatterPlotter sp3 = new ScatterPlotter("SmoothedPlot",smooth);
	}
}
