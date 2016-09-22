package cl.uchile.dcc.cc5303;

public class Point {
    public int x,y;
    public int angle;
    public boolean visible;


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

    public Point(int x, int y, boolean visible) {
        this.x = x;
        this.y = y;
        this.angle = 0;
        this.visible = visible;
    }

    public void move() {
        this.x = (int) (this.x + 1.5*Math.cos(Math.toRadians(this.angle)));
        this.y = (int) (this.y + 1.5*Math.sin(Math.toRadians(this.angle)));
    }

    public Point getShadow(){
        int newX = (int) (this.x - 1.5*Math.cos(Math.toRadians(this.angle)));
        int newY = (int) (this.y - 1.5*Math.sin(Math.toRadians(this.angle)));
        return new Point(newX, newY, this.angle);
    }
}

