package Game.view;

import java.util.Scanner;

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

    public int[] getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row and column numbers (0-2):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }
}
    
