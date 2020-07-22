package ir.ac.kntu.cs2d.logic.play.logic;

public class Aim {
    private double x ;
    private double y ;
    private double radius;


    public Aim(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX1(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY1(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}