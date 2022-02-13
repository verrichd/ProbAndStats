package project1;

/**
 * TestBirthday is currently set up to display the chances of a shared
 * birthday occurring in classrooms of sizes ranging from 5 to 60. This
 * gives a nice display of how the probability of sharing a birthday increases
 * with the number of people in the room. 
 * 
 * The simulation is run 10,000 times for each class size to produce the results
 * but it is worth noting that 1,000,000 or higher iterations will be where the
 * simulation begins to slow down.
 * 
 * @author DominicVerrichia
 *
 */

public class TestBirthday {
	public static void main(String[] args) {
				
		for(int i = 5; i <= 60; i = i +5){
		Birthday bd = new Birthday(i);
		System.out.println(bd.runSimulation(10000));
		}
	}
}
