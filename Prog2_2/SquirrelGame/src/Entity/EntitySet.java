package Entity;

public class EntitySet {

	public Entity[] entitys;
	private int pointer = 0;

	public EntitySet(int entitysNumber) {
		this.entitys = new Entity[entitysNumber];
	}

	public void insert(Entity entity) {
		for (int i = 0; i < entitys.length; i++) {
			if (entity.equals(entitys[i])) {
				System.err.println("This entity is already in the array!");
				return;
			}
		}
		if (!isFull()) {
			entitys[pointer] = entity;
		} else {
			System.err.println("Array is full, unable to add entity!");
		}
	}

	private boolean isFull() {
		for (int i = 0; i < entitys.length; i++) {
			if (entitys[i] == null) {
				pointer = i;
				return false;
			}
		}
		return true;
	}

	public void delete(Entity entity) {
		for (int i = 0; i < entitys.length; i++) {
			if (entitys[i].equals(entity)) {
				entitys[i] = null;
				return;
			}
		}
		System.err.println("Entity not in the array to delete!");
	}

	public void nextStep() {
		for (int i = 0; i < entitys.length; i++) {
			if (entitys[i] != null) {
				if (entitys[i] instanceof MasterSquirrel) {
					int x = entitys[i].getPos().getX();
					int y = entitys[i].getPos().getY();
					entitys[i].nextStep();
					for (int j = 0; j < entitys.length; j++) {
						if (entitys[j] instanceof GoodPlant) {
							if (entitys[i].getPos().getX() == entitys[j].getPos().getX()
									&& entitys[i].getPos().getY() == entitys[j].getPos().getY()) {
								delete(entitys[j]);
								continue;
							}
						}
					}
					continue;
				}
				entitys[i].nextStep();
			}
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < entitys.length; i++) {
			if (entitys[i] != null) {
				s += entitys[i].toString() + "\n";
			}
		}
		return s;
	}
}
