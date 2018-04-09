import Entity.*;

public class test {

	public static void main(String[] args) {
		
		MasterSquirrel Bob = new MasterSquirrel(1, 10, 9);
		Wall wall = new Wall(4, 30, 40);
		Wall wall2 = new Wall(4, 50, 50);
		
		EntitySet entitySet = new EntitySet(5);
		entitySet.insert(Bob);
		entitySet.insert(wall);
		entitySet.insert(wall2);
		entitySet.insert(new BadBeast(6, 40, 40));
		entitySet.insert(new GoodBeast(5, 40, 40));
		entitySet.delete(wall2);
		entitySet.insert(new GoodPlant(8, 10, 10));
		
		
		while (true) {
			System.out.println(entitySet.toString());
			entitySet.nextStep();
		}
	}

}
