package project1;
import java.util.Random;
import java.util.ArrayList;

/**
 * MonteCarlo is an example of an old game show where there are 
 * three curtains to choose, one of which contains a prize and the 
 * other two have nothing. A person chooses one door (1,2, or 3)
 * and the game show host will uncover one of the two remaining doors
 * that has nothing behind it. The person then has the choice to 
 * change their original guess. This simulation demonstrates the 
 * win probability after making the choice to a) switch or b) not switch
 * the original guess.
 * 
 * @author DominicVerrichia
 *
 */
public class MonteCarloSimulation {
	private int[] listOfIterations;
	private int[] perms;
	
	/**
	 * This constructor assigns values to the two global 
	 * variables as well as populate them with values. The
	 * parameter iterations will dictate how many times this 
	 * game is played to give an overall long term win probability
	 * 
	 * @param iterations the amount of games played
	 */
	public MonteCarloSimulation(int iterations) {
		Random rng = new Random();
		perms = new int[3];
		listOfIterations = new int[iterations];
		perms[0] = 1;//car is behind door 1 and goats behind door 2 and 3
		perms[1] = 2;//car behind door 2 and goats behind 1 and 3
		perms[2] = 3;// car behind door 3 and goats behind 1 and 2
		
		for(int i = 0; i < iterations;i++) {
			listOfIterations[i] = (perms[rng.nextInt(3)]);
		}
	}
	
	/**
	 * runs the simulation across the given set of games 
	 * constructed in listOfIterations, and determines the 
	 * win condition based on switching the original answer.
	 * 
	 * Notice that the only way to lose is to select the car on
	 * the first try, otherwise the game is won. This method reflects
	 * that concept.
	 * 
	 * @param guess is the original guess
	 */
	public void runSwitch(int guess) {
		int timesWon = 0;
		for(int i : listOfIterations) {
			if(i == guess) {
				//switch would lose
			}else {
				timesWon++;
			}
		}
		double winRate = (double) timesWon/listOfIterations.length * 100;
		System.out.println("Guess door " + guess + " then switching strategy: Win rate: " + timesWon + "/" + listOfIterations.length + " Success Percentage: " + winRate + " %");
	}
	
	/** 
	 * runs the simulation across the given set of games 
	 * constructed in listOfIterations, and determines the 
	 * win condition based on the original answer. There is no
	 * switch, so this is a straightforward guess the right curtain
	 * and win the game scenario.
	 * 
	 * @param guess is the original guess
	 */
	public void runNoSwitch(int guess) {
		int timesWon = 0;
		for(int i : listOfIterations) {
			if(i == guess) {
				timesWon++;
		}
		}
		double winRate = (double) timesWon/listOfIterations.length * 100;
		System.out.println("Guess door " + guess + " NO switch strategy: Win rate: " + timesWon + "/" + listOfIterations.length + " Success Percentage: " + winRate + " %");
	}
	
	/**
	 * simply runs the simulation for each possible choice that
	 * the player has, that is any of the 3 doors and switch or no
	 * switch for a total of six possibilities.
	 */
	public void runSimulation() {
		runSwitch(1);
		runSwitch(2);
		runSwitch(3);
		runNoSwitch(1);
		runNoSwitch(2);
		runNoSwitch(3);
	}
	
}
