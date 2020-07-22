package ir.ac.kntu.cs2d.logic.play.logic;

public class Camera {
    private double translateX ;
    private double translateY ;

    public void setTranslateX(double translateX) {
        this.translateX = translateX;
    }

    public void setTranslateY(double translateY) {
        this.translateY = translateY;
    }

    public double getTranslateX() {
        return translateX;
    }

    public double getTranslateY() {
        return translateY;
    }
}
