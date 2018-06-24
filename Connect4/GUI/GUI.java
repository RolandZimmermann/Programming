package GUI;

public class GUI {

	private final int ROW = 6;
	private final int COLUMN = 7;
	private char[][] field = new char[ROW][COLUMN];

	private final char EMPTY = '.';
	private final char PLAYER_1 = 'X';
	private final char PLAYER_2 = 'O';

	private final String INFO = " 1 2 3 4 5 6 7 ";
	private char playerTurn = 'X';

	public GUI() {
		createField();
	}

	private void createField() {
		for (int y = 0; y < ROW; y++) {
			for (int x = 0; x < COLUMN; x++) {
				field[y][x] = EMPTY;
			}
		}
	}

	public void drawField() {
		emptyConsole();

		System.out.println("Turn of Player: " + ((playerTurn == PLAYER_1) ? "P1 = X" : "P2 = O"));
		System.out.println();
		System.out.println(INFO);

		for (int y = 0; y < ROW; y++) {
			for (int x = 0; x < COLUMN; x++) {
				if (x == 0) {
					System.out.print('|');
				}
				System.out.print(field[y][x]);
				System.out.print('|');
			}
			System.out.println();
		}

		System.out.println(INFO);
		System.out.println();

	}

	public void emptyConsole() {
		for (int i = 0; i < 60; i++) {
			System.out.println();
		}
	}

	public void createMainMenu() {

		emptyConsole();
		
		System.out.println("**********************************************");
		System.out.println("|             MAIN MENU SELECTION            |");
		System.out.println("**********************************************");
		System.out.println("|Options:                                    |");
		System.out.println("|                                            |");
		System.out.println("|                                            |");
		System.out.println("|                                            |");
		System.out.println("|        (1) Single vs. Single               |");
		System.out.println("|                                            |");
		System.out.println("|        (2) Single vs. Computer             |");
		System.out.println("|                                            |");
		System.out.println("|                                            |");
		System.out.println("|                                            |");
		System.out.println("|                                            |");
		System.out.println("|   made by Kim Nguyen & Roland Zimmermann   |");
		System.out.println("**********************************************");
	}
	
	public void displayAISelection() {
		
		emptyConsole();
		
		System.out.println("**********************************************");
		System.out.println("|             AI SELECTION                   |");
		System.out.println("**********************************************");
		System.out.println("|Options:                                    |");
		System.out.println("|                                            |");
		System.out.println("|                                            |");
		System.out.println("|                                            |");
		System.out.println("|        (1) Easy                            |");
		System.out.println("|        (2) Medium                          |");
		System.out.println("|        (3) Hard                            |");
		System.out.println("|        (4) Very Hard                       |");
		System.out.println("|                                            |");
		System.out.println("|        (r) RESTART                         |");
		System.out.println("|                                            |");
		System.out.println("|   made by Kim Nguyen & Roland Zimmermann   |");
		System.out.println("**********************************************");
	}

	public void displayWin(int status) {

		if (status == 1) {
			System.out.println("Player 'X' won!");
			System.out.println("Press r to reset the game");
		} else if (status == 2) {
			System.out.println("Player 'O' won!");
			System.out.println("Press r to reset the game");
		} else if (status == 0) {
			System.out.println("Draw!");
			System.out.println("Press r to reset the game");
		}
	}

	public char[][] getField() {
		return field;
	}

	public int getROW() {
		return ROW;
	}

	public int getCOLUMN() {
		return COLUMN;
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

	public String getINFO() {
		return INFO;
	}

	public void setPlayerTurnGUI(char playerTurn) {
		this.playerTurn = playerTurn;
	}
}
