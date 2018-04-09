package GameStats;

public enum ID {
	BadBeast(0),
	BadPlant(1),
	GoodBeast(2),
	GoodPlant(3),
	Wall(4),
	MasterSquirrel(5),
	MiniSquirrel(6);
	
	private int ID;
	
	private ID(int ID) {
		this.ID = ID;
	}
}
