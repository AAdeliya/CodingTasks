package Game.controllers;

import Game.models.GameModel;
import Game.view.GameView;

public class GameController {
     private GameModel model;
    private GameView view;
    private boolean isPlayer1Turn = true;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        int type = view.typeOfGame();
         while (true) {
            view.displayBoard(model.board);
            int currentPlayer = isPlayer1Turn ? 1 : 2;
            
            view.displayMessage("Player " + currentPlayer + "'s turn");
            int[] move = view.getPlayerMove(type);
            if (model.isValidMove(move[0], move[1])) {
                    model.makeMove(move[0], move[1], currentPlayer);
                    
               
                if (model.checkWin()) {
                    view.displayMessage("Player " + currentPlayer + " wins!");
                    break;
                }
                isPlayer1Turn = !isPlayer1Turn;
            } else {
                view.displayMessage("Invalid move, try again.");
            }
            if(model.isBoardFull()){
                view.displayMessage("The board is full! The game is over!");
                break;
            }
            
        }
    }}
    
       

    
