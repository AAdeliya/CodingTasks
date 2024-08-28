package Game.models;


import java.util.Random;


public class GameModel {
  
    public static final int BOARD_SIZE = 3; 
    protected static final int EMPTY_SPACE = 0;
    private static final int[] NO_MOVE_FOUND = {-1, -1}; 
    protected static final int FIRST_INDEX = 0;
    protected static final int LAST_INDEX = BOARD_SIZE - 1;
    public static final int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = 0;  
            }
        }
    }

    public static boolean isValidMove(int row, int col) {
        return board[row][col] == 0;
    }

    public void makeMove(int row, int col, int player) {
        if (isValidMove(row, col)) {
            board[row][col] = player;
        }
    }

    public boolean checkWin() {
        // System.out.println("Check Vertical " + checkVertical());
        // System.out.println("Check Horizonal " + checkHorizontal());
        // System.out.println("Check Diagnol " + checkDiagonal());
        return checkVertical() || checkHorizontal() || checkDiagonal();
    }

    public boolean checkVertical() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            int top = 0;
            int bottom  = 1; 
            
            if (board[top][i] == EMPTY_SPACE) {
                continue;
               }

               boolean win= true;
    
            while (bottom < BOARD_SIZE) {
            if (board[top][i] != board[bottom][i]) {
                    win = false;
                    break;
                }
                
                top++;
                bottom++;   
            }
    
            if (win) {
                return true;  
            }
        }
    
        return false;  
    }
    public static int[] checkHorizontalByComputer() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            // Check if a winning or blocking move can be made
            if (board[row][0] == 1 && board[row][1] == EMPTY_SPACE && board[row][2] == EMPTY_SPACE) {
                return new int[]{row, 1};  // Play at (row, 1)
            } else if (board[row][0] == EMPTY_SPACE && board[row][1] == 1 && board[row][2] == EMPTY_SPACE) {
                return new int[]{row, 0};  // Play at (row, 0)
            } else if (board[row][0] == EMPTY_SPACE && board[row][1] == EMPTY_SPACE && board[row][2] == 1) {
                return new int[]{row, 2};  // Play at (row, 2)
            }
        }
        return NO_MOVE_FOUND;  // Return {-1, -1} if no move is found
    }

    public boolean checkHorizontal() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            int left = 0;
            int right = 1; 
            
            if (board[i][left] == EMPTY_SPACE) {
                continue;
               }

               boolean win= true;
    
            while (right < BOARD_SIZE) {
            if (board[i][left] != board[i][right]) {
                    win = false;
                    break;
                }
                
                left++;
                right++;   
            }
    
            if (win) {
                return true;  
            }
        }
    
        return false;  
    }
    
    private boolean checkDiagonal() {
        // top-left to bottom-right
        int firstPrimaryDiagonalValue = board[0][0];
        boolean primaryDiagonalWin = firstPrimaryDiagonalValue != EMPTY_SPACE;
    
        for (int i = 1; i < BOARD_SIZE; i++) {
            if (board[i][i] != firstPrimaryDiagonalValue) {
                primaryDiagonalWin = false;
                break;
            }
        }
    
        if (primaryDiagonalWin) {
            return true;
        }
    
        //top-right to bottom-left
        int firstSecondaryDiagonalValue = board[0][BOARD_SIZE - 1];
        boolean secondaryDiagonalWin = firstSecondaryDiagonalValue != EMPTY_SPACE;
    
        for (int i = 1; i < BOARD_SIZE; i++) {
            if (board[i][BOARD_SIZE - 1 - i] != firstSecondaryDiagonalValue) {
                secondaryDiagonalWin = false;
                break;
            }
        }
    
        return secondaryDiagonalWin;
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




    
