package cl.uchile.dcc.cc5303;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainThread extends Thread{

    public boolean[] keys;
    private final static String TITLE = "Juego - CC5303";

    private final static int WIDTH = 800, HEIGHT = 800;
    private final static int UPDATE_RATE = 30;
    private final static int GROW_RATE = 30;
    private final static int MOVE_RATE = 5;

    private JFrame frame;
    private Board tablero;
    private Player player1, player2;

    public MainThread() {
        keys = new boolean[KeyEvent.KEY_LAST];

        //Jugadores
        player1 = new Player(new Point(WIDTH/3, 550));
        player2 = new Player(new Point(2*WIDTH/3, 550));

        frame = new JFrame(TITLE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tablero = new Board(WIDTH, HEIGHT);
        tablero.p1 = player1;
        tablero.p2 = player2;

        frame.add(tablero);
        tablero.setSize(WIDTH, HEIGHT);

        frame.pack();
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                keys[e.getKeyCode()] = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keys[e.getKeyCode()] = false;
            }
        });

    }

    @Override
    public void run() {
        int frames = 0;
        while (true) { // Main loop
            // Controles
            if (keys[KeyEvent.VK_UP]) {
                tablero.p1.moveUp();
            }
            if (keys[KeyEvent.VK_DOWN]) {
                tablero.p1.moveDown();
            }

            if (keys[KeyEvent.VK_W]) {
                tablero.p2.moveUp();
            }
            if (keys[KeyEvent.VK_S]) {
                tablero.p2.moveDown();
            }


            ++frames;
            if (frames%MOVE_RATE == 0){
                tablero.p1.update();
                tablero.p2.update();
            }
            if (frames == GROW_RATE){
                tablero.p1.growUp();
                tablero.p2.growUp();
                frames = 0;
            }
            System.out.println(tablero.p1);

            // Tablero
            tablero.repaint();

            try {
                this.sleep(1000 / UPDATE_RATE);
            } catch (InterruptedException ex) {

            }
        }
    }
}
