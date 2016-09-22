package cl.uchile.dcc.cc5303;

import java.awt.*;
import java.util.ArrayList;

public class Player {

    public ArrayList<Point> body;

    public Player(Point point) {
        this.body = new ArrayList<Point>();
        this.body.add(point);
    }

    public void update(){
        int lastAngle;
        int newAngle = this.body.get(0).angle;;
        for (Point p : this.body){
            lastAngle = p.angle;
            p.angle = newAngle;
            newAngle = lastAngle;
            p.move();
        }
    }

    public void draw(Graphics graphics) {
        for (Point p : this.body)
            graphics.fillOval(p.x, p.y, 5, 5);
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
        Point tail = this.body.get(this.body.size()-1);
        this.body.add(tail.getShadow());
    }
}
