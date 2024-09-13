/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_2;

/**
 *
 * @author nicol
 */
// Stores a character and its position in the "map" (screen).
public class MapObject implements Comparable<MapObject> {

    public Vector2D position;
    public char icon;
    public MapObjectType type;

    public MapObject(Vector2D position, char icon, MapObjectType type) {
        this.position = position;
        this.icon = icon;
        this.type = type;
    }

    // Comparison has to be done char-wise, not coordinate wise.
    @Override
    public int compareTo(MapObject o) {
        return Character.compare(this.icon, o.icon);
    }

    @Override
    public String toString() {
        return icon + " { " + position.x + ", " + position.y + " }";
    }
}
