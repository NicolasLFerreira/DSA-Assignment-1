/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_2;

/**
 *
 * @author nicol
 */
public class Game {

    Vector2D bounds;

    public Snake snake;
    public MapObject food;
    public Obstacles obstacles;
    
    public boolean lose = false;

    public Game(int sizex, int sizey) {
        this.bounds = new Vector2D(sizex, sizey);

        this.snake = new Snake(300, 300);
        this.food = generateFood();
        this.obstacles = new Obstacles(sizex, sizey);
    }

    public void run(Vector2D movement) {

        boolean moved = Math.abs(movement.x) + Math.abs(movement.y) != 0;

        // Advance the body
        if (moved) {
//            System.out.println("head: " + snake.head().position);
            for (int i = snake.size() - 1; i > 0; i--) {
                snake.get(i).position.set(snake.get(i - 1).position);
            }
        }

        // If the snake reaches the bounds, loop around.
        Vector2D snakeHead = snake.head().position;
        if (snakeHead.x + movement.x >= bounds.x || snakeHead.x + movement.x <= 0) {
            snakeHead.x = Math.abs(snakeHead.x - bounds.x);
        }
        if (snakeHead.y + movement.x >= bounds.y || snakeHead.y + movement.y <= 0) {
            snakeHead.y = Math.abs(snakeHead.y - bounds.y);
        }

        // Advance the head
        snake.head().position.add(movement.x, movement.y);

        // Checks and handles collisions.
        if (moved) {
            handleCollision();
        }
    }

    public void handleCollision() {
        Vector2D head = snake.head().position;

        if (obstacles.check(head)) {
            System.out.println("Collision @: " + head);
            if (snake.size() <= 1) lose = true;
            snake.removeAt(obstacles.consume(head));
            return;
        }

        if (head.equals(food.position)) {
            System.out.println("Increasing size");
            snake.add(food);
            food = generateFood();
        }
    }

    private MapObject generateFood() {
        MapObjectType ot = MapObjectType.FOOD;
        MapObject o = new MapObject(Generator.vector(bounds), (char) Generator.integer(ot.lower, ot.upper), ot);

        return o;
    }
}
