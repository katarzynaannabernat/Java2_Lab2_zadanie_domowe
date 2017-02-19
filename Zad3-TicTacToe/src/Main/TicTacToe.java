package Main;

import java.util.Dictionary;

public class TicTacToe {
	
	private static final int PLAYER_X = 1;
	private static final int PLAYER_0 = 2;
	
	private String[] signs = new String[] {
	    " ", "X", "O"
	};
	
	private int[][] board;
	
	public TicTacToe() {
		this.board  = new int[][] {
		  { 0, 0, 0 },
		  { 0, 0, 0 },
		  { 0, 0, 0 },
		};
	}
	
	private int actualPlayer = PLAYER_X;
	
	public void printBoard() {
		System.out.println(" "+signs[board[0][0]]+" | "+signs[board[1][0]]+" | "+signs[board[2][0]]);
		System.out.println("---|---|---");
		System.out.println(" "+signs[board[0][1]]+" | "+signs[board[1][1]]+" | "+signs[board[2][1]]);
		System.out.println("---|---|---");
		System.out.println(" "+signs[board[0][2]]+" | "+signs[board[1][2]]+" | "+signs[board[2][2]]);
	}
	
	public boolean move(int x, int y) {
		if(x < 0 || x > 2) {
			return false;
		}
		
		if(y < 0 || y > 2) {
			return false;
		}
		
		if(board[x][y] != 0) {
			return false;
		}
		
		board[x][y] = actualPlayer;
		
		if(actualPlayer == PLAYER_X) {
			actualPlayer = PLAYER_0;
		} else {
			actualPlayer = PLAYER_X;
		}
		
		return true;
	}
	
	public String checkWhoWon() {
		String winner = "";
		for(int i = 0; i < 3; i++) {
			winner = checkRow(i);
			if(winner != null) {
				return winner;
			}
			
			winner = checkColumn(i);
			if(winner != null) {
				return winner;
			}
		}
		
		winner = checkDiagonals();
		if(winner != null) {
			return winner;
		}
		
		return null;
	}
	
	private String checkRow(int row) {
		if(board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
			if(board[row][0] > 0) {
				return signs[board[row][0]];
			}
		}
		
		return null;
	}
	
	private String checkColumn(int column) {
		if(board[0][column] == board[1][column] && board[1][column] == board[2][column]) {
			if(board[0][column] > 0) {
				return signs[board[0][column]];
			}
		}
		
		return null;
	}
	
	private String checkDiagonals() {
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			if(board[0][0] > 0) {
				return signs[board[0][0]];
			}
		}
		
		if(board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			if(board[0][2] > 0) {
				return signs[board[0][2]];
			}
		}
		
		return null;
	}
	
	public String getActivePlayer() {
		return signs[actualPlayer];
	}
}
