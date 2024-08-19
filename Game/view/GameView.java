package Game.view;

import java.util.Random;
import java.util.Scanner;

import Game.models.GameModel;



public class GameView {
    public static final int PLAYER_1 = 1;
    public static final int PLAYER_2 = 2;

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

    public int validateValue(int value, String message) {
        Scanner scanner = new Scanner(System.in);
        while (!(value >= 0 && value < GameModel.BOARD_SIZE)) {
            System.out.println("The value is out of bound. Please provide correct value for "  + message + " the board size.");
            value = scanner.nextInt();
            }
            
        return value;

    }

    public int[] getPlayerMove(int type) {
      
        if (type == 1) {  //human 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row and column numbers (0-2):");
        int row = scanner.nextInt();
        validateValue(row, "row");
      
        int col = scanner.nextInt();
        validateValue(col, "col");
    

        return new int[] {row, col};
        

        } else if (type == 2) {
        Random random = new Random();
        int row = random.nextInt(3);
        validateValue(row, "row");

        int col = random.nextInt(3);
        validateValue(col, "col");
        System.out.println("row" + row + "col" + col);
        return new int[] {row, col};
        
        } else {
        Random random = new Random();
        int row = random.nextInt(3);
        int col = random.nextInt(3);
        System.out.println("row" + row + "col" + col);
        return new int[]{row, col};
    
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
    
