package Game.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Game.Observer;
import Game.Subject;


public class GameModel implements Subject {
  
    public static final int BOARD_SIZE = 3; 
    protected static final int EMPTY_SPACE = 0;
    private static final int[] NO_MOVE_FOUND = {-1, -1}; 
    protected static final int FIRST_INDEX = 0;
    protected static final int LAST_INDEX = BOARD_SIZE - 1;
    public static final int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

     private List<Observer> observers = new ArrayList<>();
     //this list is used to store all the observers that want to be notified when the subject changes its state
     
     @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
        @Override
        public void attach(Observer observer) { //allows any observer(game view) to register itself with the GameModel ensuring it gets updated when necessary
            observers.add(observer); // add the passed observer to the observers list; 
        }
    


    public void makeMove(int row, int col, int player) {
        if (isValidMove(row, col)) {
            board[row][col] = player;
            notifyObservers();  // Notify observers after the move
        }
    }
    
    public static boolean isValidMove(int row, int col) {
        return board[row][col] == 0;
    }
    
    public static int validateValue(int value, String message) {
        Scanner scanner = new Scanner(System.in);
        while (!(value >= 0 && value < GameModel.BOARD_SIZE)) {
            System.out.println("The value is out of bound. Please provide correct value for "  + message + " the board size.");
            value = scanner.nextInt();
        }
        return value;
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
            int emptyRow = 0;
            int emptyCol = -1;
    
            while (right < BOARD_SIZE) {
                if (board[row][left] == 1) {
                    playerCount++;
                } else if (board[row][left] == EMPTY_SPACE) {
                    emptyRow++;
                    emptyCol = left;  // Track the column of the empty space
                }
    
                if (board[row][right] == 1) {
                    playerCount++;
                } else if (board[row][right] == EMPTY_SPACE) {
                    emptyRow++;
                    emptyCol = right;  // Track the column of the empty space
                }
    
                left++;
                right++;
            }
    
            if (playerCount == BOARD_SIZE - 1 && emptyRow == 1) {
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




    
