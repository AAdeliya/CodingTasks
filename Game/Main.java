package Game;

import Game.controllers.GameController;
import Game.models.GameModel;
import Game.view.GameView;

public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
        controller.startGame();
    }
}