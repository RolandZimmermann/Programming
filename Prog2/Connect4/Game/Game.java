package Game;

import java.io.IOException;

import Control.Control;
import GUI.GUI;

public class Game {

	public static void main(String[] args) throws IOException {
		
		GUI gui = new GUI();
		Control control = new Control(gui);
		
		while(true) {
			gui.drawField();
			control.input();
		}
		
		//TODO: Only accept inputs between 1 and 7
	}

}
