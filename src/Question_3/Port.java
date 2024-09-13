/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

/**
 *
 * @author xhu
 */
public class Port {

    public Vector2D position;
    public final String name = "Port";

    private Ship ship;

    public Port(int x, int y) {
        this.position = new Vector2D(x, y);
    }

    public void landShip(Ship ship) {
        this.ship = ship;
    }

    public void clearShip() {
        ship = null;
    }

    public boolean occupied() {
        return ship != null;
    }
}
