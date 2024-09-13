/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_2;

/**
 *
 * @author nicol
 */
public enum MapObjectType {
    // Defines the type and its character bounds
    SNAKE('@', 'Z'), // 64 - 90 / @ - Z
    FOOD('A', 'Z'), // 65 - 90 / A - Z
    OBSTACLE('0', '9'); // 48 - 57 / 0 - 9

    // Public members for easy access
    public final char lower;
    public final char upper;

    private MapObjectType(char lower, char upper) {
        this.lower = lower;
        this.upper = upper;
    }
}
