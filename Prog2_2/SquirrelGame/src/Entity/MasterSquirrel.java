package Entity;

import GameStats.Energy;
import GameStats.Movement;
import UI.HandOperatedMasterSquirrel;

public class MasterSquirrel extends Entity{
	
	private HandOperatedMasterSquirrel handoperatedMasterSquirrel;

	public MasterSquirrel(int ID, int x, int y) {
		super(ID, Energy.MasterSquirrel.ordinal(), x, y);
		this.handoperatedMasterSquirrel = new HandOperatedMasterSquirrel();
	}
	
	public boolean isMiniSquirrel(Entity entity) {
		if (entity instanceof MiniSquirrel) {
			if(((MiniSquirrel) entity).getMasterSquirrel() == this) {
				return true;
			}
		}
		return false;
	}
	
	public void nextStep() {
		Movement movement = handoperatedMasterSquirrel.getInput();
		super.getPos().moveDirection(movement);
	}
	
	public String toString() {
		return "MasterSquirrel " +super.toString();
	}

}
