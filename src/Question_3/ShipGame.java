/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_3;

import javax.swing.JFrame;

/**
 *
 * @author xhu
 */
public class ShipGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Java Paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();

        frame.getContentPane().add(panel);
        frame.setSize(1000, 1050);
        frame.setVisible(true);
    }

}
