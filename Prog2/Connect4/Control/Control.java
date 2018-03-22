package Control;

import java.io.IOException;

import AI.AlphaBetaAI;
import GUI.GUI;

public class Control {

	private GUI gui;
	private Player player = Player.PLAYER_1;
	private int input = 0;
	private AlphaBetaAI ai;
	
	public Control(GUI gui) {
		this.gui = gui;
		createAlphaBetaAI();
	}
	
	public void input() throws IOException {
		input = System.in.read();
		System.in.read();
		System.in.read();
		
		if (input =='w') {
			outputPossibleMoves();
			return;
		}
		
		
		input -= '0';
		input--;
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
	
	public void createAlphaBetaAI() {
		this.ai = new AlphaBetaAI(this.gui);
	}
	
	public void outputPossibleMoves() {
		int[] moves = ai.possibleMoves();
		int counter = 0;
		for(int i = 0; i < moves.length; i++) {
			if (moves[i] == 1) {
				counter++;
			}
		}
		System.out.println(counter);
	}
	
	
	
}
