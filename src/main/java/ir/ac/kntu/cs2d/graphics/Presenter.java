package ir.ac.kntu.cs2d.graphics;

import ir.ac.kntu.cs2d.logic.Game;
import ir.ac.kntu.cs2d.logic.Observable;
import javafx.application.Application;
import javafx.stage.Stage;

public class Presenter extends Application implements Observer<Game> {

    private Game game ;


    @Override
    public void init() {
//        initializeMap();
        game = new Game();

    }

    @Override
    public void start(Stage stage) {

    }

    @Override
    public void update(Game observable) {

    }
}
