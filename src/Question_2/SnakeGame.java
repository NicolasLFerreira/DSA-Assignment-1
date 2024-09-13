/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author xhu
 */
public class SnakeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Snake");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int sizex = 750;
        int sizey = 750;

        JPanel panel = new Panel(sizex, sizey);
        panel.setPreferredSize(new Dimension(sizex, sizey));
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}
