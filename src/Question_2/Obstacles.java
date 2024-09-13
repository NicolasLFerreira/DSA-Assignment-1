/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_2;

import java.util.HashMap;

/**
 *
 * @author nicol
 */
public class Obstacles {

    private final int SIZE = 10;

    private final Vector2D bounds;

    // Deciding to use a hashmap for quick look up if something exits;
    public final MapObject[] numbers;
    private final HashMap<Vector2D, Integer> registryTable;

    public Obstacles(int x, int y) {
        this.bounds = new Vector2D(x, y);
        this.numbers = new MapObject[SIZE];
        this.registryTable = new HashMap<>(SIZE);

        MapObject current;
        for (int i = 0; i < SIZE; i++) {
            current = generate();
            System.out.println(current.icon + " " + current.position);
            this.numbers[i] = current;
            this.registryTable.put(current.position, i);
        }
    }

    // Public access methods.
    public boolean check(Vector2D position) {
        return registryTable.containsKey(position);
    }

    public int consume(Vector2D position) {
        // index of the object that collided
        int index = registryTable.get(position);
        // get the object
        int value = numbers[registryTable.get(position)].icon - '0';

        this.numbers[index] = generate();
        registryTable.put(this.numbers[index].position, index);
        registryTable.remove(position);

        return value;
    }

    // Methods for generating the necessary data
    private MapObject generate() {
        MapObjectType ot = MapObjectType.OBSTACLE;
        MapObject o = new MapObject(
                Generator.vector(bounds),
                (char) (Generator.integer(ot.lower, ot.upper)),
                MapObjectType.OBSTACLE
        );

        return o;
    }
}
