package Entity;

import GameStats.Energy;

public class GoodPlant extends Entity{

	public GoodPlant(int ID, int x, int y) {
		super(ID, Energy.GoodPlant.ordinal(), x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void nextStep() {
		
	}
	
	public String toString() {
		return "GoodPlant " +super.toString();
	}

}
