
public class Raflebæger {

	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();

	public void roll(){
		dice1.roll();
		dice2.roll();
	}

	public int getvalue1(){
		return dice1.getValue();
	}
	public int getvalue2(){
		return dice2.getValue();
	}
	public int getSum(){
		return dice1.getValue() + dice2.getValue();
	}
	
}
