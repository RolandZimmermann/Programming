package Entity;

import XY.XY;

public class Entity {

	private final int ID;
	private int energy;
	private XY pos;

	public Entity(int ID, int energy, XY pos) {
		this.ID = ID;
		this.energy = energy;
		this.pos = pos;
	}

	public Entity(Entity entity) {
		this(entity.getID(), entity.getEnergy(), entity.getPos());
	}

	public Entity(int ID, int energy, int x, int y) {
		this(ID, energy, new XY(x, y));
	}

	public static boolean isSameEntity(Entity entity1, Entity entity2) {
		if (entity1.equals(entity2)) {
			return true;
		} else {
			return false;
		}
	}

	public void updateEnergy(int deltaEnergy) {
		this.energy += deltaEnergy;
	}

	public void nextStep() {

	}

	public int getEnergy() {
		return energy;
	}

	public XY getPos() {
		return pos;
	}

	public void setPos(int x, int y) {
		this.pos.setX(x);
		this.pos.setY(y);
	}

	public void setPos(XY pos) {
		this.pos = pos;
	}

	public int getID() {
		return ID;
	}

	public String toString() {
		return "ID: " + ID + ", Energie: " + energy + " "+ pos.toString();
	}
}
