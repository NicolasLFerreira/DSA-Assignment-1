/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JPanel;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel implements KeyListener {

    // Synchronisation
    boolean inSync;

    // Ships and ports
    final int number_ship;
    Ship[] ships;
    Port port;

    Image ship_image;
    Image island_image;
    Image boat_island_image;

    // Stores which ships were already spawned before.
    HashMap<Integer, Boolean> cemetery;

    public Panel() {
        // graphics boilerplate
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setBackground(Color.WHITE);


        // ############################
        // # SET SYNCHRONISATION MODE #
        // ############################
        /* >>> */ inSync = false; // <<<
        // ############################
        // # SET SYNCHRONISATION MODE #
        // ############################

        // ships and ports initialisation
        number_ship = 20;
        ships = new Ship[number_ship];
        cemetery = new HashMap<>(number_ship);

        port = new Port(900, 500);

        // Creates all the ships and the cemetery entry
        for (int i = 0; i < number_ship; i++) {
            cemetery.put(i, false);
            ships[i] = new Ship(20, i * 50, i, port, inSync, cemetery);
        }

        //Please do not change the path of images physically and in code
        ship_image = new ImageIcon("boat.png").getImage();
        island_image = new ImageIcon("land.png").getImage();
        boat_island_image = new ImageIcon("boat_land.png").getImage();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // iterates through the ships to see which one ahs to be printed
        for (Ship ship : ships) {
            if (!ship.position.equals(port.position)) {
                // if the ship is "off"
                if (ship.isVisible()) {
                    g.drawImage(ship_image, ship.position.x, ship.position.y, this);
                }
            }
        }

        // displays on the top which mode it's running
        g.drawString("Running in: " + (inSync ? "sync" : "unsync") + " mode", 450, 20);

        // checks to see what image for the port has to be printed 
        Image toPrint;
        if (port.occupied()) {
            toPrint = boat_island_image;
        } else {
            toPrint = island_image;
        }
        g.drawImage(toPrint, port.position.x, port.position.y, this);

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        // gets the space bar input
        
        if (!cemetery.containsValue(false)) return;
        
        int s = randomShip();

        int key = (int) ke.getKeyChar();
        if (key == 32) {
            if (!ships[s].isAlive()) {
                ships[s].start();
                System.out.println(ships[s].name);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    public int randomShip() {
        // makes sure to select a random ship that hasn't been used before
        int r;

        do {
            r = ThreadLocalRandom.current().nextInt(number_ship);
        } while (ships[r] == null || cemetery.get(r));

        return r;
    }
}
