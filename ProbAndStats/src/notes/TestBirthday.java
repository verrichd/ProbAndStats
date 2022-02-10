package notes;

public class TestBirthday {
	public static void main(String[] args) {
		Birthday bd = new Birthday(20);
		System.out.println(bd.runSimulation(100));
		System.out.println(bd.runSimulation(1000));
		System.out.println(bd.runSimulation(10000));
	}
}
