package Game.view;

import java.util.Random;
import java.util.Scanner;

import Game.models.GameModel;

public class GameView {
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

    public int[] getPlayerMove(boolean isComputer) {
        if(!isComputer){  
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row and column numbers (0-2):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};

        }else{
        Random random = new Random();
        int row = random.nextInt(2);
        int col = random.nextInt(2);
        return new int[]{row, col};
    
    }

      
    }
    public int typeOfGame(){
        Scanner scanner = new Scanner(System.in);
        displayMessage("Please select type of game: ");
        displayMessage("1.Human VS Human");
        displayMessage("2.Human VS Computer");
        displayMessage("3.Human VS Computer Smarter");
        int typeOfGame = scanner.nextInt();
        return typeOfGame;


    }
}
    
