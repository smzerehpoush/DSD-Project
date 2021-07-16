package me.mahdiyar;


public class FloatPoint {

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    private double x;
    private double y;

    public FloatPoint() {
        x = 0.0D;
        y = 0.0D;
    }
}
