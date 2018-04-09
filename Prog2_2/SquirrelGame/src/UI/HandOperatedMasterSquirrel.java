package UI;

import java.util.Scanner;

import GameStats.Movement;

public class HandOperatedMasterSquirrel {
	
	public Movement getInput() {
		Scanner s = new Scanner(System.in);
		
		char input = s.next().charAt(0);
		
		switch(input) {
		case 'w':
			return Movement.UP;
		case 'a':
			return Movement.LEFT;
		case 's':
			return Movement.DOWN;
		case 'd':
			return Movement.RIGHT;
		default: 
			return null;
		}
	}
}
