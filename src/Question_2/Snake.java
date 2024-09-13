/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import Question_1.*;

/**
 *
 * @author xhu
 */
public class Snake {

    LinkedList<MapObject> body;

    Snake(int x, int y) {
        body = new LinkedList<>();

        // Initiates the snake's head.
        body.addHead(new MapObject(new Vector2D(x, y), '@', MapObjectType.SNAKE));
    }

    public MapObject head() {
        return body.head.data;
    }

    public MapObject get(int i) {
        return (MapObject) body.getNode(i).data;
    }

    public MapObject getTail() {
        return (MapObject) body.getNode(body.size - 1).data;
    }

    public void add(MapObject segment) {
        body.addInOrder(segment);
    }

    public void remove() {
        body.removeFromTail();
    }

    public void removeAt(int index) {
        index++;
        if (body.size == 1) {
            return;
        }
        if (index > body.size) {
            remove();
            return;
        }
        body.remove(index);
    }

    public int size() {
        return body.size;
    }

    public void run() {

    }
}
