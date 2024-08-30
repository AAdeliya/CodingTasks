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
    
    public static int validateValue(int value, String message) {
        Scanner scanner = new Scanner(System.in);
        while (!(value >= 0 && value < GameModel.BOARD_SIZE)) {
            System.out.println("The value is out of bound. Please provide correct value for "  + message + " the board size.");
            value = scanner.nextInt();
        }
        return value;
    }
    
    public static int[] getPlayerMove(int type) {
        Scanner scanner = new Scanner(System.in);

    if (type == 1 || (type == 2 && GameController.isPlayer1Turn)) {  // Human vs Human or Human's turn in Human vs Computer
        System.out.println("Enter row and column numbers from 0 to " + GameModel.BOARD_SIZE);
        int row = scanner.nextInt();
        row = validateValue(row, "row");

        int col = scanner.nextInt();
        col = validateValue(col, "col");
        System.out.println("row" + row + " col" + col);
        return new int[] {row, col};

    } else if (type == 2 && !GameController.isPlayer1Turn) {  // Computer's turn in Human vs Computer
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(GameModel.BOARD_SIZE);
            col = random.nextInt(GameModel.BOARD_SIZE);
        } while (!GameModel.isValidMove(row, col));
        System.out.println("Computer chose row " + row + " col " + col);
        return new int[] {row, col};

    } else {  // Smarter Computer's turn in Human vs Smarter Computer
        int[] move = GameModel.checkHorizontalByComputer();
        
        if (move[0] == NO_SMART_MOVE && move[1] == NO_SMART_MOVE) { //move[0] row move[1] - column if both -1 it means no valid move was found
            Random random = new Random();
            int row, col;

            do {
                row = random.nextInt(GameModel.BOARD_SIZE);
                col = random.nextInt(GameModel.BOARD_SIZE);

            } while (!GameModel.isValidMove(row, col));
            System.out.println("Computer chose row " + row + " col " + col);
            return new int[]{row, col};

        } else { //strategic move was found 
            System.out.println("Smarter Computer chose row " + move[0] + " col " + move[1]);
            return move;
        }
    }
}

 public int typeOfGame() {
        Scanner scanner = new Scanner(System.in);
        displayMessage("Please select type of game: ");
        displayMessage("1.Human VS Human");
        displayMessage("2.Human VS Computer");
        displayMessage("3.Human VS Computer Smarter"); 
        int typeOfGame = scanner.nextInt();

        while (typeOfGame != 1 && typeOfGame != 2 && typeOfGame != 3) {
            System.out.println("This type of game is invalid. Please select correct type of game: 1, 2, 3");
            typeOfGame = scanner.nextInt();
         }
         
          return typeOfGame;
        
    }
    
}
    
