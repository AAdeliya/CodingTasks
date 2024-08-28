package Game.controllers;


import java.util.Random;

import Game.models.GameModel;
import Game.view.GameView;


public class GameController {
    
    private GameModel model;
    private GameView view;
    public static boolean isPlayer1Turn = true;


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
                move = GameView.getPlayerMove(currentPlayer);

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
            







             // Human vs Human
            //  if (type == 1) {
            //     // Get move from player (human)
            //     move = view.getPlayerMove(type);
            // } 
            // // Human vs Computer
            // else if (type == 2) {
            //     if (currentPlayer == 1) {
            //         // Get move from player (human)
            //         move = view.getPlayerMove(type);
            //     } else {
            //         // Get move from computer
            //         move = getComputerMove();
            //     }
            // } 
            // // Human vs Smarter Computer
            // else if (type == 3) {
            //     if (currentPlayer == 1) {
            //         // Get move from player (human)
            //         move = view.getPlayerMove(type);
            //     } else {
            //         // Get smarter move from computer
            //         move = getSmarterComputerMove();
            //     }
            // } else {
            //     // Default case if type is not recognized
            //     view.displayMessage("Invalid game type selected.");
            //     return;
            // }

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
        // Random move logic for the computer
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(GameModel.BOARD_SIZE);
            col = random.nextInt(GameModel.BOARD_SIZE);
        } while (!model.isValidMove(row, col));

        return new int[]{row, col};
    }

    private int[] getSmarterComputerMove() {
        // Smarter move logic for the computer (can be more complex based on game strategy)
        int[] move = model.checkHorizontalByComputer();
        if (move[0] == -1 && move[1] == -1) {
            return getComputerMove(); // Fallback to random move if no smart move found
        }
        return move;
    }
}


    