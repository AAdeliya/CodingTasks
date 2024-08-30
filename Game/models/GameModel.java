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

            int left = 0;
            int right = 1;
            int playerCount = 0;
            int emptyCount = 0;
            int emptyCol = -1;
    
            while (right < BOARD_SIZE) {
                if (board[row][left] == 1) {
                    playerCount++;
                } else if (board[row][left] == EMPTY_SPACE) {
                    emptyCount++;
                    emptyCol = left;  // Track the column of the empty space
                }
    
                if (board[row][right] == 1) {
                    playerCount++;
                } else if (board[row][right] == EMPTY_SPACE) {
                    emptyCount++;
                    emptyCol = right;  // Track the column of the empty space
                }
    
                left++;
                right++;
            }
    
            // If there are exactly two player markers and one empty space in a row, return that move
            if (playerCount == BOARD_SIZE - 1 && emptyCount == 1) {
                return new int[]{row, emptyCol};
            }
        }
    
        return NO_MOVE_FOUND; 
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




    
