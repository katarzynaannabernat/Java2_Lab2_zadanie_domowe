import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Main.TicTacToe;

public class Main {
 public static void main(String[] args) throws IOException {
     TicTacToe game = new TicTacToe();
     
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 String string;
     
     do {
         game.printBoard();
    	 
         System.out.println("Player " + game.getActivePlayer() + " turn!");

    	 boolean moveCompleted = false;
	     do {
	    	 System.out.print("Enter x coordinate for your move: ");
	         string = br.readLine();
		     int x = Integer.parseInt(string);
		     
		     System.out.print("Enter y coordinate for your move: ");
	         string = br.readLine();
		     int y = Integer.parseInt(string);
		     
		     System.out.println("");
		     
		     moveCompleted = game.move(x, y);
		     
		     if(false == moveCompleted) {
		    	 System.out.println("Incorrect move, try again.");
		     }
	    	 
	     } while(moveCompleted == false);
    	 
     } while(game.checkWhoWon() == null);
     
     game.printBoard();
     System.out.println("Congratulation player " + game.checkWhoWon() + " won!");
  
 }
}