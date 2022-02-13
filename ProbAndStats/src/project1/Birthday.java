package project1;
import java.util.Random;
/**
 * Birthday internally computes the chances of a shared birthday amongst a 
 * given number of individuals or "students". Birthday is constructed accepting
 * one integer for the amount of people in the simulation. The runSimulation method
 * accepts an integer for the amount of iterations done in the calculation. This could
 * have been hard coded into the method, but it serves as a way for the user to adjust
 * the line between calculation speed and accuracy.
 * 
 * @author DominicVerrichia
 *
 */

public class Birthday {
	
	private Person[] people;
	private int size;
	private Random rng;
	
	
	/**
	 * Person is a data container that holds one integer for birthday
	 * with a method to access and mutate for repeated simulations
	 * 
	 * @author Dominic Verrichia
	 *
	 */
	public class Person {
		private int birthday;
		
		public Person(int inputBirthday) {
			birthday = inputBirthday;
		}
		
		public int getBirthday() {
			return birthday;
		}
		
		public void setBirthday(int newBirthday) {
			birthday = newBirthday;
		}
	}
	
	/**
	 * This will construct a new "room" full of "Persons" or classroom
	 * full of students each with their own randomly assigned birthday with the use of 
	 * the Random object in the java API 
	 * Note: using the numbers 0 through 364 to represent a birthday is sufficient
	 * because the simulation is simply checking for any two matching numbers
	 * @param numOfPeople
	 */
	public Birthday(int numOfPeople) {
		size = numOfPeople;
		people = new Person[size];
		rng = new Random();
		for(int i = 0; i < size; i++) {
			people[i] = new Person(rng.nextInt(365));
		}
	}
	
	/**
	 * checkBirthdays will compare each Person in people to tell
	 * whether there are any shared birthdays in the group
	 * 
	 * @return true if there exists a matching birthday
	 * @return false is there are no matching birthdays
	 */
	public boolean checkBirthdays() {
		for(int i = 0; i < size; i++) {
			for(int j = i+1; j < size; j++) {
				if(people[i].getBirthday() == people[j].getBirthday()) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Assigns new birthdays to the same people for efficiency
	 * No Person is harmed in this process
	 */
	public void assignNewBirthdays() {
		for(Person p : people) {
			p.setBirthday(rng.nextInt(365));
		}
	}
	
	/**
	 * Will run the simulation given an integer amount of iterations
	 * that will increase accuracy as iterations increase
	 * 
	 * Algorithm for calculating probability: 
	 * 	1) checkBirthdays() of the current classroom and record result (add 1 to trueCount if true)
	 * 	2) start loop at 1 because iteration 0 happened in step (1) above
	 * 		2.1) assignNewBirthdays() change birthdays for every Person
	 * 		2.2) checkBirthdays() check birthdays for new group and record result same as before
	 * 	3) create double variable chance that stores the trueCount/iterations casted as a double (*100 for percentage)
	 * 
	 * @param iterations should be at least 100
	 * @return String including description of result and the amount of Persons in the room formatted to two decimal places
	 */
	public String runSimulation(int iterations) {
		int trueCount = 0;
		if(checkBirthdays()) {
			trueCount++;
		}
		for(int i = 1; i < iterations; i++) {
			assignNewBirthdays();
			if(checkBirthdays()) {
				trueCount++;
			}
		}
		double chance = (double) trueCount/iterations *100;
		
		return "Chance of Shared birthday for " + size + " students: " + String.format("%.2f", chance) + "% ";
	}
}
