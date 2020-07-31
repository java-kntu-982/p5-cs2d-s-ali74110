package ir.ac.kntu.cs2d.logic.play.logic;

import javafx.scene.shape.Rectangle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map implements Serializable{
    private List<Obstacle> obstacles;


    public Map() throws FileNotFoundException {
        obstacles = new ArrayList<>();
        readMap();
    }

    public void readMap() throws FileNotFoundException {
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
            obstacles.add(new Obstacle(Double.parseDouble(obstacleDetails[0]),Double.parseDouble(obstacleDetails[1])
                    ,Double.parseDouble(obstacleDetails[3]),Double.parseDouble(obstacleDetails[2])));
        }
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void dust2() throws IOException {
        List<Rectangle> rectangles = new ArrayList<>();

        Rectangle rec1 = new Rectangle(0,0,20,400);
        Rectangle rec2 = new Rectangle(20,0,120,20);
        Rectangle rec2_ = new Rectangle(140,0,160,5);
        Rectangle rec3 = new Rectangle(300,0,100,20);
        Rectangle rec3_ = new Rectangle(400,0,80,5);
        Rectangle rec4 = new Rectangle(480,0,20,70);
        Rectangle rec5 = new Rectangle(500,0,100,60);
        Rectangle rec6 = new Rectangle(600,0,200,100);


        Rectangle rec7 = new Rectangle(20,240,120,10);
        Rectangle rec8 = new Rectangle(130,200,10,40);
        Rectangle rec9 = new Rectangle(100,190,40,10);
        Rectangle rec10 = new Rectangle(100,150,10,40);
        Rectangle rec11 = new Rectangle(100,140,40,10);
        Rectangle rec12 = new Rectangle(130,100,10,40);
        Rectangle rec13 = new Rectangle(100,90,40,10);


        Rectangle rec14 = new Rectangle(260,50,100,80);
        Rectangle rec15 = new Rectangle(360,110,120,20);
        Rectangle rec16 = new Rectangle(420,130,60,120);
        Rectangle rec17 = new Rectangle(260,160,100,60);
        Rectangle rec18 = new Rectangle(300,220,60,90);
        Rectangle rec19 = new Rectangle(360,300,100,10);

        Rectangle rec20 = new Rectangle(560,200,50,120);

        Rectangle rec21 = new Rectangle(700,200,10,200);
        Rectangle rec22 = new Rectangle(550,380,150,20);
        Rectangle rec23 = new Rectangle(450,395,100,5);
        Rectangle rec24 = new Rectangle(250,360,200,40);
        Rectangle rec25 = new Rectangle(420,400,70,130);
        Rectangle rec26 = new Rectangle(440,530,30,50);
        Rectangle rec27 = new Rectangle(590,400,10,150);
        Rectangle rec28 = new Rectangle(590,550,100,30);

        Rectangle rec29 = new Rectangle(190,360,10,100);
        Rectangle rec30 = new Rectangle(190,460,130,10);
        Rectangle rec31 = new Rectangle(300,470,20,20);
        Rectangle rec32 = new Rectangle(190,470,80,80);
        Rectangle rec33 = new Rectangle(140,550,130,10);
        Rectangle rec34 = new Rectangle(220,560,50,50);

        Rectangle rec35 = new Rectangle(0,400,50,130);
        Rectangle rec36 = new Rectangle(0,530,30,60);
        Rectangle rec37 = new Rectangle(0,590,10,160);

        Rectangle rec38 = new Rectangle(0,750,300,50);
        Rectangle rec39 = new Rectangle(300,740,200,60);
        Rectangle rec40 = new Rectangle(500,610,50,190);
        Rectangle rec41 = new Rectangle(550,760,250,40);
        Rectangle rec42 = new Rectangle(790,100,10,660);

        rectangles.add(rec1);
        rectangles.add(rec2);
        rectangles.add(rec3);
        rectangles.add(rec3_);
        rectangles.add(rec2_);
        rectangles.add(rec4);
        rectangles.add(rec5);
        rectangles.add(rec6);
        rectangles.add(rec7);
        rectangles.add(rec8);
        rectangles.add(rec9);
        rectangles.add(rec10);
        rectangles.add(rec11);
        rectangles.add(rec12);
        rectangles.add(rec13);
        rectangles.add(rec14);
        rectangles.add(rec15);
        rectangles.add(rec16);
        rectangles.add(rec17);
        rectangles.add(rec18);
        rectangles.add(rec19);
        rectangles.add(rec20);
        rectangles.add(rec21);
        rectangles.add(rec22);
        rectangles.add(rec23);
        rectangles.add(rec24);
        rectangles.add(rec25);
        rectangles.add(rec26);
        rectangles.add(rec27);
        rectangles.add(rec28);
        rectangles.add(rec29);
        rectangles.add(rec30);
        rectangles.add(rec31);
        rectangles.add(rec32);
        rectangles.add(rec33);
        rectangles.add(rec34);
        rectangles.add(rec35);
        rectangles.add(rec36);
        rectangles.add(rec37);
        rectangles.add(rec38);
        rectangles.add(rec39);
        rectangles.add(rec40);
        rectangles.add(rec41);
        rectangles.add(rec42);
        writeMap(rectangles);
    }
    public void writeMap(List<Rectangle> rectangles) throws IOException {
        FileWriter fileWriter = new FileWriter("Dust2-cs2d.csv");
        BufferedWriter buff = new BufferedWriter(fileWriter);
        PrintWriter pr = new PrintWriter(buff);
        pr.println(rectangles.size());
        for (Rectangle rec : rectangles){
            pr.println(rec.getX() +","+rec.getY()+","+rec.getHeight()+","+rec.getWidth());
        }

        fileWriter.close();
    }
}
