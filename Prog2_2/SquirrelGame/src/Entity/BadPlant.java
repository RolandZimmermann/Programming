package Entity;

import GameStats.Energy;

public class BadPlant extends Entity {

	public BadPlant(int ID, int x, int y) {
		super(ID, Energy.BadPlant.ordinal(), x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void nextStep() {
		
	}
	
	public String toString() {
		return "BadPlant " +super.toString();
	}

}
