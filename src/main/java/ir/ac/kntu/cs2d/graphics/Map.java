package ir.ac.kntu.cs2d.graphics;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Map {
    private List<Rectangle> obstacles ;

    public void createDust2Obstacles(){

    }

    public void addObstaclesTo(Pane root){
        if (obstacles==null){
            System.err.println("no obstacle added!");
            return;
        }
        root.getChildren().addAll(obstacles);
    }
}
