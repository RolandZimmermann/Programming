package Entity;

public class MiniSquirrel extends MasterSquirrel{

	private MasterSquirrel masterSquirrel;
	
	public MiniSquirrel(MasterSquirrel masterSquirrel, int ID, int x, int y) {
		super(ID, x, y);
		this.masterSquirrel = masterSquirrel;
		// TODO Auto-generated constructor stub
	}

	public MasterSquirrel getMasterSquirrel() {
		return masterSquirrel;
	}
	
	public String toString() {
		return "MiniSquirrel: " +super.toString();
	}
}
