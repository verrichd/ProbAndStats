package notes;

import java.util.Random;

public class Birthday {

	private Person[] people;
	private int size;
	private Random rng;

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

	public Birthday(int numOfPeople) {
		size = numOfPeople;
		people = new Person[size];
		rng = new Random();
		for (Person p : people) {
			p = new Person(rng.nextInt(365));
		}
	}

	public boolean checkBirthdays() {
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (people[i].getBirthday() == people[j].getBirthday()) {
					return true;
				}
			}
		}
		return false;
	}

	public void assignNewBirthdays() {
		for (Person p : people) {
			p.setBirthday(rng.nextInt(365));
		}
	}

	public double runSimulation(int iterations) {
		int trueCount = 0;
		if (checkBirthdays()) {
			trueCount++;
		}
		for (int i = 0; i < iterations; i++) {
			assignNewBirthdays();
			if (checkBirthdays()) {
				trueCount++;
			}
		}

		return trueCount / iterations;
	}
}
