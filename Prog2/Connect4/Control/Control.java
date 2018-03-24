package Control;

import java.io.IOException;

import AI.AI;
import GUI.GUI;

public class Control {

	private GUI gui;
	private Player player = Player.PLAYER_1;
	private Player aiPlayer = (player == Player.PLAYER_1) ? Player.PLAYER_2 : Player.PLAYER_1;
	private AI ai;
	private boolean gameOver;

	public Control() {
		this.gui = new GUI();
		createAI();
	}

	public void startGame() throws IOException {
		/*
		 * 
		 * MAIN MENU
		 * 
		 */

		while (gameOver == false) {
			gui.drawField();
			manageWin();
			input();
		}
		
	}
	
	public void resetGame() {
		//this.gui = new GUI();
		//gameOver == false 
		//startGae aufrufen
		
	}

	public int getInput() throws IOException {
		int input = System.in.read();
		System.in.read();
		System.in.read();

		return input;
	}

	public void input() throws IOException {
		int input = getInput();

		if (input == 'w') {
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
		
		//input taste r und after winning screen a reset screen 

		if (input >= '1' && input <= '7') {
			input -= '1';
			for (int i = gui.getROW() - 1; i >= 0; i--) {
				if (gui.getField()[i][input] == gui.getEMPTY()) {
					updateField(input);
					return;
				}
			}
		}
		System.err.println("Invalid Input");
		input();
	}

	public void updateField(int input) {
		for (int i = gui.getROW() - 1; i >= 0; i--) {
			if (gui.getField()[i][input] == gui.getEMPTY()) {
				gui.getField()[i][input] = (player == Player.PLAYER_1) ? gui.getPLAYER_1() : gui.getPLAYER_2();
				player = (player == Player.PLAYER_1) ? Player.PLAYER_2 : Player.PLAYER_1;
				return;
			}
		}

	}

	public void undoMove(int input) {
		for (int i = 0; i < gui.getROW(); i++) {
			if (gui.getField()[i][input] != gui.getEMPTY()) {
				gui.getField()[i][input] = gui.getEMPTY();
				player = (player == Player.PLAYER_1) ? Player.PLAYER_2 : Player.PLAYER_1;
				return;
			}
		}

	}

	public void createAI() {
		this.ai = new AI(this.gui, this);
	}

	public void outputPossibleMoves() {
		int[] moves = ai.possibleMoves();
		int counter = 0;
		for (int i = 0; i < moves.length; i++) {
			if (moves[i] == 1) {
				counter++;
			}
		}
		System.out.println(counter);
	}

	public int checkWin() {

		int counter1 = 0;
		int counter2 = 0;

		for (int i = 0; i < gui.getROW(); i++) {
			for (int j = 0; j < gui.getCOLUMN(); j++) {
				if (gui.getField()[i][j] == gui.getPLAYER_1()) {
					counter1++;
					counter2 = 0;
				} else if (gui.getField()[i][j] == gui.getPLAYER_2()) {
					counter2++;
					counter1 = 0;
				}

				else {
					counter1 = 0;
					counter2 = 0;
				}

				if (counter1 == 4) {
					return 1;
				}

				else if (counter2 == 4) {
					return 2;
				}

			}

			counter1 = 0;
			counter2 = 0;
		}

		for (int j = 0; j < gui.getCOLUMN(); j++) {
			for (int i = 0; i < gui.getROW(); i++) {
				if (gui.getField()[i][j] == gui.getPLAYER_1()) {
					counter1++;
					counter2 = 0;
				} else if (gui.getField()[i][j] == gui.getPLAYER_2()) {
					counter2++;
					counter1 = 0;
				}

				else {
					counter1 = 0;
					counter2 = 0;
				}

				if (counter1 == 4) {
					return 1;
				}

				else if (counter2 == 4) {
					return 2;
				}

			}

			counter1 = 0;
			counter2 = 0;
		}

		for (int i = 0; i < gui.getROW(); i++) {
			for (int j = 0; j < gui.getCOLUMN(); j++) {
				if (gui.getField()[i][j] == gui.getPLAYER_1()) {
					if (checkDiagonalWinRight(i, j, gui.getPLAYER_1(), 1) == 1 || checkDiagonalWinLeft(i, j, gui.getPLAYER_1(), 1) ==1) {
						return 1;
					}
				}
				if (gui.getField()[i][j] == gui.getPLAYER_2()) {
					if (checkDiagonalWinRight(i, j, gui.getPLAYER_2(), 1) == 2 || checkDiagonalWinLeft(i, j, gui.getPLAYER_2(), 1) ==2) {
						return 2;
					}
				}
			}
		}

		int counterDraw = 0;

		for (int i = 0; i < gui.getROW(); i++) {
			if (gui.getField()[0][i] != gui.getEMPTY()) {
				counterDraw++;
				if (counterDraw == gui.getROW()) {
					return 0;
				}
			}
		}
		return -1;
	}

	private int checkDiagonalWinRight(int row, int column, char player, int counter) {
		if (counter == 4) {
			return (player == gui.getPLAYER_1()) ? 1 : 2;
		}

				if (gui.getField()[row][column] == player) {
					counter++;
					if (row + 1 < gui.getROW() && column + 1 < gui.getCOLUMN()) 
					return checkDiagonalWinRight(row+1, column+1, player, counter);
				}
		return -1;
	}
	
	private int checkDiagonalWinLeft(int row, int column, char player, int counter) {
		if (counter == 4) {
			return (player == gui.getPLAYER_1()) ? 1 : 2;
		}

				if (gui.getField()[row][column] == player) {
					counter++;
					if (row + 1 < gui.getROW() && column - 1 >= 0) 
					return checkDiagonalWinLeft(row+1, column-1, player, counter);
				}
		return -1;
	}

	public void manageWin() {

		int gameState = checkWin();
		gui.displayWin(gameState);

		switch (gameState) {

		case 1:
		case 2:
		case 0:
			gameOver = true;

		}

	}

	public Player getPlayer() {
		return player;
	}

	public Player getAiPlayer() {
		return aiPlayer;
	}

}
