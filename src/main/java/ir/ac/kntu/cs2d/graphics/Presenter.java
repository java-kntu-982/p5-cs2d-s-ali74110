package ir.ac.kntu.cs2d.graphics;

import ir.ac.kntu.cs2d.logic.play.logic.Camera;
import ir.ac.kntu.cs2d.logic.play.logic.Game;
import javafx.application.Application;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Presenter extends Application implements Observer<Game> {

    private Game game;
    private Circle soldier;
    private Polygon soldierAim;
    private Circle bullet;
    private Circle aim;


//    private


    @Override
    public void init() {

        soldier = new Circle();
        soldierAim = new Polygon();
        bullet = new Circle();
        aim = new Circle();

    }

    @Override
    public void start(Stage stage) {

    }

    @Override
    public void update(Game observable) {

    }
}
