/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_2;

/**
 *
 * @author nicol
 */
// Makes working with the x and y of segments easier.
public class Vector2D {

    public int x;
    public int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D coords) {
        this.x = coords.x;
        this.y = coords.y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Vector2D vector = (Vector2D) obj;
        
        if (this.x == vector.x && this.y == vector.y) {
            return true;
        }

        return this.x == vector.x && this.y == vector.y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.x;
        hash = 17 * hash + this.y;
        return hash;
    }
    
    @Override
    public String toString(){
        return "{ " + x + ", " + y + " }";
    }
}
