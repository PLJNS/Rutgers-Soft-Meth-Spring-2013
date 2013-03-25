package view;

import controller.ChessBoardViewController;
import util.*;

public class ChessBoardView {

	public ChessBoardViewController vc;
	
	public ChessBoardView(ChessBoardViewController viewController) {
		this.vc = viewController;
	}
	
	public void giveArgument(String arg) {
		if (arg.compareTo("resign") == 0) {
			this.vc.resign();
		} else if (arg.length() == 5){
			char rankOne = arg.charAt(0);
			char fileOne = arg.charAt(1);
			
			char rankTwo = arg.charAt(3);
			char fileTwo = arg.charAt(4);
			
			try {
				vc.makeMove(rankOne, fileOne, rankTwo, fileTwo, null);
			} catch (InvalidCoordinateException ice) {
				System.out.println(ice.getMessage());
			} catch (InvalidMoveException ime) {
				System.out.println(ime.getMessage());
			}
		} else if (arg.length() == 7) {
			char rankOne = arg.charAt(0);
			char fileOne = arg.charAt(1);
			
			char rankTwo = arg.charAt(3);
			char fileTwo = arg.charAt(4);
			
			char promote = Character.toUpperCase(arg.charAt(6));
			
			try {
				vc.makeMove(rankOne, fileOne, rankTwo, fileTwo, "" + promote);
			} catch (InvalidCoordinateException ice) {
				System.out.println(ice.getMessage());
			} catch (InvalidMoveException ime) {
				System.out.println(ime.getMessage());
			}
		}
	}
	
	public void printBoard() {
		System.out.println(this.vc.getBoardString());
	}
	
	public void printPrompt() {
		System.out.print(vc.isBlackTurn() ? "Black's turn: " : "White's turn: ");
	}
}
