package ir.ac.kntu.cs2d.graphics;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapGraphic {
    private List<Rectangle> obstacles = new ArrayList<>();

    public void createDust2Obstacles() throws FileNotFoundException {
        File file = new File("F:/ALI/university/Term 2/Java/project 5/p5-cs2d-s-ali74110/src/main/resources/maps/Dust2-cs2d.csv");
        FileInputStream is = new FileInputStream(file);
        Scanner scanner = new Scanner(is);
        String numSt = scanner.nextLine();
        int num = Integer.parseInt(numSt);
        String obstacle;
        String[] obstacleDetails;
        for (int i = 0; i < num ; i++) {
            obstacle = scanner.nextLine();
            obstacleDetails = obstacle.split(",");
            obstacles.add(new Rectangle(Double.parseDouble(obstacleDetails[0]),Double.parseDouble(obstacleDetails[1])
                    ,Double.parseDouble(obstacleDetails[3]),Double.parseDouble(obstacleDetails[2])));
        }
    }

    public void addObstaclesTo(Group root) throws FileNotFoundException {
        createDust2Obstacles();
        if (obstacles==null){
            System.err.println("no obstacle added!");
            return;
        }
        root.getChildren().addAll(obstacles);
    }
}
