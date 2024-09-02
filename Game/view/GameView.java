package Game.view;


import java.util.Random;
import java.util.Scanner;

import Game.controllers.GameController;
import Game.models.GameModel;


public class GameView {

    public static final int NO_SMART_MOVE = -1;
    
    public void displayBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }

            System.out.println();
        }
    }
    
    public void displayMessage(String message) {
        System.out.println(message);
    }

 public int typeOfGame() {
        Scanner scanner = new Scanner(System.in);
        displayMessage("Please select type of game: ");
        displayMessage("1.Human VS Human");
        displayMessage("2.Human VS Computer");
        displayMessage("3.Human VS Computer Smarter"); 
        int typeOfGame = scanner.nextInt();

        while (typeOfGame != 1 && typeOfGame != 2 && typeOfGame != 3) {
            displayMessage("This type of game is invalid. Please select correct type of game: 1, 2, 3");
            typeOfGame = scanner.nextInt();
         }
         
          return typeOfGame;
        
    }
    
}
    
