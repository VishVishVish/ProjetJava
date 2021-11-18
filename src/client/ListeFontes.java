/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
import java.awt.BorderLayout;

public class ListeFontes extends JFrame {
    
    public ListeFontes() {
    GraphicsEnvironment gE = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] liste = gE.getAvailableFontFamilyNames();
    JLabel label;
    JPanel panneau = new JPanel();

    panneau.setLayout(new GridLayout(20, 0, 10, 0));
    for (String nom : liste) {
           label = new JLabel();
           label.setFont(new Font(nom, Font.PLAIN, 18));
           label.setText(nom);
           panneau.add(label);
    } 
    add(new JScrollPane(panneau), BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setLocation(100, 100);
    setVisible(true);
    }
    
    public static void main(String[] args) {
        new ListeFontes();
    }
}


