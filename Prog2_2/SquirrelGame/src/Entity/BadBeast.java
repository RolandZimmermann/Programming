package Entity;

import GameStats.Energy;

public class BadBeast extends Entity {

	public BadBeast(int ID, int x, int y) {
		super(ID, Energy.BadBeast.ordinal(), x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void nextStep() {
		super.getPos().randomMove();
	}
	
	public String toString() {
		return "BadBeast " + super.toString();
	}

}
