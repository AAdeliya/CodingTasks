package Game.controllers;


import java.util.Random;
import java.util.Scanner;

import Game.models.GameModel;
import Game.view.GameView;


public class GameController {
    
    private GameModel model;
    private GameView view;
    public static boolean isPlayer1Turn = true;
    public static final int NO_SMART_MOVE = -1;


    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        int type = view.typeOfGame();
        
         while (!model.checkWin() && !model.isBoardFull()) {
            view.displayBoard(GameModel.board);
            int currentPlayer = isPlayer1Turn ? 1 : 2;
            view.displayMessage("Player " + currentPlayer + "'s turn");

            int[] move;      
            if (type == 1 || (type > 1 && currentPlayer == 1)) {
                move = getPlayerMove(currentPlayer);

            } else {
                // Computer's turn
                if (type == 2) {
                    move = getComputerMove();
                } else if (type == 3) {
                    move = getSmarterComputerMove();
                } else {
                    view.displayMessage("Invalid game type selected.");
                    return;
                }
            }

            // Validate and make the move
            if (model.isValidMove(move[0], move[1])) {
                model.makeMove(move[0], move[1], currentPlayer);

                if (model.checkWin()) {
                    view.displayMessage("Player " + currentPlayer + " wins!");
                    break;
                }

                // Switch turns
                isPlayer1Turn = !isPlayer1Turn;
            } else {
                view.displayMessage("Invalid move, try again.");
            }

            if (model.isBoardFull()) {
                view.displayMessage("The board is full! The game is over!");
                break;
            }
        }
    }

    private int[] getComputerMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(GameModel.BOARD_SIZE);
            col = random.nextInt(GameModel.BOARD_SIZE);
        } while (!GameModel.isValidMove(row, col));
          return new int[]{row, col};
    }

    private int[] getSmarterComputerMove() {
        int[] move = GameModel.checkHorizontalByComputer();
        if (move[0] == NO_SMART_MOVE && move[1] == NO_SMART_MOVE) {
            return getComputerMove(); // Fallback to random move if no smart move found
        }
        return move;
    }

    public static int[] getPlayerMove(int type) {
        Scanner scanner = new Scanner(System.in);

    if (type == 1 || (type == 2 && GameController.isPlayer1Turn)) {  // Human vs Human or Human's turn in Human vs Computer
        System.out.println("Enter row and column numbers from 0 to " + GameModel.BOARD_SIZE);
        int row = scanner.nextInt();
        row = GameModel.validateValue(row, "row");

        int col = scanner.nextInt();
        col = GameModel.validateValue(col, "col");
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
}


    