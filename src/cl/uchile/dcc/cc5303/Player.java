package cl.uchile.dcc.cc5303;

import java.awt.*;
import java.util.ArrayList;

public class Player {

    public static final int size = 8;


    public ArrayList<Point> body;

    public Player(Point point) {
        this.body = new ArrayList<Point>();
        this.body.add(point);
    }

    public void update(){
        int lastAngle;
        int newAngle = this.body.get(0).angle;
        for (Point p : this.body){
            p.move();
            lastAngle = p.angle;
            p.angle = newAngle;
            newAngle = lastAngle;
        }
    }

    public void draw(Graphics graphics) {
        for (Point p : this.body)
            if (p.visible)
                graphics.fillOval(p.x + size/2, p.y + size/2, size, size);
    }

    public void moveUp() {
        Point head = this.body.get(0);
        head.angle = (head.angle + 10) % 360;
    }

    public void moveDown() {
        Point head = this.body.get(0);
        head.angle = (head.angle - 10) % 360;
    }

    public void growUp() {
        Point tail = this.body.get(this.body.size() - 1);
        this.body.add(tail.getShadow());
    }

    @Override
    public String toString() {
        return this.body.get(0).angle + " " + this.body.get(0).x + " " + this.body.get(0).y;
    }
}
