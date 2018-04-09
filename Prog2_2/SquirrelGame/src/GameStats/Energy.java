package GameStats;

public enum Energy {
	BadBeast(-150),
	BadPlant(-100),
	GoodBeast(200),
	GoodPlant(-150),
	Wall(-10),
	MasterSquirrel(1000),
	MiniSquirrel(0);
	
	private int energy;
	
	private Energy(int energy) {
		this.energy = energy;
	}
}
