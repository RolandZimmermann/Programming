package Control;

import java.io.IOException;

import AI.AI;
import GUI.GUI;

public class Control {

	private GUI gui;
	private Player player = Player.PLAYER_1;
	private Player aiPlayer = (player == Player.PLAYER_1) ? Player.PLAYER_2 : Player.PLAYER_1;
	private AI ai;
	
	public Control(GUI gui) {
		this.gui = gui;
		createAI();
	}
	
	public void input() throws IOException {
		int input = System.in.read();
		System.in.read();
		System.in.read();
		
		if (input =='w') {
			outputPossibleMoves();
			return;
		}
		if (input == 'p') {
			System.out.println(ai.evaluateField(player));
			return;
		}
		
		if (input == 'a') {
			ai.makeMove();
			return;
		}
		
		
		input -= '1';
		for(int i = gui.getROW()-1; i >= 0; i--) {
			if (gui.getField()[i][input] == gui.getEMPTY()) {
				updateField(input);
				return;
			}
		}
		System.err.println("Ungültige Eingabe");
		input();
	}
	
	public void updateField(int input) {
		for(int i = gui.getROW()-1; i >= 0; i--) {
			if (gui.getField()[i][input] == gui.getEMPTY()) {
				gui.getField()[i][input] = (player == Player.PLAYER_1) ? gui.getPLAYER_1() : gui.getPLAYER_2();
				player = (player == Player.PLAYER_1) ? Player.PLAYER_2 : Player.PLAYER_1;
				return;
			}
		}
		
	}
	
	public void undoMove(int input) {
		for(int i = 0; i < gui.getROW(); i++) {
			if (gui.getField()[i][input] != gui.getEMPTY()) {
				gui.getField()[i][input] = gui.getEMPTY();
				player = (player == Player.PLAYER_1) ? Player.PLAYER_2 : Player.PLAYER_1;
				return;
			}
		}
		
	}
	
	public void createAI() {
		this.ai = new AI(this.gui,this);
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

	public Player getPlayer() {
		return player;
	}

	public Player getAiPlayer() {
		return aiPlayer;
	}
	
	
	
}
