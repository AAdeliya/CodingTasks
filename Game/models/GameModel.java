package Game.models;

import java.util.Random;

public class GameModel {
  
    protected static final int BOARD_SIZE = 3; 
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
    // public void makeMoveComputer(int player) {
    //     Random random = new Random();
    //     int row = random.nextInt(BOARD_SIZE);
    //     int col = random.nextInt(BOARD_SIZE);
    //     if (isValidMove(row, col)) {
    //         board[row][col] = player;
    //     }
    // }

    public boolean checkWin() {
        // Combine CheckVertical, CheckHorizontal, CheckDiagonal here
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
            if (board[row][0] == 1 && board[row][1] == 0 && board[row][2] == 0)  { //100  //120
                return new int[]{row, 1};
            } else if (board[row][0] == 0 && board[row][1] == 1 && board[row][2] == 0) { //010   //210
                return new int[]{row, 0};
           // }else if(board[row][0] == 0 && board[row][1] == 0 && board[row][2] == 1){ //001    //021
            } else { 
                return new int[] {row, 1};

           }
               
        }
        return null;
      
    }

     private boolean checkHorizontal() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (board[row][0] == 1 && board[row][1] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal() {
        return (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }
    
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




    
