import java.util.Random;


public class Dice {
	private Random generator = new Random();
	private int value;

	public int roll() {
		return value = generator.nextInt(6)+1;
	}

	public int getValue() {
		return value;
	}

	
}

