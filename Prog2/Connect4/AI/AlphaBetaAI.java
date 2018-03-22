package AI;

import GUI.GUI;

public class AlphaBetaAI {

	private char[][] field;
	private GUI gui;

	public AlphaBetaAI(GUI gui) {
		this.field = gui.getField();
		this.gui = gui;
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

}
