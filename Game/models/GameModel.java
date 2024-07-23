package Game.models;

public class GameModel {
    public int[][] board = new int[3][3];

    public GameModel() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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
        // Combine CheckVertical, CheckHorizontal, CheckDiagonal here
        return checkVertical() || checkHorizontal() || checkDiagonal();
    }

    private boolean checkVertical() {
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != 0 && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontal() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != 0 && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal() {
        return (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }
}

    
