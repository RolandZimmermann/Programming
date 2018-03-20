package Control;

import java.io.IOException;

import GUI.GUI;

public class Control {

	private GUI gui;
	private Player player = Player.PLAYER_1;
	private int input = 0;;
	
	public Control(GUI gui) {
		this.gui = gui;
	}
	
	public void input() throws IOException {
		input = System.in.read();
		input -= '0';
		input--;
		System.in.read();
		System.in.read();
		for(int i = gui.getROW()-1; i >= 0; i--) {
			if (gui.getField()[i][input] == gui.getEMPTY()) {
				updateInput();
				return;
			}
		}
		System.err.println("Ungültige Eingabe");
		input();
	}
	
	public void updateInput() {
		gui.updateField(input, player);
		player = (player == Player.PLAYER_1) ? Player.PLAYER_2 : Player.PLAYER_1;
	}
	
	
	
	
	
}
