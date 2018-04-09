package Entity;

import GameStats.Energy;

public class GoodBeast extends Entity {

	public GoodBeast(int ID, int x, int y) {
		super(ID, Energy.GoodBeast.ordinal(), x, y);
	}
	
	public void nextStep() {
		super.getPos().randomMove();
	}
	
	public String toString() {
		return "GoodBeast " +super.toString();
	}
}
