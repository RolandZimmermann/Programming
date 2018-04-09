package XY;

import java.util.Random;

import GameStats.Movement;

public final class XY {

	private int x;
	private int y;

	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void randomMove() {
		Random rnd = new Random();
		int move = rnd.nextInt(8);
		switch (move) {
		case 0:
			moveDirection(Movement.DOWN_LEFT);
			break;
		case 1:
			moveDirection(Movement.Down_RIGHT);
			break;
		case 2:
			moveDirection(Movement.UP_LEFT);
			break;
		case 3:
			moveDirection(Movement.UP_LEFT);
			break;
		case 4:
			moveDirection(Movement.DOWN);
			break;
		case 5:
			moveDirection(Movement.UP);
			break;
		case 6:
			moveDirection(Movement.LEFT);
			break;
		case 7:
			moveDirection(Movement.RIGHT);
			break;
		}
	}

	public void moveDirection(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void moveDirection(Movement movement) {
		if(movement == Movement.UP) {
			moveDirection(0,-1);
		}
		if (movement == Movement.DOWN) {
			moveDirection(0,1);
		}
		if (movement == Movement.LEFT) {
			moveDirection(-1,0);
		}
		if (movement == Movement.RIGHT) {
			moveDirection(1, 0);
		}
		if (movement == Movement.DOWN_LEFT) {
			moveDirection(-1,1);
		}
		if (movement == Movement.Down_RIGHT) {
			moveDirection(1,1);
		}
		if (movement == Movement.UP_LEFT) {
			moveDirection(-1,-1);
		}
		if (movement == Movement.UP_RIGHT) {
			moveDirection(1,-1);
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "Position: (" + x + " | " + y + ")";
	}
}
