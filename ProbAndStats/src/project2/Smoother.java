package project2;

public class Smoother extends Plotter{
	
	public Smoother(OrderedPair[] newPlot, String fileId) {
		super(newPlot, fileId);
	}
	
	public void smooth() {
		OrderedPair[] updatedPlot = plot;
		for(int i = 0; i < plot.length; i ++) {
			if(i == 0) {
				updatedPlot[i].setY(average(plot[i].getY(), plot[i + 1].getY(), plot[i + 2].getY()));
			}else if(i == plot.length - 1){
				updatedPlot[i].setY(average(plot[i].getY(), plot[i - 1].getY(), plot[i - 2].getY()));
			}else {
				updatedPlot[i].setY(average(plot[i].getY(), plot[i + 1].getY(), plot[i - 1].getY()));
			}
		}
		plot = updatedPlot;
	}
	
	public double average(double a, double b, double c) {
		
		return (a + b + c) / 3;
		
	}
	
}
