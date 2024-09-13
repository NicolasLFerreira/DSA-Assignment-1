/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_3;

/**
 *
 * @author nicol
 */
// COPIED MOST OF THIS FROM MY OWN CODE IN PART 2.
// I PERSONALLY ALWAYS USE A VECTOR2D CLASS WHENEVER I WORK WITH A COORDINATE SYSTEM IN ANY PROJECT.
public class Vector2D {

    public int x;
    public int y;

    public Vector2D(int x, int y) {
        set(x, y);
    }

    public final void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D vector) {
        x = vector.x;
        y = vector.y;
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    // difference between this and another vector.
    // "this"'s position has to be absolute to get the actual absolute difference
    public Vector2D difference(Vector2D vector) {
        return new Vector2D(Math.abs(this.x) - vector.x, Math.abs(this.y) - vector.y);
    }

    // gets the direction to which the ship's coordinations are 
    // "pointed" based on [0, 0]
    public Vector2D direction() {
        // ternary solution
//        int nx = (xz > 0) ? 1 : (x < 0) ? -1 : 0;
//        int ny = (y > 0) ? 1 : (y < 0) ? -1 : 0;

        // this solution is cooler i think
        int nx = (x / Math.max(Math.abs(x), 1));
        int ny = (y / Math.max(Math.abs(y), 1));

        return new Vector2D(nx, ny);
    }

    // stuff from the vectorclass from my question 2 solution.
    // still being used
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
    public String toString() {
        return "{ " + x + ", " + y + " }";
    }
}
