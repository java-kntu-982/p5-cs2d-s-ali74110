package ir.ac.kntu.cs2d.logic.play.logic;

import java.io.Serializable;

public class Camera implements Serializable {
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
