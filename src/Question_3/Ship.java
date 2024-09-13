/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /* 
Which object have you chosen as a monitor object to synchronize your code?
The "port" object in the panel class.


Why did you choose that object as a monitor oject to synchronize your code?
Because it's the one resource that every Ship instance shares and could be used as a lock.

 */
package Question_3;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xhu
 */
public class Ship extends Thread {

    // Ship's properties
    public Vector2D position;
    public final String name;
    public final int id;

    // Synchronization stuff
    private final boolean synchronizedMode;
    private boolean canMove;

    // Display stuff
    private boolean visible;

    // Outside references
    private final Port port;
    private final HashMap<Integer, Boolean> cemetery;

    public Ship(int x, int y, int id, Port port, boolean synchronizedMode, HashMap<Integer, Boolean> cemetery) {
        this.name = "Ship" + id;
        this.position = new Vector2D(x, y);
        this.id = id;

        // outside stuff
        this.port = port;
        this.cemetery = cemetery;

        // Sync related properties
        this.synchronizedMode = synchronizedMode;
        this.canMove = true;
        this.visible = true;
    }

    @Override
    public void run() {
        this.cemetery.put(id, true);
        while (canMove) {
            if (synchronizedMode) {
                synchronized (port) {
                    move();
                    isAvailable();
                }
            } else {
                move();
                isAvailable();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void move() {
        // gets the direction (e.g. [1, 1])
        // basically it's a factor which the ship's speed will
        // be multiplied by to set its direction
        Vector2D dir = port.position.difference(position).direction();

        // moves the ship until it's coords are the same as the
        // port's
        if (port.position.x != this.position.x) {
            position.x += dir.x * 10;
        }
        if (port.position.y != this.position.y) {
            position.y += dir.y * 10;
        }
    }

    public boolean isVisible() {
        return visible;
    }

    private void isAvailable() {
        // Checks if the ship and port are in the same pos
        if (position.equals(port.position)) {
            // if in sync mode
            if (synchronizedMode) {
                try {
                    System.out.println(name + " arrived at port. 1 second wait");
                    port.landShip(this);
                    Thread.sleep(1000);
                    port.clearShip();
                    System.out.println(name + " left the port");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
                }
                // not sync mode
            } else {
                // crashes if there's a ship on the port.
                if (port.occupied()) {
                    System.out.println(name + " crashed");
                } else {
                    try {
                        // do normal stuff otherwise
                        System.out.println(name + " arrived at port. 1 second wait");
                        port.landShip(this);
                        Thread.sleep(1000);
                        port.clearShip();
                        System.out.println(name + " left port");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ship.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            // deactivates the ship and sends it to outside the screen
            this.canMove = false;
            this.position.add(10000, 10000);
            this.visible = false;
        }
    }
}
