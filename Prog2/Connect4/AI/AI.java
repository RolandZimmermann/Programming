package AI;

import Control.*;
import GUI.GUI;

public class AI {

	private char[][] field;
	private GUI gui;
	private Control control;
	private int maxDepth = 2;
	private int nextMove = -1;
	private int[][] fieldValue = { { 3, 4, 5, 7, 5, 4, 3 }, { 4, 6, 8, 10, 8, 6, 4 }, { 5, 8, 11, 13, 11, 8, 5 },
			{ 5, 8, 11, 13, 11, 8, 5 }, { 4, 6, 8, 10, 8, 6, 4 }, { 3, 4, 5, 7, 5, 4, 3 } };

	public AI(GUI gui, Control control, int maxDepth) {
		this.field = gui.getField();
		this.gui = gui;
		this.control = control;
		this.maxDepth = maxDepth;
	}

	public int[] possibleMoves() {
		int[] output = new int[gui.getCOLUMN()];

		for (int i = 0; i < output.length; i++) {
			output[i] = 0;
		}

		for (int input = 0; input < field[0].length; input++) {
			if (field[0][input] == gui.getEMPTY()) {
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
				if (field[y][x] == gui.getPLAYER_1()) {
					scorePlayer1 += fieldValue[y][x];
				}
				if (field[y][x] == gui.getPLAYER_2()) {
					scorePlayer2 += fieldValue[y][x];
				}
			}
		}

		if (control.checkWin() == 1) {
			scorePlayer1 = Integer.MAX_VALUE;
		}
		if (control.checkWin() == 2) {
			scorePlayer2 = Integer.MAX_VALUE;
		}

		return (player == Player.PLAYER_1) ? (scorePlayer1 - scorePlayer2) : (scorePlayer2 - scorePlayer1);
	}

	// TODO: check if move is winning move;
	public void makeMove() {
		int value = max(maxDepth,Integer.MIN_VALUE,Integer.MAX_VALUE);
		control.updateField(nextMove);
	}

	public int max(int depth, int alpha, int beta) {
		if (depth == 0 || control.checkWin() == 0) {
			return evaluateField(control.getAiPlayer());
		}
		
		int maxValue = alpha;
		int[] possibleMoves = possibleMoves();
		for (int i = 0; i < possibleMoves.length; i++) {
			if (possibleMoves[i] == 1) {
				control.updateField(i);
				int value = min(depth - 1, maxValue, beta);
				control.undoMove(i);
				if (value > maxValue) {
					maxValue = value;
					if (maxValue >= beta) {
						break;
					}
					if (depth == maxDepth) {
						nextMove = i;
					}
				}
			}
		}
		return maxValue;
	}
	
	public int min(int depth, int alpha, int beta) {
		if (depth == 0 || control.checkWin() == 0) {
			return evaluateField(control.getAiPlayer());
		}
		int minValue = beta;
		int[] possibleMoves = possibleMoves();
		for (int i = 0; i < possibleMoves.length; i++) {
			if (possibleMoves[i] == 1) {
				control.updateField(i);
				int value = min(depth - 1, alpha, minValue);
				control.undoMove(i);
				if (value < minValue) {
					minValue = value;
					if (minValue <= alpha) {
						break;
					}
				}
			}
		}
		return minValue;
	}

}
