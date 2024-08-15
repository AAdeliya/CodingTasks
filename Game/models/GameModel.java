package Game.models;

import java.util.Random;

public class GameModel {
  
    protected static final int BOARD_SIZE = 3; 
    protected static final int EMPTY_SPACE = 0;
    private static final int[] NO_MOVE_FOUND = {-1, -1};
    public static final int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    
    
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = 0;  
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return board[row][col] == 0;
    }

    public void makeMove(int row, int col, int player) {
        if (isValidMove(row, col)) {
            board[row][col] = player;
        }
    }

    public boolean checkWin() {
        System.out.println("Check Vertical " + checkVertical());
        System.out.println("CheckHorizonal " + checkHorizontal());
        System.out.println("Check Diagnol" + checkDiagonal());
        return checkVertical() || checkHorizontal() || checkDiagonal();
    }
    
    private boolean checkVertical() {
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (board[0][col] != 0 && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }
        return false;
    }
    private int[] checkHorizontalByComputer(){
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (board[row][0] == 1 && board[row][1] == EMPTY_SPACE && board[row][2] == EMPTY_SPACE)  { //100  //120
                return new int[]{row, 1};
            } else if (board[row][0] == EMPTY_SPACE && board[row][1] == 1 && board[row][2] == EMPTY_SPACE) { //010   //210
                return new int[]{row, 0};
           } else {  //021
                return new int[] {row, 1};

           }
               
        }
        return NO_MOVE_FOUND;
      
    }

    //  private boolean checkHorizontal() {
    //     for (int row = 0; row < BOARD_SIZE; row++) {
    //         //if (board[row][0] != 0 && board[row][1] == board[row][1] && board[row][1] == board[row][2]) {
    //             if (board[0][row] != 0 && board[0][row] == board[1][row] && board[1][row] == board[2][row]) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public boolean checkHorizontal() {
    //     for (int i = 0; i < BOARD_SIZE; i++) {
    //         //System.out.println("Checking row " + i);
    //         boolean win= true;
    
    //         int left = 0;
    //         int right = 1;
    
    //         while (right < BOARD_SIZE) {
    //            // System.out.println("Comparing col " + left + " against col " + right);
    //             if (board[i][left] != board[i][right] && board[i][left] != EMPTY_SPACE) {
    //                 win = false;
    //                 break;
    //             }
                
    //             left++;
    //             right++;
    //         }
    
    //         if (win) {
    //             return true;  
    //         }
    //     }
    
    //     return false;  
    // }
//doen't work properly 
    private boolean checkDiagonal() {
        return (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }
    // private boolean isGameOver() {
    //     return checkWin() || isBoardFull();
    // }
    
    public boolean isBoardFull() {
        
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 0) {
                    return false;
                 
                }
                
            }
            
        }
        return true; 
    }
}




    
