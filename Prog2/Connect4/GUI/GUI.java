package GUI;

import Control.*;

public class GUI {
	
	private final int ROW = 6;
	private final int COLUMN = 7;
	private char[][] field = new char[ROW][COLUMN];
	
	private final char EMPTY = '.';
	private final char PLAYER_1 = 'X';
	private final char PLAYER_2 = 'O';
	
	private String INFO = "1234567";
	
	public GUI() {
		createField();
	}
	
	private void createField() {
		for(int y = 0; y < ROW; y++) {
			for(int x = 0; x < COLUMN; x++) {
				field[y][x] = EMPTY;
			}
		}
	}
	
	public void drawField() {
		emptyConsole();
		
		System.out.println(INFO);
		System.out.println();
		
		for(int y = 0; y < ROW; y++) {
			for(int x = 0; x < COLUMN; x++) {
				System.out.print(field[y][x]);
			}
			System.out.println();
		}
		
		System.out.println(INFO);
		System.out.println();
		
	}
	
	public void emptyConsole() {
		for(int i = 0; i < 60; i++) {
			System.out.println();
		}
	}
	
	public void updateField(int input, Player player) {
		for(int i = ROW-1; i >= 0; i--) {
			if (field[i][input] == EMPTY) {
				field[i][input] = (player == Player.PLAYER_1) ? PLAYER_1 : PLAYER_2;
				return;
			}
		}
	}

	public char[][] getField() {
		return field;
	}

	public int getROW() {
		return ROW;
	}

	public char getEMPTY() {
		return EMPTY;
	}

	public char getPLAYER_1() {
		return PLAYER_1;
	}

	public char getPLAYER_2() {
		return PLAYER_2;
	}
}