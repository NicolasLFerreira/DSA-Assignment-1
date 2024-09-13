/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_2;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author nicol
 */
public class Generator {

    // Generates random ints
    public static int integer(Vector2D bounds) {
        return integer(bounds.x, bounds.y);
    }

    public static int integer(int upper) {
        return integer(0, upper);
    }

    public static int integer(int lower, int upper) {
        return ThreadLocalRandom.current().nextInt(lower, upper);
    }

    // Vector generation
    public static Vector2D vector(Vector2D bounds) {
        int xt, yt;
        int x, y;

        xt = Generator.integer(bounds.x);
        x = xt - (xt % 10);

        yt = Generator.integer(bounds.y);
        y = yt - (yt % 10);

        return new Vector2D(x, y);
    }
}
