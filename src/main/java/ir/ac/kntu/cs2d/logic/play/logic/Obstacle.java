package ir.ac.kntu.cs2d.logic.play.logic;

import java.io.Serializable;

public class Obstacle implements Serializable {
    private double X;
    private double Y;
    private double width;
    private double height;

    public Obstacle(double x, double y, double width, double height) {
        X = x;
        Y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
