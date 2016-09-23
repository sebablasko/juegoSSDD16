package cl.uchile.dcc.cc5303;

import java.util.Random;

public class Point {
    public int x,y;
    public int angle;
    public boolean visible;

    public static final int dHip = 8;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.angle = 0;
        this.visible = true;
    }

    public Point(int x, int y, int angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.visible = true;
    }

    public Point(int x, int y, int angle, boolean visible) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.visible = visible;
    }

    public Point(int x, int y, boolean visible) {
        this.x = x;
        this.y = y;
        this.angle = 0;
        this.visible = visible;
    }

    public void move() {
        this.x = (int) (this.x + dHip*Math.cos(Math.toRadians(this.angle)));
        this.y = (int) (this.y + dHip*Math.sin(Math.toRadians(this.angle)));
    }

    public Point getShadow(){
        int newX = (int) (this.x - dHip*Math.cos(Math.toRadians(this.angle)));
        int newY = (int) (this.y - dHip*Math.sin(Math.toRadians(this.angle)));
        Random random = new Random();
        if (random.nextFloat() <= 0.2)
            return new Point(newX, newY, this.angle, false);
        return new Point(newX, newY, this.angle);
    }
}

