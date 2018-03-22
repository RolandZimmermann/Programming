package AI;

import Control.*;
import GUI.GUI;

public class AI {

	private char[][] field;
	private GUI gui;
	private Control control;
	private int[][] fieldValue = {{3,4,5,7,5,4,3},
								  {4,6,8,10,8,6,4},
								  {5,8,11,13,11,8,5},
								  {5,8,11,13,11,8,5},
								  {4,6,8,10,8,6,4},
								  {3,4,5,7,5,4,3}};

	public AI(GUI gui, Control control) {
		this.field = gui.getField();
		this.gui = gui;
		this.control = control;
	}

	public int[] possibleMoves() {
		int[] output = new int[gui.getCOLUMN()];
		
		for(int i = 0; i < output.length; i++) {
			output[i] = 0;
		}
		
		for (int input = 0; input < field[0].length; input++) {
			if(field[0][input] == gui.getEMPTY()) {
				output[input] = 1;
			}
		}
		return output;
	}
	
	public int evaluateField(Player player) {
		int scorePlayer1 = 0;
		int scorePlayer2 = 0;
		
		for (int y = 0; y < field.length; y++) {
			for (int x = 0; x < field[0].length; x++) {
				if(field[y][x] == gui.getPLAYER_1()) {
					scorePlayer1 += fieldValue[y][x];
				}
				if(field[y][x] == gui.getPLAYER_2()) {
					scorePlayer2 += fieldValue[y][x];
				}
			}
		}
		
		return (player == Player.PLAYER_1) ? (scorePlayer1 - scorePlayer2) : (scorePlayer2 - scorePlayer1);
	}
	
	//TODO: check if move is winning move;
	public void makeMove() {
		int[] possibleMoves = possibleMoves();
		int score = Integer.MIN_VALUE;
		int move = 0;
		
		for (int i = 0; i < possibleMoves.length; i++) {
			if (possibleMoves[i] == 1) {
				control.updateField(i);
				int newScore = evaluateField(control.getAiPlayer());
				control.undoMove(i);
				
				if (newScore > score) {
					score = newScore;
					move = i;
				}
				
			}
		}
		control.updateField(move);
	}

}
