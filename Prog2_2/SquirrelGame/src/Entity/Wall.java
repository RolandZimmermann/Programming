package Entity;

import GameStats.Energy;

public class Wall extends Entity {

	public Wall(int ID, int x, int y) {
		super(ID, Energy.Wall.ordinal(), x, y);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Wall " + super.toString();
	}

}
