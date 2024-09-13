/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel implements KeyListener {

    Game map;

    private final Vector2D bounds;
    private final Vector2D movement;

    public Panel(int sizex, int sizey) {
        this.addKeyListener(this);
        this.setFocusable(true);

        bounds = new Vector2D(sizex, sizey);
        movement = new Vector2D(0, 0);
        map = new Game(sizex, sizey);
    }

    @Override
    public void paint(Graphics g) {
        map.run(movement);

        paintComponent(g);

        // If the player lost:
        if (map.lose) {
            g.drawString("Game finshed", bounds.x / 2 - 40, bounds.y / 2 - 40);
            repaint();
        } else {

            // Handles the graphical output.
            MapObject current;
            for (int i = 0; i < map.snake.size(); i++) {
                current = map.snake.get(i);
                g.drawString(current.icon + "", current.position.x, current.position.y);
            }

            for (int i = 0; i < map.obstacles.numbers.length; i++) {
                current = map.obstacles.numbers[i];
                g.drawString(current.icon + "", current.position.x, current.position.y);
            }

            g.drawString(map.food.icon + "", map.food.position.x, map.food.position.y);

            
            //**********************************************************************
        }
        try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //example code of getting the pressed key
        System.out.println("\"" + ke.getKeyChar() + "\" is typed.");
        //example code of getting control by key pressed.
        //you may modify the code below to control your snake

        // HAD TO ADD SUPPORT TO CAPS KEYS.
        if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyChar() == 'w' || ke.getKeyChar() == 'W') {
            movement.y = -10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyChar() == 's' || ke.getKeyChar() == 'S') {
            movement.y = 10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A') {
            movement.x = -10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D') {
            movement.x = 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        movement.set(0, 0);
    }
}
